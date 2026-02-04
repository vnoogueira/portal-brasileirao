package br.com.brasileirao.campeonato.repository;

import br.com.brasileirao.campeonato.model.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

    Optional<RefreshToken> findByToken(String token);

    void deleteByUsersId(Long userId);
}
