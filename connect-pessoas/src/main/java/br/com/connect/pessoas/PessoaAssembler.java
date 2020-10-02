package br.com.connect.pessoas;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PessoaAssembler {
	
	private final ModelMapper modelMapper;
	
	public PessoaDTO toDTO(Pessoa pessoa) {
		return modelMapper.map(pessoa, PessoaDTO.class);
	}
	
	public Pessoa toEntity(PessoaForm pessoaForm) {
		return modelMapper.map(pessoaForm, Pessoa.class);
	}
	
	public PessoaForm toForm(Pessoa pessoa) {
		return modelMapper.map(pessoa, PessoaForm.class);
	}
	
	public void copyToEntiy(PessoaForm pessoaForm, Pessoa pessoa) {
		modelMapper.map(pessoaForm, pessoa);
	}
}
