package br.com.brasileirao.campeonato.repository;

import br.com.brasileirao.campeonato.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
}
