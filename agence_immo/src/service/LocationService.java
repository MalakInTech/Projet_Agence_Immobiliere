/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

/**
 *
 * @author PC
 */
import dao.LocationDao;
import model.Location;

import java.util.List;

public class LocationService {

    private LocationDao dao = new LocationDao();

    public boolean create(Location l) {
        if (l.getDateFin().before(l.getDateDebut())) return false;
        return dao.create(l);
    }

    public boolean modifier(Location l) {
        return dao.update(l);
    }

    public boolean delete(int id) {
        return dao.delete(id);
    }

    public List<Location> findAll() {
        return dao.findAll();
    }

    public Location findById(int id) {
        return dao.findById(id);
    }

     public List<Object[]> getLoyerParVille() {
    return dao.getLoyerParVille();
}

    
}