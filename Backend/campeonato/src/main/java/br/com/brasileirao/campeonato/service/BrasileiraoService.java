package br.com.brasileirao.campeonato.service;

import br.com.brasileirao.campeonato.model.Brasileirao;
import br.com.brasileirao.campeonato.repository.BrasileiraoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BrasileiraoService {

    @Autowired
    private BrasileiraoRepository repository;

    @Transactional(readOnly = true)
    public List<Brasileirao> findAll() {
        return repository.findAll();
    }
}

