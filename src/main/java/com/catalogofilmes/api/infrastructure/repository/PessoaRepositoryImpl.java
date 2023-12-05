package com.catalogofilmes.api.infrastructure.repository;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.catalogofilmes.api.domain.model.Pessoa;
import com.catalogofilmes.api.domain.repository.PessoaRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Component
public class PessoaRepositoryImpl implements PessoaRepository{
	
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Pessoa> todos() {
		return manager.createQuery("FROM Pessoa", Pessoa.class).getResultList();
	}

	@Override
	public Pessoa Buscar(Long id) {
		return manager.find(Pessoa.class, id);
	}

	@Transactional
	@Override
	public Pessoa Salvar(Pessoa pessoa) {
		return manager.merge(pessoa);
	}

	@Transactional
	@Override
	public void Remover(Long pessoaId) {
		Pessoa pessoa = Buscar(pessoaId);
		if(pessoa == null) {
			throw new EmptyResultDataAccessException(1);
		}
		manager.remove(pessoa);
	}

}
