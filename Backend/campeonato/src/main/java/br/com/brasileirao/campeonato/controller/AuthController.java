package br.com.brasileirao.campeonato.controller;

import br.com.brasileirao.campeonato.auth.AuthenticationRequest;
import br.com.brasileirao.campeonato.auth.AuthenticationResponse;
import br.com.brasileirao.campeonato.model.Users;
import br.com.brasileirao.campeonato.repository.RoleRepository;
import br.com.brasileirao.campeonato.repository.UsersRepository;
import br.com.brasileirao.campeonato.security.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UsersRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final RoleRepository roleRepository;

    public AuthController(
            AuthenticationManager authenticationManager,
            UsersRepository userRepository,
            PasswordEncoder passwordEncoder,
            JwtService jwtService,
            RoleRepository roleRepository
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.roleRepository = roleRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getpassword())
            );
            var user = userRepository.findByEmail(request.getEmail())
                    .orElseThrow(() -> new RuntimeException("User not found"));

            String jwtToken = jwtService.generateToken(user);
            return ResponseEntity.ok(new AuthenticationResponse(jwtToken));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).build();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody AuthenticationRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().build();
        }

        var userRoles = roleRepository.findByName("ROLE_USER").orElseThrow(() -> new RuntimeException("Permission not found"));

        var newUser = new Users();
        newUser.setEmail(request.getEmail());
        newUser.setPassword(passwordEncoder.encode(request.getpassword()));
        newUser.setName(request.getName());
        newUser.setRoles(List.of(userRoles));
        newUser.setCreatedAt(new Date());
        newUser.setUpdatedAt(new Date());

        userRepository.save(newUser);

        String jwtToken = jwtService.generateToken(newUser);

        return ResponseEntity.ok(new AuthenticationResponse(jwtToken));
    }
}
