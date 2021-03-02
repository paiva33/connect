package br.com.connect.pessoas.service.filter;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaFilter {

	private String nome;
	private String email;
	private String cpf;
	private String naturalidade;
	private String nacionalidade;
	private LocalDate dataNascimento;
	private String sexo;

}
