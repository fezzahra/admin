package com.admin.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table
public class Activity {

    @Id
    @GeneratedValue
    private int id;

    /*

    1 création agence
    2 modification agence
    3 suppression agence
    4 création agent
    5 modification agent
    6 suppression agent
    7 suppression client
    8 désactivation compte


     */
    private int typeAction;
    private Date date;
    private Long id_acteur;
    private Long id_objet;


    public Long getId_acteur() {
        return id_acteur;
    }

    public void setId_acteur(Long id_acteur) {
        this.id_acteur = id_acteur;
    }

    public Long getId_objet() {
        return id_objet;
    }

    public void setId_objet(Long id_objet) {
        this.id_objet = id_objet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTypeAction() {
        return typeAction;
    }

    public void setTypeAction(int typeAction) {
        this.typeAction = typeAction;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Activity(int id, int type_action) {
        this.id = id;
        this.typeAction = type_action;
    }

    public Activity() {
    }

    public Activity(int type_action) {
        this.typeAction = type_action;
    }

    public Activity(int type_action, Date date) {
        this.typeAction = type_action;
        this.date = date;
    }

    public Activity(int type_action, Date date, Long id_acteur, Long id_objet) {
        this.typeAction = type_action;
        this.date = date;
        this.id_acteur = id_acteur;
        this.id_objet = id_objet;
    }
}
