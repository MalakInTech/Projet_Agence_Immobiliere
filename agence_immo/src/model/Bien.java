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
public class Bien {
    private int id;
    private String type;
    private String ville;
    private double surface;
    private double prixMensuel;
    private int proprietaireId;

   
    public Bien() {
    }

    
    public Bien(String type, String ville, double surface, double prixMensuel, int proprietaireId) {
        this.type = type;
        this.ville = ville;
        this.surface = surface;
        this.prixMensuel = prixMensuel;
        this.proprietaireId = proprietaireId;
    }

    
    public Bien(int id, String type, String ville, double surface, double prixMensuel, int proprietaireId) {
        this.id = id;
        this.type = type;
        this.ville = ville;
        this.surface = surface;
        this.prixMensuel = prixMensuel;
        this.proprietaireId = proprietaireId;
    }

   
    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getVille() {
        return ville;
    }

    public double getSurface() {
        return surface;
    }

    public double getPrixMensuel() {
        return prixMensuel;
    }

    public int getProprietaireId() {
        return proprietaireId;
    }

   
    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setSurface(double surface) {
        this.surface = surface;
    }

    public void setPrixMensuel(double prixMensuel) {
        this.prixMensuel = prixMensuel;
    }

    public void setProprietaireId(int proprietaireId) {
        this.proprietaireId = proprietaireId;
    }

    // ===== toString (utile pour debug) =====
    @Override
    public String toString() {
        return "Bien{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", ville='" + ville + '\'' +
                ", surface=" + surface +
                ", prixMensuel=" + prixMensuel +
                ", proprietaireId=" + proprietaireId +
                '}';
    }
}

