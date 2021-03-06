package br.com.antonio.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.antonio.domain.Associado;
import br.com.antonio.domain.request.AssociadoRequest;
import br.com.antonio.domain.response.AssociadoPost;
import br.com.antonio.service.AssociadoService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("associados")
@Log4j2
@RequiredArgsConstructor
public class AssociadoController {
	
	private final AssociadoService associadoService;
	
	@GetMapping
	@Operation(summary = "Lista todos os associados", tags = {"associado"})
	public ResponseEntity<List<Associado>> listarTodos() {
		log.info("Listagem de associados: {}");
		return ResponseEntity.ok(associadoService.listarTodos());
	}
	
	@GetMapping(path = "/{nome}")
	@Operation(summary = "Lista todos os associados por nome", tags = {"associado"})
	public ResponseEntity<List<Associado>> listarPorNome(@PathVariable String nome) {
		log.info("Listagem por nome: {}");
		return ResponseEntity.ok(associadoService.listarPorNome(nome));
	}
	
	@PostMapping
	@Operation(summary = "Salva um associado", tags = {"associado"})
	public ResponseEntity<Associado> salvar(@RequestBody @Valid AssociadoPost associadoPost) {
		log.info("Salvar associado: {}");
		return new ResponseEntity<>(associadoService.salvar(associadoPost),HttpStatus.CREATED);
	}
	
	@PutMapping
	@Operation(summary = "Atualiza um associado", tags = {"associado"})
	public ResponseEntity<Void> atualizar(@RequestBody AssociadoRequest associadoRequest) {
		log.info("Atualizar associado: {}");
		associadoService.atualizar(associadoRequest);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping(path = "/{id}")
	@Operation(summary = "Deleta um associado", tags = {"associado"})
	public ResponseEntity<Void> excluir(@PathVariable long id) {
		log.info("Excluir associado: {}");
		associadoService.excluir(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	

}
