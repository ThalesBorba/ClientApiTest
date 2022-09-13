package com.foursys.clients.exceptions;

public class ClientNotFoundException extends RuntimeException {

    public ClientNotFoundException(String cpf) {
        super("No client found with cpf " + cpf);
    }

    public ClientNotFoundException(Long id) { super("No client found with id " + id);
    }
}
