package br.com.brasileirao.campeonato.controller;

import br.com.brasileirao.campeonato.model.Team;
import br.com.brasileirao.campeonato.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/campeonato/brasileirao/teams")
public class TeamController {

    @Autowired
    private TeamService service;

    @GetMapping
    public ResponseEntity<List<Team>> findAll(){
        List<Team> teamList = service.findAll();
        return ResponseEntity.ok().body(teamList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Team>> findTeamById(@PathVariable Long id){
        Optional<Team> team = service.findById(id);
        return ResponseEntity.ok().body(team);
    }

    @GetMapping("/name/{team}")
    public ResponseEntity<Optional<Team>> findTeamByName(@PathVariable String team){
        String nameOfTeam = team.substring(0, 1).toUpperCase() + team.substring(1).toLowerCase();
        Optional<Team> name = service.findByTeam(nameOfTeam);
        return ResponseEntity.ok().body(name);
    }
}
