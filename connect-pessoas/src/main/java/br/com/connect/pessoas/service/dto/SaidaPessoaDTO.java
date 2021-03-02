package br.com.connect.pessoas.service.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A DTO for the {@link br.com.connect.pessoas.domain.mycompany.myapp.domain.Pessoa} entity.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaidaPessoaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3021144594987055272L;

	private Long id;

	@NotNull
	private String nome;

	@Pattern(regexp = "^[a-zA-Z0-9]*$")
	private String email;

	private String cpf;

	private String naturalidade;

	private String nacionalidade;

	@NotNull
	private LocalDate dataNascimento;

	private String sexo;

}
