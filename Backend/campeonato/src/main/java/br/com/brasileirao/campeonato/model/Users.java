package br.com.brasileirao.campeonato.model;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Users implements Serializable {

    private Integer id;
    private String fullName;
    private String email;
    private String password;
}
