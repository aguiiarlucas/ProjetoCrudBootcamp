package com.devsuperior.crud.crud.resources;

import com.devsuperior.crud.crud.entities.Client;
import jdk.jfr.Category;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/clients") // rotas
public class ClientResource {

    @GetMapping
    public ResponseEntity<List<Client>> findAll(){
        List<Client>list = new ArrayList<>();
        list.add(new Client(1L, "Maria ","cpf",0.0, Instant.now() ,2));
        return ResponseEntity.ok().body(list);
    }

}