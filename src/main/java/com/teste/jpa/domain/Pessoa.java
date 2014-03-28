package com.teste.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "PESSOA")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Integer idade;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the idade
     */
    public Integer getIdade() {
        return idade;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @param idade
     *            the idade to set
     */
    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    /**
     * @param nome
     *            the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

}
