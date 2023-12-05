package com.catalogofilmes.api.domain.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.catalogofilmes.api.domain.model.Elenco;

@Repository
public interface ElencoRepository {

	List<Elenco> todos();
	Elenco Buscar(Long id);
	Elenco Salvar(Elenco elenco);
	void Remover(Long elencoId);
}
