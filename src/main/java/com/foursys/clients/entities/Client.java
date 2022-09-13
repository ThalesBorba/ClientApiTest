package com.foursys.clients.entities;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@Table(name="clients")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CPF
    @Column(nullable = false, unique = true)
    private String cpf;
    @NotNull
    private String name;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDate;

}

