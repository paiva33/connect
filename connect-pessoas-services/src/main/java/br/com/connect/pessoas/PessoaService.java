package br.com.connect.pessoas;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PessoaService {

	private final PessoaRepository pessoaRepository;

	private final PessoaAssembler pessoaAssembler;

	public Page<Pessoa> findAll(PessoaFilter filter, Pageable pageable) {
		return pessoaRepository.findAll(PessoaSpecs.withFilter(filter), pageable);
	}

	public PessoaDTO save(PessoaForm pessoaForm) {
		Pessoa pessoa = pessoaAssembler.toEntity(pessoaForm);
		pessoa = pessoaRepository.save(pessoa);
		return pessoaAssembler.toDTO(pessoa);
	}

	public void delete(Long id) {
		pessoaRepository.deleteById(id);
	}
}
