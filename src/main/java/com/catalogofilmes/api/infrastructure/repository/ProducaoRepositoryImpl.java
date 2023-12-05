package com.catalogofilmes.api.infrastructure.repository;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.catalogofilmes.api.domain.model.Producao;
import com.catalogofilmes.api.domain.repository.ProducaoRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class ProducaoRepositoryImpl implements ProducaoRepository{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Producao> todos() {
		return manager.createQuery("FROM Producao", Producao.class).getResultList();
	}

	@Override
	public Producao Buscar(Long id) {
		return manager.find(Producao.class, id);
	}

	@Transactional
	@Override
	public Producao Salvar(Producao producao) {
		return manager.merge(producao);
	}

	@Transactional
	@Override
	public void Remover(Long producaoId) {
		Producao producao = Buscar(producaoId);
		if(producao == null) {
			throw new EmptyResultDataAccessException(1);
		}
		manager.remove(producao);
	}

}
