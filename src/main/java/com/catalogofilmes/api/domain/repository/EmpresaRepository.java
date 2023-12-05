package com.catalogofilmes.api.domain.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.catalogofilmes.api.domain.model.Empresa;

@Repository
public interface EmpresaRepository {

	List<Empresa> todos();
	Empresa Buscar(Long id);
	Empresa Salvar(Empresa empresa);
	void Remover(Long empresaId);
}
