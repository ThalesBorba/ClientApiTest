package com.foursys.clients.controller;

import com.foursys.clients.entities.Client;
import com.foursys.clients.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/")
    public ResponseEntity<String> createClient(@RequestBody @Valid Client client) {
        return ResponseEntity.status(HttpStatus.CREATED).body("Salvo com sucesso");
    }

    @GetMapping("/")
    public ResponseEntity<List<Client>> listAll() {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.listAll());
    }

    @GetMapping("/{name}")
    public ResponseEntity<Client> findByName(@PathVariable @Valid String name) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findByName(name));
    }

    @PutMapping("/{name}")
    public ResponseEntity<String> updatePaymentInfoByCpf(@PathVariable @Valid String name, @RequestBody @Valid Client client) {
        clientService.updateByName(name, client);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Atulizado com sucesso");
    }

    @Transactional
    @DeleteMapping("/{name}")
    public ResponseEntity<String> deleteByCpf(@PathVariable String name) {
        clientService.deleteByName(name);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Removido com sucesso!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> findById(@PathVariable @Valid Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateById(@PathVariable @Valid Long id, @RequestBody @Valid Client client) {
        clientService.updateById(id, client);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Atualizado com sucesso!");
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteByCpf(@PathVariable Long id) {
        clientService.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Removido com sucesso!");
    }


}
