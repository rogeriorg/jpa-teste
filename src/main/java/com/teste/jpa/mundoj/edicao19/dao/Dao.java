package com.teste.jpa.mundoj.edicao19.dao;

import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;


public class Dao<T>  { 

	private Class persistentClass;
	private static Logger logger = Logger.getAnonymousLogger(); 
	private EntityManager entityManager;

	public Dao (EntityManager entityManager, Class persistentClass){
		this.entityManager = entityManager;
		this.persistentClass = persistentClass;
	}

	public T load(Long id){
		logger.info("Carregando objeto" + id);
		return (T) getEntityManager().find(persistentClass, id);
	}
	
	public void save(T objeto){
		logger.info("Salvando objeto" + objeto.getClass().getSimpleName());
		getEntityManager().persist(objeto);		
	}
	
	protected EntityManager getEntityManager() {
		return entityManager;
	}

	protected void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	protected Class getPersistentClass() {
		return persistentClass;
	}
	
	protected Criteria getExecutableCriteria(DetachedCriteria criteria) {
		return criteria.getExecutableCriteria(getSession());
	}
	
	protected Session getSession() {
		return (Session) getEntityManager().getDelegate();
	}
	
}
