package com.teste.jpa.mundoj.edicao19.dao;

import java.util.logging.Logger;

import javax.persistence.EntityManager;


public class Dao <T> {

	private Class persistentClass;
	private static Logger logger = Logger.getAnonymousLogger(); 
	private EntityManager entityManager;

	public Dao (EntityManager entityManager, Class persistentClass){
		this.entityManager = entityManager;
		this.persistentClass = persistentClass;
	}

	public T load (Long id){
		logger.info("Carregando objeto" + id);
		return (T) getEntityManager().find(persistentClass, id);
	}
	
	public void save (T objeto){
		logger.info("Salvando objeto" + objeto.getClass().getSimpleName());
		getEntityManager().persist(objeto);		
	}
	
	protected EntityManager getEntityManager() {
		return entityManager;
	}

	protected void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
}
