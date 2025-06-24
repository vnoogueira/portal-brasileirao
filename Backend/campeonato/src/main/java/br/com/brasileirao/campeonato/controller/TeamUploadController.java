package br.com.brasileirao.campeonato.controller;

import br.com.brasileirao.campeonato.service.CsvTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

@RestController
@RequestMapping("/api/teams")
public class TeamUploadController {

    @Autowired
    private CsvTeamService csvTeamService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadCsv(@RequestParam("file")MultipartFile file){
        if(file.isEmpty() || !Objects.equals(file.getContentType(), "text/csv")){
            return ResponseEntity.badRequest().body("Arquivo Inválido. Envie um arquivo valido");
        }

        try{
            csvTeamService.saveTeamsFromCsv(file);
            return ResponseEntity.ok("Upload e salvamento realizdo com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao processar o arquivo: " + e.getMessage());
        }
    }
}
