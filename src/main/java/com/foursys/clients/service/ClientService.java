package com.foursys.clients.service;


import com.foursys.clients.dto.ClientBody;
import com.foursys.clients.entities.Client;
import com.foursys.clients.exceptions.ClientNotFoundException;
import com.foursys.clients.repositories.ClientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public void createClient(ClientBody clientBody) {
        Client client = new Client();
        BeanUtils.copyProperties(clientBody, client);
        clientRepository.save(client);
    }

    public void updateByName(String name, ClientBody clientBody) {
        Client clientToBeUpdate = clientRepository.findByName(name).orElseThrow(() -> new ClientNotFoundException(name));
        BeanUtils.copyProperties(clientBody, clientToBeUpdate);
        clientRepository.save(clientToBeUpdate);

    }

    public void updateById(Long id, ClientBody clientBody) {
        Client clientToBeUpdate = clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException(id));
        BeanUtils.copyProperties(clientBody, clientToBeUpdate);
        clientRepository.save(clientToBeUpdate);
    }

    public List<Client> listAll() {
        return clientRepository.findAll();
    }

    public void deleteByName(String name) {
        findByName(name);
        clientRepository.deleteByName(name);
    }

    public void deleteById(Long id) {
        findById(id);
        clientRepository.deleteById(id);
    }

    public Client findByName(String name) {
        return clientRepository.findByName(name).orElseThrow(() -> new ClientNotFoundException(name));
    }

    public Client findById(Long id) {
        return clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException(id));
    }
}
