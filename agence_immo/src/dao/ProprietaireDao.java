/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author PC
 */
import model.Proprietaire;
import util.Connexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProprietaireDao implements IDao<Proprietaire> {

    private Connection cn = Connexion.getConnection();

   
    @Override
    public boolean create(Proprietaire p) {
        String sql = "INSERT INTO proprietaire(nom, contact, adresse) VALUES (?, ?, ?)";

        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, p.getNom());
            ps.setString(2, p.getContact());
            ps.setString(3, p.getAdresse());

            return ps.executeUpdate() == 1;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


    @Override
    public boolean update(Proprietaire p) {
        String sql = "UPDATE proprietaire SET nom=?, contact=?, adresse=? WHERE id=?";

        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, p.getNom());
            ps.setString(2, p.getContact());
            ps.setString(3, p.getAdresse());
            ps.setInt(4, p.getId());

            return ps.executeUpdate() == 1;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM proprietaire WHERE id=?";

        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() == 1;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    
    @Override
    public Proprietaire findById(int id) {
        String sql = "SELECT * FROM proprietaire WHERE id=?";

        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Proprietaire(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("contact"),
                        rs.getString("adresse")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Proprietaire> findAll() {
        List<Proprietaire> list = new ArrayList<>();
        String sql = "SELECT * FROM proprietaire";

        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Proprietaire(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("contact"),
                        rs.getString("adresse")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}

