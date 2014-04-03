package com.teste.jpa.mundoj.edicao19.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import com.teste.jpa.mundoj.edicao19.domain.ContaPagar;
import com.teste.jpa.mundoj.edicao19.domain.Fornecedor;


public class DaoFornecedor extends Dao<Fornecedor> { 

	private static Logger logger = Logger.getAnonymousLogger(); 

	public DaoFornecedor (EntityManager entityManager){
		super(entityManager, Fornecedor.class);
	}
	
	public List<Fornecedor> buscaPorNome(String nome) {
		// SELECT * FROM FORNECEDOR
		DetachedCriteria criteria = DetachedCriteria.forClass(Fornecedor.class);
		// where 1=1
		
		// AND nome like '%' + paramNome '%'
		criteria.add(Restrictions.ilike("nome", nome, MatchMode.ANYWHERE));
		
		// Order by nome
		criteria.addOrder(Order.asc("nome"));
		
		return getExecutableCriteria(criteria).list();
	}
	
	public Fornecedor buscaPorId(Long id) {
		// SELECT * FROM FORNECEDOR
		DetachedCriteria criteria = DetachedCriteria.forClass(Fornecedor.class);
		// where 1=1
		// AND ID = paramID
		criteria.add(Restrictions.eq("id", id));
		
		return (Fornecedor) getExecutableCriteria(criteria).uniqueResult();
	}
	
	public List<String> buscaNomesFornecedores() {
		// SELECT * FROM FORNECEDOR
		DetachedCriteria criteria = DetachedCriteria.forClass(Fornecedor.class);
		
		// SELECT NOME FROM FORNECEDOR
		Projection projectionNome = Projections.property("nome");
		criteria.setProjection(projectionNome);
		
		return getExecutableCriteria(criteria).list();
	}
	
	public List<Fornecedor> buscaPorFornecedoresComTodasContasPagas() {
		// SELECT * FROM FORNECEDOR
		DetachedCriteria criteria = DetachedCriteria.forClass(Fornecedor.class, "fornecedor");
		// JOIN CONTAPAGAR as contasPagar where contasPagar.fornecedor.id = id
		DetachedCriteria criteriaContaPagar = criteria.createCriteria("fornecedor.contas", "contasPagar");
		//                                      and contaPagar.pago = true  
		criteriaContaPagar.add(Restrictions.eq("pago", Boolean.TRUE));
		
		return getExecutableCriteria(criteria).list();
	}
	
	
	public void printClassName(Class clazz) {
		System.out.println(clazz.getSimpleName());
	}
	
}
