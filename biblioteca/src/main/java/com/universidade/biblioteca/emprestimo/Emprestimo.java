package com.universidade.biblioteca.emprestimo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity
public class Emprestimo {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Long usuarioId;
    private Long livroId;



}
