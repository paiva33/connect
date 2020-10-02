package br.com.connect.pessoas;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PessoaSpecs {
	
	/**
     * Retorna {@code Specification} com os filtros de pesquisa.
     * 
     */
    public static Specification<Pessoa> withFilter(PessoaFilter filter) {
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (StringUtils.isNotBlank(filter.getNome())) {
                predicates.add(builder.like(builder.lower(root.get("nome")), filter.getNome().toLowerCase() + "%"));
            }

            if (StringUtils.isNotBlank(filter.getCpf())) {
                predicates.add(builder.like(builder.lower(root.get("cpf")), filter.getCpf().toLowerCase() + "%"));
            }

            if (StringUtils.isNotBlank(filter.getEmail())) {
                predicates.add(builder.like(builder.lower(root.get("email")), "%" + filter.getEmail().toLowerCase() + "%"));
            }

            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }

    /**
     * Retorna {@code Specification} para verificação de duplicidade.
     * 
     */
    public static Specification<Pessoa> isDuplicated(Pessoa pessoa) {
        return (root, query, builder) -> {

            List<Predicate> predicates = new ArrayList<>();
            predicates.add(builder.equal(root.get("cpf"), pessoa.getCpf().toLowerCase()));

            if (pessoa.getId() != null) {
                predicates.add(builder.notEqual(root.get("id"), pessoa.getId()));
            }

            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
