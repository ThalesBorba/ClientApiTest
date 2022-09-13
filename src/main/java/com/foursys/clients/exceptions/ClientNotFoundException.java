package com.foursys.clients.exceptions;

public class ClientNotFoundException extends RuntimeException {

    public ClientNotFoundException(String name) {
        super("No client found with name " + name);
    }

    public ClientNotFoundException(Long id) { super("No client found with id " + id);
    }
}
