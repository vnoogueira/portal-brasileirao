package br.com.brasileirao.campeonato.service;

import br.com.brasileirao.campeonato.model.RefreshToken;
import br.com.brasileirao.campeonato.repository.RefreshTokenRepository;
import br.com.brasileirao.campeonato.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class RefreshTokenService {

    @Value("${jwt.refresh-token.expiration}")
    private Long refreshTokenDurationMs;

    private RefreshTokenRepository refreshTokenRepository;
    private UsersRepository usersRepository;

    public RefreshTokenService(RefreshTokenRepository refreshTokenRepository, UsersRepository usersRepository) {
        this.refreshTokenRepository = refreshTokenRepository;
        this.usersRepository = usersRepository;
    }

    public RefreshToken createRefreshToken(Long userId) {
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setUsers(usersRepository.findById(userId).orElseThrow());
        refreshToken.setToken(UUID.randomUUID().toString());
        refreshToken.setExpirationDate(new Date(System.currentTimeMillis() + refreshTokenDurationMs));
        return refreshTokenRepository.save(refreshToken);
    }

    public boolean isTokenExpired(RefreshToken token) {
        return token.getExpirationDate().before(new Date());
    }

    public void deleteByUserId(Long userId) {
        refreshTokenRepository.deleteByUsersId(userId);
    }

    public Optional<RefreshToken> findByToken(String token) {
        return refreshTokenRepository.findByToken(token);
    }
}
