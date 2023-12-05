package com.catalogofilmes.api.domain.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.catalogofilmes.api.domain.model.Filme;

@Repository
public interface FilmeRepository {

	List<Filme> todos();
	Filme Buscar(Long id);
	Filme Salvar(Filme filme);
	void Remover(Long filmeId);
}
