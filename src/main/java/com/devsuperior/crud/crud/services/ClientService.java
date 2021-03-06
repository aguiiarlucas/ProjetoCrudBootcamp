package com.devsuperior.crud.crud.services;


import com.devsuperior.crud.crud.dto.ClientDTO;
import com.devsuperior.crud.crud.entities.Client;
import com.devsuperior.crud.crud.repositories.ClientRepository;
import com.devsuperior.crud.crud.services.exceptions.DatabaseException;
import com.devsuperior.crud.crud.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    public Page<ClientDTO> findAllPaged(PageRequest pageRequest) {
        Page<Client> list = repository.findAll(pageRequest);
        return  list.map(ClientDTO::new);
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


    @Transactional
    public ClientDTO update(Long id, ClientDTO dto) {
       try {
           Client entity = repository.getById(id);
           entity.setName(dto.getName());
           entity.setCpf(dto.getCpf());
           entity.setIncome(dto.getIncome());
           entity.setBirthDate(dto.getBirthDate());
           entity.setChildren(dto.getChildren());
           entity = repository.save(entity);
           return new ClientDTO(entity);
       }catch (EntityNotFoundException e ){
           throw new ResourceNotFoundException("Id not found!");
       }

    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        }catch (EmptyResultDataAccessException e ) {
            throw new ResourceNotFoundException("Id not found" + id);
        }catch (DataIntegrityViolationException  e ){
            throw new DatabaseException("Integrity violation! ");
        }
    }


}

