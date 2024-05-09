package com.universidade.biblioteca.emprestimo;

import com.universidade.biblioteca.livro.Livro;
import com.universidade.biblioteca.usuario.Usuario;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/emprestimo")
@Slf4j
public class EmprestimoController {

    @Autowired
    private EmprestimoService bibliotecaService;

    @GetMapping
    public List<Emprestimo> getAll() {
        log.info("list all");
        return bibliotecaService.findAll();
    }

    @GetMapping("/searchByLivro")
    public List<Emprestimo> searchByLivro(@RequestParam Long livroId) {
        log.info("list all");
        return bibliotecaService.searchByLivro(livroId);
    }

    @GetMapping("/searchByUsuario")
    public List<Emprestimo> searchByUsuario(@RequestParam Long usuarioId) {
        log.info("list all");
        return bibliotecaService.searchByUsuario(usuarioId);
    }


    @PostMapping("/emprestar")
    public void emprestar(@RequestBody Emprestimo emprestimo) {
        bibliotecaService.emprestar(emprestimo);

    }

    @PutMapping("/devolver")
    public void devolver(Emprestimo emprestimo) {
        bibliotecaService.devolver(emprestimo);

    }


}