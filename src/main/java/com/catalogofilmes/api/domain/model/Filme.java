package com.catalogofilmes.api.domain.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Filme {

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String titulo;
	private Date dataEstreia;
	//precisa aceitar mais de um genero
	private String genero;
	private String duracao;
	private String sinopse;
	private String capa;
	private String origem;
	
	@ManyToOne
	@JoinColumn(name ="id_empresa", nullable = false)
	private Empresa empresa;
	
	private Integer classificacao;
	private Integer produzidoEm;
	
	
	
	
	
}
