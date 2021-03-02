package br.com.connect.pessoas.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.connect.pessoas.domain.Pessoa;
import br.com.connect.pessoas.repository.PessoaRepository;
import br.com.connect.pessoas.service.assembler.PessoaAssembler;
import br.com.connect.pessoas.service.dto.EntradaPessoaDTO;
import br.com.connect.pessoas.service.dto.SaidaPessoaDTO;
import br.com.connect.pessoas.service.filter.PessoaFilter;
import br.com.connect.pessoas.service.specs.PessoaSpecs;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PessoaService {

	private final PessoaRepository pessoaRepository;

	private final PessoaAssembler pessoaAssembler;

	public Page<Pessoa> findAll(PessoaFilter filter, Pageable pageable) {
		return pessoaRepository.findAll(PessoaSpecs.withFilter(filter), pageable);
	}

	public SaidaPessoaDTO save(EntradaPessoaDTO pessoaForm) {
		Pessoa pessoa = pessoaAssembler.toEntity(pessoaForm);
		pessoa = pessoaRepository.save(pessoa);
		return pessoaAssembler.toDTO(pessoa);
	}

	public void delete(Long id) {
		pessoaRepository.deleteById(id);
	}
}
