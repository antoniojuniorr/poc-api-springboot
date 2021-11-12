package br.com.antonio.domain.response;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AssociadoPost {
	
	@NotEmpty(message = "O nome não pode ser vazio")
	@NotNull
	private String nome;

}
