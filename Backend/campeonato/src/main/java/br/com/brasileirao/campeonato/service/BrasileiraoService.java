package br.com.brasileirao.campeonato.service;

import br.com.brasileirao.campeonato.model.Brasileirao;
import br.com.brasileirao.campeonato.repository.BrasileiraoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BrasileiraoService {

    @Autowired
    private BrasileiraoRepository repository;

    @Transactional(readOnly = true)
    public List<Brasileirao> findAll() {
        return repository.findAll();
    }

    public Optional<Brasileirao> findById(Long id) {
        Optional<Brasileirao> brasileiraoId =  repository.findById(id);
        return brasileiraoId;
    }

    public List<Brasileirao> findByTeam(String team) {
        List<Brasileirao> teamName = repository.findByTeam(team);
        return teamName;
    }
}

