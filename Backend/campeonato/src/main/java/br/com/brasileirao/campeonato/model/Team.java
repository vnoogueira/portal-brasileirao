package br.com.brasileirao.campeonato.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "teams", schema = "public")
public class Team implements Serializable {

    @Id
    private Long id;
    private String team;
    private String acronym;
    @Column(name = "full_name")
    private String fullName;
    private Integer founded;
    private String stadium;
    private String city;
    private String state;
    private String region;

    public Team(){

    }

    public Team(Long id, String team, String acronym, String fullName, Integer founded, String stadium, String city, String state, String region) {
        this.id = id;
        this.team = team;
        this.acronym = acronym;
        this.fullName = fullName;
        this.founded = founded;
        this.stadium = stadium;
        this.city = city;
        this.state = state;
        this.region = region;
    }

    public Long getId() {
        return id;
    }

    public String getTeam() {
        return team;
    }

    public String getAcronym() {
        return acronym;
    }

    public String getFullName() {
        return fullName;
    }

    public Integer getFounded() {
        return founded;
    }

    public String getStadium() {
        return stadium;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getRegion() {
        return region;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setFounded(Integer founded) {
        this.founded = founded;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(id, team.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
