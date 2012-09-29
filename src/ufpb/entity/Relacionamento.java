/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ufpb.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author Izabelly
 */
@Entity
@Table(name = "relacionamento", catalog = "editora", schema = "")
@XmlRootElement
public class Relacionamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.DELETE})
    private Conteudo idConteudoRelacionamento;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.DELETE})
    private Materia idMateriaRelacionamento;

    public Relacionamento() {
    }

    public Relacionamento(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Conteudo getIdConteudoRelacionamento() {
        return idConteudoRelacionamento;
    }

    public void setIdConteudoRelacionamento(Conteudo idConteudoRelacionamento) {
        this.idConteudoRelacionamento = idConteudoRelacionamento;
    }

    public Materia getIdMateriaRelacionamento() {
        return idMateriaRelacionamento;
    }

    public void setIdMateriaRelacionamento(Materia idMateriaRelacionamento) {
        this.idMateriaRelacionamento = idMateriaRelacionamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Relacionamento)) {
            return false;
        }
        Relacionamento other = (Relacionamento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdados.Relacionamento[ id=" + id + " ]";
    }
}
