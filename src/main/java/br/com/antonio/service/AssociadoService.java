package br.com.antonio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.antonio.domain.Associado;
import br.com.antonio.domain.request.AssociadoRequest;
import br.com.antonio.domain.response.AssociadoPost;
import br.com.antonio.exception.BadRequestException;
import br.com.antonio.repository.AssociadoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AssociadoService {
	
	private final AssociadoRepository associadoRepository;
	
	public Associado obterPorId(Long id) {
		return associadoRepository.findById(id).orElseThrow(() -> new BadRequestException("Associado não encontrado"));
	}
	
	public List<Associado> listarTodos() {
		return associadoRepository.findAll();
	}
	
	public List<Associado> listarPorNome(String nome) {
		return associadoRepository.findByNomeContainsIgnoreCase(nome);
	}
	
	public Associado salvar(AssociadoPost associadoPpost) {
		return associadoRepository.save(Associado.builder().nome(associadoPpost.getNome()).build());
	}

	public void excluir(long id) {
		associadoRepository.delete(obterPorId(id));
	}

	public void atualizar(AssociadoRequest associadoRequest) {
		Associado associadoBanco = obterPorId(associadoRequest.getId());
		
		Associado associado = associadoRepository.save(Associado.builder()
				.nome(associadoRequest.getNome())
				.id(associadoBanco.getId())
				.build());
		
		associadoRepository.save(associado);
	}
	
}
