package br.com.brasileirao.campeonato.model;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Brasileirao implements Serializable {

    private Integer id;
    private Integer session;
    private Integer place;
    private String team;
    private Integer points;
    private Integer played;
    private Integer won;
    private Integer draw;
    private Integer loss;
    private Integer goals;
    private Integer goalsTaken;
    private Integer goalsDiff;

}
