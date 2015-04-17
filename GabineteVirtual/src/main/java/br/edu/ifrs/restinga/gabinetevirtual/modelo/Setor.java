package br.edu.ifrs.restinga.gabinetevirtual.modelo;
// Generated Apr 16, 2015 9:07:41 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Setor generated by hbm2java
 */
@Entity
@Table(name="Setor"
    ,catalog="rh"
)
public class Setor  implements java.io.Serializable {


     private Integer id;
     private Setor setor;
     private String nome;
     private String responsavel;
     private String descricao;
     private String email;
     private Set setors = new HashSet(0);
     private Set servidors = new HashSet(0);

    public Setor() {
    }

    public Setor(Setor setor, String nome, String responsavel, String descricao, String email, Set setors, Set servidors) {
       this.setor = setor;
       this.nome = nome;
       this.responsavel = responsavel;
       this.descricao = descricao;
       this.email = email;
       this.setors = setors;
       this.servidors = servidors;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="Id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="IdSetor")
    public Setor getSetor() {
        return this.setor;
    }
    
    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    
    @Column(name="Nome", length=100)
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    
    @Column(name="Responsavel", length=100)
    public String getResponsavel() {
        return this.responsavel;
    }
    
    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    
    @Column(name="Descricao", length=100)
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    
    @Column(name="Email", length=100)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="setor")
    public Set getSetors() {
        return this.setors;
    }
    
    public void setSetors(Set setors) {
        this.setors = setors;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="SetorServidor", catalog="rh", joinColumns = { 
        @JoinColumn(name="setor_Id", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="servidor_MatriculaSiape", nullable=false, updatable=false) })
    public Set getServidors() {
        return this.servidors;
    }
    
    public void setServidors(Set servidors) {
        this.servidors = servidors;
    }




}


