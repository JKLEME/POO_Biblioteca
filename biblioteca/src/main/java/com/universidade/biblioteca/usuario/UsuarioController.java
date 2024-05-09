package com.universidade.biblioteca.usuario;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/usuarios")
@Slf4j
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
//    @ApiOperation(value = "listar usuarios", response = List.class)
    public List<Usuario> getAll() {
        log.info("list all");
        return usuarioRepository.findAll();
    }

    @GetMapping("/{id}")
//    @ApiOperation(value = "busca usuario por id", response = Usuario.class)
    public ResponseEntity<Usuario> getById(@PathVariable Long id) {
        log.info("list by id");
        return usuarioRepository.findById(id)
                .map(usuario -> new ResponseEntity<>(usuario, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
//    @ApiOperation(value = "Cria um usuario", response = Usuario.class)
    public Usuario create(@RequestBody Usuario usuario) {
        log.info("create: " + usuario);
        return usuarioRepository.save(usuario);
    }

    @PutMapping("/{id}")
//    @ApiOperation(value = "atualiza usuario por id", response = Usuario.class)
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario usuario) {
        return usuarioRepository.findById(id)
                .map(l -> {
                    l.setNome(usuario.getNome());


                    return new ResponseEntity<>(usuarioRepository.save(l), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}