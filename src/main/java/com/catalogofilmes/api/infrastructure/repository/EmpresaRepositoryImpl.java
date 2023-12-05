package com.catalogofilmes.api.infrastructure.repository;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.catalogofilmes.api.domain.model.Empresa;
import com.catalogofilmes.api.domain.repository.EmpresaRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class EmpresaRepositoryImpl implements EmpresaRepository {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Empresa> todos() {
		return manager.createQuery("FROM Empresa", Empresa.class).getResultList();
	}

	@Override
	public Empresa Buscar(Long id) {
		return manager.find(Empresa.class, id);
	}

	@Transactional
	@Override
	public Empresa Salvar(Empresa empresa) {
		return manager.merge(empresa);
	}

	@Transactional
	@Override
	public void Remover(Long empresaId) {
		Empresa empresa = Buscar(empresaId);
		
		if(empresa == null) {
			throw new EmptyResultDataAccessException(1);
		}
		manager.remove(empresa);
		
	}

}
