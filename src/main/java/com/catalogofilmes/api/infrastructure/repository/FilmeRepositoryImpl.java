package com.catalogofilmes.api.infrastructure.repository;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.catalogofilmes.api.domain.model.Filme;
import com.catalogofilmes.api.domain.repository.FilmeRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class FilmeRepositoryImpl implements FilmeRepository{

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Filme> todos() {
		return manager.createQuery("FROM Filme", Filme.class).getResultList();
	}

	@Override
	public Filme Buscar(Long id) {
		return manager.find(Filme.class, id);
	}

	@Transactional
	@Override
	public Filme Salvar(Filme filme) {
		return manager.merge(filme);
	}

	@Transactional
	@Override
	public void Remover(Long filmeId) {
		Filme filme = Buscar(filmeId);
		if(filme == null) {
			throw new EmptyResultDataAccessException(1);
		}
		manager.remove(filme);
	}
	
}
