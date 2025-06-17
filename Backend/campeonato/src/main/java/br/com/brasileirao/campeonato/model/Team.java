package br.com.brasileirao.campeonato.model;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Team implements Serializable {

    private Integer id;
    private String team;
    private String acronym;
    private String full_name;
    private Integer founded;
    private String stadium;
    private String city;
    private String state;
    private String region;
}
