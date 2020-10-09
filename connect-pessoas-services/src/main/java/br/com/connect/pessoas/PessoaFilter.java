package br.com.connect.pessoas;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaFilter implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private String email;
	private String cpf;
	private String naturalidade;
	private String nacionalidade;
	private LocalDate dataNascimento;
	private String sexo;

}
