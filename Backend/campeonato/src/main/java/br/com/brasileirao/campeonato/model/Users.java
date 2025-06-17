package br.com.brasileirao.campeonato.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
public class Users implements Serializable {

    @Id
    private Integer id;
    private String fullName;
    private String email;
    private String password;
}
