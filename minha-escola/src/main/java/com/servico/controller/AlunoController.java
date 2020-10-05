package com.servico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servico.model.Aluno;
import com.servico.repository.AlunoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/escola")
@Api(value="API Escolar")
public class AlunoController {

	@Autowired
	private AlunoRepository repository;
	
	
	@GetMapping
	@ApiOperation(value="Listagem de todos os alunos")
	public ResponseEntity<List<Aluno>> findAllAlunos(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/id/{id}")
	@ApiOperation(value="Listagem de alunos por ID")
	public ResponseEntity<Aluno> findById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	
	@PostMapping
	@ApiOperation(value="Inserção de alunos")
	public ResponseEntity<Aluno> postAluno(@RequestBody Aluno aluno){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(aluno));
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value="Atualizar dados do aluno")
	public ResponseEntity<Aluno> putAluno(@PathVariable Long id, @RequestBody Aluno aluno){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(aluno));
	}
	
	
	@DeleteMapping("/{id}")
	@ApiOperation(value="Deletar aluno")
	public void deleteAluno(@PathVariable long id) {
		repository.deleteById(id);
	}
	
	
	
	
	
	
	
	
}
