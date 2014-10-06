package br.com.sga.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author rios
 */
@Entity
@Table(name = "endereco")
public class Endereco {
   
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name = "idEndereco", nullable = false)
    private Integer idEndereco;
    @Column(name = "bairro", nullable = false)
    private String bairro;
    @Column(name = "cep", nullable = false)
    private String cep;
    @Column(name = "complemento", nullable = false)
    private String complemento;
    @Column(name = "nomeLogradouro", nullable = false)
    private String nomeLogradouro;
    @Column(name = "numero", nullable = false)
    private String numero;
    
}
