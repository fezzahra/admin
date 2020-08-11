package com.admin.models;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Ville implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_ville;
    private String nomVille;

    public Long getId_ville() {
        return id_ville;
    }

    public void setId_ville(Long id_ville) {
        this.id_ville = id_ville;
    }

    public String getNomVille() {
        return nomVille;
    }

    public void setNomVille(String ville) {
        this.nomVille = ville;
    }

    public Ville(String ville) {
        this.nomVille = ville;
    }

    public Ville(){

    }

}
