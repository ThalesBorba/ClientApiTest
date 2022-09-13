package com.foursys.clients.exceptions;

public class ClientNotFoundException extends RuntimeException {

    public ClientNotFoundException(String cpf) {
        super("Nenhum cliente encontrado com o cpf " + cpf);
    }

    public ClientNotFoundException(Long id) { super("Nenhum cliente encontrado com a id " + id);
    }
}
