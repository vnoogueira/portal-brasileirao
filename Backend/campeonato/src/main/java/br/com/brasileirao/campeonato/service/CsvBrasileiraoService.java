package br.com.brasileirao.campeonato.service;

import br.com.brasileirao.campeonato.model.Brasileirao;
import br.com.brasileirao.campeonato.repository.BrasileiraoRepository;
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
public class CsvBrasileiraoService {

    @Autowired
    private BrasileiraoRepository brasileiraoRepository;

    public void saveBrasileiraoFromCsv(MultipartFile file) throws IOException {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())
        ) {
            List<Brasileirao> list = new ArrayList<>();

            for (CSVRecord record : csvParser) {
                Brasileirao brasileirao = new Brasileirao();
                brasileirao.setSeason(Integer.parseInt(record.get("season")));
                brasileirao.setPlace(Integer.parseInt(record.get("place")));
                brasileirao.setTeam(record.get("team"));
                brasileirao.setPoints(Integer.parseInt(record.get("points")));
                brasileirao.setPlayed(Integer.parseInt(record.get("played")));
                brasileirao.setWon(Integer.parseInt(record.get("won")));
                brasileirao.setDraw(Integer.parseInt(record.get("draw")));
                brasileirao.setLoss(Integer.parseInt(record.get("loss")));
                brasileirao.setGoals(Integer.parseInt(record.get("goals")));
                brasileirao.setGoalsTaken(Integer.parseInt(record.get("goals_taken")));
                brasileirao.setGoalsDiff(Integer.parseInt(record.get("goals_diff")));

                list.add(brasileirao);
            }

            brasileiraoRepository.saveAll(list);
        }
    }
}
