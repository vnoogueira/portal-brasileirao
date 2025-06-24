package br.com.brasileirao.campeonato.service;

import br.com.brasileirao.campeonato.model.Team;
import br.com.brasileirao.campeonato.repository.TeamRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class CsvTeamService {

    @Autowired
    private TeamRepository teamRepository;

    public void saveTeamsFromCsv(MultipartFile file) throws IOException {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())
        ) {
            List<Team> teams = new ArrayList<>();

            for (CSVRecord record : csvParser) {
                Team team = new Team();
                team.setTeam(record.get("team"));
                team.setAcronym(record.get("acronym"));
                team.setFullName(record.get("full_name"));
                team.setFounded(Integer.parseInt(record.get("founded")));
                team.setStadium(record.get("stadium"));
                team.setCity(record.get("city"));
                team.setState(record.get("state"));
                team.setRegion(record.get("region"));

                teams.add(team);
            }

            teamRepository.saveAll(teams);
        }
    }
}
