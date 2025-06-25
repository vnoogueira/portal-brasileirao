package br.com.brasileirao.campeonato.controller;

import br.com.brasileirao.campeonato.service.CsvBrasileiraoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

@RestController
@RequestMapping("/api/brasileirao")
public class BrasileiraoUploadController {

    @Autowired
    private CsvBrasileiraoService csvBrasileiraoService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadCsv(@RequestParam("file")MultipartFile file){
        if(file.isEmpty() || !Objects.equals(file.getContentType(), "text/csv")){
            return ResponseEntity.badRequest().body("Arquivo Inválido. Envie um arquivo valido");
        }

        try{
            csvBrasileiraoService.saveBrasileiraoFromCsv(file);
            return ResponseEntity.ok("Upload e salvamento realizdo com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao processar o arquivo: " + e.getMessage());
        }

    }
}
