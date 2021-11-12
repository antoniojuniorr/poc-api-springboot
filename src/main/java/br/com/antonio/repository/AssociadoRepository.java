package br.com.antonio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.antonio.domain.Associado;

public interface AssociadoRepository extends JpaRepository<Associado, Long> {
	
	List<Associado> findByNomeContainsIgnoreCase(String name);

}
