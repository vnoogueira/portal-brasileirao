package br.com.brasileirao.campeonato.controller;

import br.com.brasileirao.campeonato.model.Brasileirao;
import br.com.brasileirao.campeonato.service.BrasileiraoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/campeonato/brasileirao")
public class BrasileiraoController {

    @Autowired
    private BrasileiraoService service;

    @GetMapping
    public ResponseEntity<List<Brasileirao>> findAll(){
        List<Brasileirao> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Brasileirao> findById(@PathVariable Long id){
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/team/{team}")
    public ResponseEntity<List<Brasileirao>> findTeamByTeam(@PathVariable String team){
        String nameOfTeam = team.substring(0, 1).toUpperCase() + team.substring(1).toLowerCase();
        List<Brasileirao> teamName = service.findByTeam(nameOfTeam);
        return ResponseEntity.ok().body(teamName);
    }
}
