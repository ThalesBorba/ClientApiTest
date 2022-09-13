package com.foursys.clients.controller;

import com.foursys.clients.dto.ClientBody;
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
    public ResponseEntity<String> createClient(@RequestBody @Valid ClientBody clientBody) {
        clientService.createClient(clientBody);
        return ResponseEntity.status(HttpStatus.CREATED).body("Salvo com sucesso");
    }

    @GetMapping("/")
    public ResponseEntity<List<Client>> listAll() {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.listAll());
    }

    @GetMapping("/by-name/{name}")
    public ResponseEntity<Client> findByName(@PathVariable String name) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findByName(name));
    }

    @PutMapping("/by-name/{name}")
    public ResponseEntity<String> updateByName(@PathVariable @Valid String name, @RequestBody @Valid ClientBody clientBody) {
        clientService.updateByName(name, clientBody);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Atulizado com sucesso");
    }

    @Transactional
    @DeleteMapping("/by-name/{name}")
    public ResponseEntity<String> deleteByCpf(@PathVariable String name) {
        clientService.deleteByName(name);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Removido com sucesso!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateById(@PathVariable @Valid Long id, @RequestBody @Valid ClientBody clientBody) {
        clientService.updateById(id, clientBody);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Atualizado com sucesso!");
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteByCpf(@PathVariable Long id) {
        clientService.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Removido com sucesso!");
    }


}
