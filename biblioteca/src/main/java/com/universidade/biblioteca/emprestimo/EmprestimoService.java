package com.universidade.biblioteca.emprestimo;

import com.universidade.biblioteca.livro.Livro;
import com.universidade.biblioteca.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmprestimoService {

    @Autowired
    EmprestimoRepository emprestimoRepository;
    public void emprestar(Emprestimo emprestimo) {
        emprestimoRepository.save(emprestimo);
    }

    public void devolver(Emprestimo devolucao) {
        emprestimoRepository.delete(devolucao);
    }

    public List<Emprestimo> findAll() {
        return emprestimoRepository.findAll();
    }

    public List<Emprestimo> searchByUsuario(Long usuarioId) {
        return emprestimoRepository.findByUsuarioId(usuarioId);
    }

    public List<Emprestimo> searchByLivro(Long livroId) {
        return emprestimoRepository.findByLivroId(livroId);
    }
}
