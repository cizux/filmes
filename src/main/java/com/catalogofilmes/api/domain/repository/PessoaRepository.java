package com.catalogofilmes.api.domain.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.catalogofilmes.api.domain.model.Pessoa;

@Repository
public interface PessoaRepository {

	
	List<Pessoa> todos();
	Pessoa Buscar(Long id);
	Pessoa Salvar(Pessoa pessoa);
	void Remover(Long pessoaId);
}
