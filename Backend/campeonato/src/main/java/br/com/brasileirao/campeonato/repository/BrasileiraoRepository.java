package br.com.brasileirao.campeonato.repository;

import br.com.brasileirao.campeonato.model.Brasileirao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrasileiraoRepository extends JpaRepository<Brasileirao, Integer> {
}
