package com.foursys.clients.dto;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class ClientBody {

    @CPF
    @Column(nullable = false, unique = true)
    private String cpf;
    @NotNull
    private String name;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDate;
}
