package br.com.brasileirao.campeonato.service;

import br.com.brasileirao.campeonato.model.Team;
import br.com.brasileirao.campeonato.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetTime;
import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    private TeamRepository repository;

    @Transactional(readOnly = true)
    public List<Team> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Team> findById(Long id) {
        Optional<Team> team = repository.findById(id);
        return team;
    }

    @Transactional(readOnly = true)
    public Optional<Team> findByTeam(String team) {
        Optional<Team> name = repository.findByTeam(team);
        return name;
    }

}
