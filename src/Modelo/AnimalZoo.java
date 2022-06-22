/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author rodri
 */
@Entity
public class AnimalZoo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 255)
    private String nomeAnimal;
    @Column(length = 255)
    private String sexo;
    @Column(length = 255)
    private String veterinarioResponsavel;
    private String idJaula;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeAnimal() {
        return nomeAnimal;
    }

    public void setNomeAnimal(String nomeAnimal) {
        this.nomeAnimal = nomeAnimal;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getVeterinarioResponsavel() {
        return veterinarioResponsavel;
    }

    public void setVeterinarioResponsavel(String veterinarioResposanvel) {
        this.veterinarioResponsavel = veterinarioResposanvel;
    }

    public String getIdJaula() {
        return idJaula;
    }

    public void setIdJaula(String idJaula) {
        this.idJaula = idJaula;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
        hash = 41 * hash + Objects.hashCode(this.nomeAnimal);
        hash = 41 * hash + Objects.hashCode(this.sexo);
        hash = 41 * hash + Objects.hashCode(this.veterinarioResponsavel);
        hash = 41 * hash + Objects.hashCode(this.idJaula);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AnimalZoo other = (AnimalZoo) obj;
        if (!Objects.equals(this.nomeAnimal, other.nomeAnimal)) {
            return false;
        }
        if (!Objects.equals(this.sexo, other.sexo)) {
            return false;
        }
        if (!Objects.equals(this.veterinarioResponsavel, other.veterinarioResponsavel)) {
            return false;
        }
        if (!Objects.equals(this.idJaula, other.idJaula)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AnimalZoo{" + "id=" + id + ", nomeAnimal=" + nomeAnimal + ", sexo=" + sexo + ", veterinarioResponsavel=" + veterinarioResponsavel + ", idJaula=" + idJaula + '}';
    }
}
