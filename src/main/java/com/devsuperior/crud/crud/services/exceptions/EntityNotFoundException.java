package com.devsuperior.crud.crud.services.exceptions;

public class EntityNotFoundException extends  RuntimeException{

    public EntityNotFoundException(String msg){
        super(msg);
    }
}
