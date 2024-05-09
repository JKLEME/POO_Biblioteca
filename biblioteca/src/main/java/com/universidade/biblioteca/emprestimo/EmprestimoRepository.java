package com.universidade.biblioteca.emprestimo;

import com.universidade.biblioteca.livro.Livro;
import com.universidade.biblioteca.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  EmprestimoRepository extends JpaRepository<Emprestimo, Long> {


    List<Emprestimo> findByLivroId(Long livroId);

    List<Emprestimo> findByUsuarioId(Long usuarioId);
}
