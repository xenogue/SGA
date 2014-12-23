/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sga.model.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author rios
 */
@Entity
@Table(name = "alteracao")
public class Alteracao implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idAlteracao", nullable = false)
    private Integer idAlteracao;
    @Column(name="nome", nullable = false, length = 200)
    private String nome;
    
    //classe meetings
//    @ManyToMany(mappedBy="meetings")
//    private Set<Employee> employees = new HashSet<Employee>();
    
    @ManyToMany(mappedBy="alteracoes")
    private Set<Ano> anos = new HashSet<Ano>();

    public Set<Ano> getAnos() {
        return anos;
    }

    public void setAnos(Set<Ano> anos) {
        this.anos = anos;
    }

    public Integer getIdAlteracao() {
        return idAlteracao;
    }

    public void setIdAlteracao(Integer idAlteracao) {
        this.idAlteracao = idAlteracao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (this.idAlteracao != null ? this.idAlteracao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Alteracao other = (Alteracao) obj;
        if (this.idAlteracao != other.idAlteracao && (this.idAlteracao == null || !this.idAlteracao.equals(other.idAlteracao))) {
            return false;
        }
        return true;
    }
    
    
    
}
