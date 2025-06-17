package br.com.brasileirao.campeonato.repository;

import br.com.brasileirao.campeonato.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {
}
