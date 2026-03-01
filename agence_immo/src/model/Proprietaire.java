/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author PC
 */
public class Proprietaire {
    private int id;
    private String nom;
    private String contact;
    private String adresse;

    
    public Proprietaire() {
    }

    
    public Proprietaire(String nom, String contact, String adresse) {
        this.nom = nom;
        this.contact = contact;
        this.adresse = adresse;
    }

    
    public Proprietaire(int id, String nom, String contact, String adresse) {
        this.id = id;
        this.nom = nom;
        this.contact = contact;
        this.adresse = adresse;
    }

    
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getContact() {
        return contact;
    }

    public String getAdresse() {
        return adresse;
    }

    // ===== Setters =====
    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    // ===== toString =====
    @Override
    public String toString() {
        return "Proprietaire{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", contact='" + contact + '\'' +
                ", adresse='" + adresse + '\'' +
                '}';
    }
}
