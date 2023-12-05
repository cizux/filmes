package com.catalogofilmes.api.infrastructure.repository;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.catalogofilmes.api.domain.model.Elenco;
import com.catalogofilmes.api.domain.repository.ElencoRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Component
public class ElencoRepositoryImpl implements ElencoRepository{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Elenco> todos() {
		return manager.createQuery("FROM Elenco", Elenco.class).getResultList();
	}

	@Override
	public Elenco Buscar(Long id) {
		return manager.find(Elenco.class, id);
	}

	@Transactional
	@Override
	public Elenco Salvar(Elenco elenco) {
		return manager.merge(elenco);
	}

	@Transactional
	@Override
	public void Remover(Long elencoId) {
		Elenco elenco = Buscar(elencoId);
		if(elenco == null) {
			throw new EmptyResultDataAccessException(1);
		}
		manager.remove(elenco);
	}

}
