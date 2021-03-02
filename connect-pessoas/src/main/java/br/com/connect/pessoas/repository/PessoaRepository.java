package br.com.connect.pessoas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import br.com.connect.pessoas.domain.Pessoa;

/**
 * Spring Data  repository for the Pessoa entity.
 */
@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>, JpaSpecificationExecutor<Pessoa> {
}
