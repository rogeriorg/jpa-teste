package com.teste.jpa.mundoj.edicao19.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;

import com.teste.jpa.mundoj.edicao19.dao.Dao;
import com.teste.jpa.mundoj.edicao19.domain.Fornecedor;

public class App {
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("testing-h2");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        
        Dao<Fornecedor> daoFornecedor = new Dao<Fornecedor>(em, Fornecedor.class);  

        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNome("Rogerio");
        fornecedor.setDescricao("Teste");
        
        daoFornecedor.save(fornecedor);

        em.getTransaction().commit();

        Session session = (Session) em.getDelegate();

        DetachedCriteria criteria = DetachedCriteria.forClass(Fornecedor.class);

        List<Fornecedor> fornecedores = criteria.getExecutableCriteria(session).list();
        System.out.println("Fornecedores: " + fornecedores.size());

        for (Fornecedor fornecedorDB : fornecedores) {
            System.out.println(ToStringBuilder.reflectionToString(fornecedorDB));
        }

    }
    

}
