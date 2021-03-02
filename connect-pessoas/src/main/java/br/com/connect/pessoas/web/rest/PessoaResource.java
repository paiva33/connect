package br.com.connect.pessoas.web.rest;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.connect.pessoas.service.PessoaService;
import br.com.connect.pessoas.service.assembler.PessoaAssembler;
import br.com.connect.pessoas.service.dto.EntradaPessoaDTO;
import br.com.connect.pessoas.service.dto.SaidaPessoaDTO;
import br.com.connect.pessoas.service.filter.PessoaFilter;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/pessoa/v1")
public class PessoaResource {
		
	private final PessoaAssembler pessoaAssembler;
	
	private final PessoaService pessoaService;
	
	/**
     * {@code GET  /pessoas} : get all the pessoas.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of pessoas in body.
     */
	@GetMapping("/pessoas")
    public Page<SaidaPessoaDTO> search(PessoaFilter search, @PageableDefault(sort = "nome") Pageable pageable) {
        return pessoaService.findAll(search, pageable).map(pessoaAssembler::toDTO);
    }
	
	
	/**
     * {@code POST  /pessoas} : Create a new pessoa.
     *
     * @param pessoaDTO the pessoaDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new pessoaDTO, or with status {@code 400 (Bad Request)} if the pessoa has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/pessoas")
    public ResponseEntity<SaidaPessoaDTO> createPessoa(@RequestBody EntradaPessoaDTO pessoaForm) throws URISyntaxException {
        SaidaPessoaDTO result = pessoaService.save(pessoaForm);
        return ResponseEntity.created(new URI("/api/pessoas/" + result.getId()))
            .body(result);
    }
	
    
    /**
     * {@code PUT  /pessoas} : Updates an existing pessoa.
     *
     * @param pessoaDTO the pessoaDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated pessoaDTO,
     * or with status {@code 400 (Bad Request)} if the pessoaDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the pessoaDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/pessoas")
    public ResponseEntity<SaidaPessoaDTO> updatePessoa(@RequestBody EntradaPessoaDTO pessoaForm) throws URISyntaxException {
        SaidaPessoaDTO result = pessoaService.save(pessoaForm);
        return ResponseEntity.ok()
            .body(result);
    }
    
    /**
     * {@code DELETE  /pessoas/:id} : delete the "id" pessoa.
     *
     * @param id the id of the pessoaDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/pessoas/{id}")
    public ResponseEntity<Void> deletePessoa(@PathVariable Long id) {
        pessoaService.delete(id);
        return ResponseEntity.noContent().build();
    }
	
}
