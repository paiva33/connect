package br.com.connect.pessoas.service.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.connect.pessoas.domain.Pessoa;
import br.com.connect.pessoas.service.dto.EntradaPessoaDTO;
import br.com.connect.pessoas.service.dto.SaidaPessoaDTO;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PessoaAssembler {
	
	private final ModelMapper modelMapper;
	
	public SaidaPessoaDTO toDTO(Pessoa pessoa) {
		return modelMapper.map(pessoa, SaidaPessoaDTO.class);
	}
	
	public Pessoa toEntity(EntradaPessoaDTO pessoaForm) {
		return modelMapper.map(pessoaForm, Pessoa.class);
	}
	
	public EntradaPessoaDTO toForm(Pessoa pessoa) {
		return modelMapper.map(pessoa, EntradaPessoaDTO.class);
	}
	
	public void copyToEntiy(EntradaPessoaDTO pessoaForm, Pessoa pessoa) {
		modelMapper.map(pessoaForm, pessoa);
	}
}
