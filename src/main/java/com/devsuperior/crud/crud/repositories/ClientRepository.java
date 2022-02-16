package com.devsuperior.crud.crud.repositories;

import com.devsuperior.crud.crud.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientRepository  extends JpaRepository<Client,Long> {
}
