package br.com.connect.pessoas;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaForm {

	@NotBlank
	private String nome;

	@CPF
	@NotBlank
	private String cpf;

	@Email
	private String email;

	private String naturalidade;

	private String nacionalidade;

	@NotNull
	private LocalDate dataNascimento;

	private String sexo;

}
