package com.servico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.servico.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
