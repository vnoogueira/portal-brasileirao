package br.com.brasileirao.campeonato.repository;

import br.com.brasileirao.campeonato.model.Brasileirao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BrasileiraoRepository extends JpaRepository<Brasileirao, Long> {

    List<Brasileirao> findByTeam(String team);

}
