package com.catalogofilmes.api.domain.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.catalogofilmes.api.domain.model.Producao;

@Repository
public interface ProducaoRepository {

	List<Producao> todos();
	Producao Buscar(Long id);
	Producao Salvar(Producao producao);
	void Remover(Long producaoId);
}
