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
import model.Bien;
import util.Connexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BienDao implements IDao<Bien> {

    private Connection cn = Connexion.getConnection();

   
    @Override
    public boolean create(Bien b) {
        String sql = "INSERT INTO bien(type, ville, surface, prixMensuel, proprietaire_id) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, b.getType());
            ps.setString(2, b.getVille());
            ps.setDouble(3, b.getSurface());
            ps.setDouble(4, b.getPrixMensuel());
            ps.setInt(5, b.getProprietaireId());

            return ps.executeUpdate() == 1;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    
    @Override
    public boolean update(Bien b) {
        String sql = "UPDATE bien SET type=?, ville=?, surface=?, prixMensuel=?, proprietaire_id=? WHERE id=?";

        try (PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, b.getType());
            ps.setString(2, b.getVille());
            ps.setDouble(3, b.getSurface());
            ps.setDouble(4, b.getPrixMensuel());
            ps.setInt(5, b.getProprietaireId());
            ps.setInt(6, b.getId());

            return ps.executeUpdate() == 1;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

   
    
    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM bien WHERE id=?";

        try (PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() == 1;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    
    @Override
    public Bien findById(int id) {
        String sql = "SELECT * FROM bien WHERE id=?";

        try (PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Bien(
                        rs.getInt("id"),
                        rs.getString("type"),
                        rs.getString("ville"),
                        rs.getDouble("surface"),
                        rs.getDouble("prixMensuel"),
                        rs.getInt("proprietaire_id")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

   
    @Override
    public List<Bien> findAll() {
        List<Bien> list = new ArrayList<>();
        String sql = "SELECT * FROM bien";

        try (PreparedStatement ps = cn.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Bien(
                        rs.getInt("id"),
                        rs.getString("type"),
                        rs.getString("ville"),
                        rs.getDouble("surface"),
                        rs.getDouble("prixMensuel"),
                        rs.getInt("proprietaire_id")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    public List<Bien> findByVille(String ville) {
        List<Bien> list = new ArrayList<>();
        String sql = "SELECT * FROM bien WHERE ville=?";

        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, ville);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Bien(
                        rs.getInt("id"),
                        rs.getString("type"),
                        rs.getString("ville"),
                        rs.getDouble("surface"),
                        rs.getDouble("prixMensuel"),
                        rs.getInt("proprietaire_id")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    
public List<String> findVilles() {
    List<String> villes = new ArrayList<>();
    String sql = "SELECT DISTINCT ville FROM bien";

    try (PreparedStatement ps = cn.prepareStatement(sql)) {
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            villes.add(rs.getString("ville"));
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return villes;
}
    
    public List<Bien> findByType(String type) {
        List<Bien> list = new ArrayList<>();
        String sql = "SELECT * FROM bien WHERE type=?";

        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, type);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Bien(
                        rs.getInt("id"),
                        rs.getString("type"),
                        rs.getString("ville"),
                        rs.getDouble("surface"),
                        rs.getDouble("prixMensuel"),
                        rs.getInt("proprietaire_id")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<String> findTypes() {
    List<String> types = new ArrayList<>();
    String sql = "SELECT DISTINCT type FROM bien";

    try (PreparedStatement ps = cn.prepareStatement(sql)) {
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            types.add(rs.getString("type"));
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return types;
}
    
    
    
    
    
    
}


