package br.com.brasileirao.campeonato.controller;

import br.com.brasileirao.campeonato.model.Brasileirao;
import br.com.brasileirao.campeonato.service.BrasileiraoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
