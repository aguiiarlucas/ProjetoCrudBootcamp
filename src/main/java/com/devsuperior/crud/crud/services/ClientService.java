package com.devsuperior.crud.crud.services;


import com.devsuperior.crud.crud.dto.ClientDTO;
import com.devsuperior.crud.crud.entities.Client;
import com.devsuperior.crud.crud.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;


    @Transactional(readOnly = true)
    public List<ClientDTO> findAll() {
        List<Client> list = repository.findAll();

        return list.stream().map(ClientDTO::new).collect(Collectors.toList());

    }

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Optional<Client> obj = repository.findById(id);
        Client entity =  obj.get();
        return  new ClientDTO(entity);
    }
}

