package com.devsuperior.crud.crud.services;


import com.devsuperior.crud.crud.entities.Client;
import com.devsuperior.crud.crud.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

   public List<Client> findAll(){
       return  repository.findAll();
   }
    }

