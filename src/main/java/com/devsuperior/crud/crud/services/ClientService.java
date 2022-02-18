package com.devsuperior.crud.crud.services;


import com.devsuperior.crud.crud.dto.ClientDTO;
import com.devsuperior.crud.crud.entities.Client;
import com.devsuperior.crud.crud.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
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
        Client entity = obj.orElseThrow(() -> new EntityNotFoundException("Entity not found!"));
        return new ClientDTO(entity);
    }

    @Transactional
    public ClientDTO insert(ClientDTO dto) {
        Client entity = new Client();
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setIncome(dto.getIncome());
        entity.setBirthDate(dto.getBirthDate());
        entity.setChildren(dto.getChildren());
        repository.save(entity);
        return new ClientDTO(entity);
    }

/*
    @Transactional
    public ClientDTO update(ClientDTO dto, Long id) {
        Client entity = repository.getById(dto.getId());
        entity.setName(dto.getName());
        entity = repository.save(entity);
        return new ClientDTO(entity);
    }*/
}

