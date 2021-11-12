package br.com.antonio.controller;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.antonio.domain.Associado;
import br.com.antonio.service.AssociadoService;

@ExtendWith(SpringExtension.class)
public class AssociadoControllerTest {

	@InjectMocks
	AssociadoController associadoControlerMock;

	@Mock
	AssociadoService associadoServiceMock;

	@BeforeEach
	void setup() {
		BDDMockito.when(associadoServiceMock.listarPorNome(ArgumentMatchers.anyString()))
				.thenReturn(Arrays.asList(new Associado(1L, "antonio")));
	}

	@Test
	@DisplayName("retorna lista de associado por nome quando sucesso")
	void listarPorNomeQuandoSucesso() {
		String nome = "antonio";

		List<Associado> associados = associadoControlerMock.listarPorNome(nome).getBody();

		Assertions.assertThat(associados).isNotNull().isNotEmpty().hasSize(1);
		Assertions.assertThat(associados.get(0).getNome()).contains(nome);
	}

}
