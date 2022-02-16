package com.devsuperior.crud.crud.resources;

import com.devsuperior.crud.crud.dto.ClientDTO;
import com.devsuperior.crud.crud.entities.Client;
import com.devsuperior.crud.crud.repositories.ClientRepository;
import com.devsuperior.crud.crud.services.ClientService;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/clients") // rotas
public class ClientResource {

    @Autowired
    private ClientService service;

    @GetMapping
    public ResponseEntity<List<Client>> findAll(){
      List<Client>list = service.findAll();
        return ResponseEntity.ok(list);
    }



}