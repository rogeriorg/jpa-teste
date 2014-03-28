package com.teste.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;

import com.teste.jpa.domain.Pessoa;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("testing-h2");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Tocchetto");
        pessoa.setIdade(32);

        em.persist(pessoa);

        em.getTransaction().commit();

        Session session = (Session) em.getDelegate();

        DetachedCriteria criteria = DetachedCriteria.forClass(Pessoa.class);

        List<Pessoa> pessoas = criteria.getExecutableCriteria(session).list();
        System.out.println("Pessoas: " + pessoas.size());

        for (Pessoa pessoaDB : pessoas) {
            System.out.println(ToStringBuilder.reflectionToString(pessoaDB));
        }

    }

}
