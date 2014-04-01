package com.teste.jpa.mundoj.edicao19.domain;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ContaPagar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne (fetch = FetchType.LAZY)
	@JoinTable (name="Conta_Fornecedor",
	joinColumns = @JoinColumn(name="Conta_ID"),
	inverseJoinColumns = @JoinColumn(name = "Fornecedor_ID"))
	private Fornecedor fornecedor;

	private String descricao;

	private Double valor;

	private Boolean pago;

	@Temporal(TemporalType.DATE)
	private Calendar data;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Boolean getPago() {
		return pago;
	}

	public void setPago(Boolean pago) {
		this.pago = pago;
	}
	
	public Calendar getData() {
		return data;
	}
	
	public void setData(Calendar data) {
		this.data = data;
	}

}
