package com.universidade.biblioteca.livro;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/livros")
@Slf4j
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping
    public List<Livro> getAll() {
        log.info("list all");
        return livroRepository.findAll();
    }

    @GetMapping("/{id}")
//    @ApiOperation(value = "busca livro por id", response = Livro.class)
    public ResponseEntity<Livro> getById(@PathVariable Long id) {
        log.info("list by id");
        return livroRepository.findById(id)
                .map(livro -> new ResponseEntity<>(livro, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
//    @ApiOperation(value = "Cria um livro", response = Livro.class)
    public Livro create(@RequestBody Livro livro) {
        log.info("create: " + livro);
        return livroRepository.save(livro);
    }

    @PutMapping("/{id}")
//    @ApiOperation(value = "atualiza livro por id", response = Livro.class)
    public ResponseEntity<Livro> update(@PathVariable Long id, @RequestBody Livro livro) {
        return livroRepository.findById(id)
                .map(l -> {
                    l.setTitulo(livro.getTitulo());
                    l.setPreco(livro.getPreco());

                    return new ResponseEntity<>(livroRepository.save(l), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
//    @ApiOperation(value = "apaga pessoa por id")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (livroRepository.existsById(id)) {
            livroRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}