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
import java.util.Date;

public class Location {
    private int id;
    private int bienId;
    private Date dateDebut;
    private Date dateFin;
    private double loyer;

    
    public Location() {
    }

    public Location(int bienId, Date dateDebut, Date dateFin, double loyer) {
        this.bienId = bienId;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.loyer = loyer;
    }

    
    public Location(int id, int bienId, Date dateDebut, Date dateFin, double loyer) {
        this.id = id;
        this.bienId = bienId;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.loyer = loyer;
    }

    
    public int getId() {
        return id;
    }

    public int getBienId() {
        return bienId;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public double getLoyer() {
        return loyer;
    }

    // ===== Setters =====
    public void setId(int id) {
        this.id = id;
    }

    public void setBienId(int bienId) {
        this.bienId = bienId;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public void setLoyer(double loyer) {
        this.loyer = loyer;
    }

    // ===== toString =====
    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", bienId=" + bienId +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", loyer=" + loyer +
                '}';
    }
}
