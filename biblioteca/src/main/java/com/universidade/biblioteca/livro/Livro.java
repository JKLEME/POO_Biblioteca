package com.universidade.biblioteca.livro;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column
    private String titulo;

    @Column
    private Double preco;


}