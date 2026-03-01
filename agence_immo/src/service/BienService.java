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
import dao.BienDao;
import model.Bien;

import java.util.List;

public class BienService {

    private BienDao dao = new BienDao();

    
    public boolean create(Bien b) {

        if (b == null) return false;
        if (b.getType() == null || b.getType().isEmpty()) return false;
        if (b.getVille() == null || b.getVille().isEmpty()) return false;
        if (b.getSurface() <= 0) return false;
        if (b.getPrixMensuel() <= 0) return false;
        if (b.getProprietaireId() <= 0) return false;

        return dao.create(b);
    }

    
    public boolean update(Bien b) {

        if (b == null) return false;
        if (b.getId() <= 0) return false;
        if (b.getSurface() <= 0) return false;
        if (b.getPrixMensuel() <= 0) return false;

        return dao.update(b);
    }

    
    public boolean supprimerBien(int id) {
        if (id <= 0) return false;
        return dao.delete(id);
    }

    
    public List<Bien> findAll() {
        return dao.findAll();
    }

    public Bien findById(int id) {
        if (id <= 0) return null;
        return dao.findById(id);
    }

    
    public List<Bien> findByVille(String ville) {
        if (ville == null || ville.isEmpty()) return null;
        return dao.findByVille(ville);
    }

    public List<Bien> findByType(String type) {
        if (type == null || type.isEmpty()) return null;
        return dao.findByType(type);
    }
}