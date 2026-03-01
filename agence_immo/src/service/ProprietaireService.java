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
import dao.ProprietaireDao;
import model.Proprietaire;

import java.util.List;

public class ProprietaireService {

    private ProprietaireDao dao = new ProprietaireDao();

    public boolean create(Proprietaire p) {
        if (p.getNom() == null || p.getNom().isEmpty()) return false;
        return dao.create(p);
    }

    public boolean update(Proprietaire p) {
        return dao.update(p);
    }

    public boolean delete(int id) {
        return dao.delete(id);
    }

    public Proprietaire findById(int id) {
        return dao.findById(id);
    }

    public List<Proprietaire> findAll() {
        return dao.findAll();
    }

    
}
