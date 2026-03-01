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
import model.Location;
import util.Connexion;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LocationDao implements IDao<Location> {

    private Connection cn = Connexion.getConnection();

    @Override
    public boolean create(Location l) {
        String sql = "INSERT INTO location(bien_id, dateDebut, dateFin, loyer) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, l.getBienId());
           ps.setDate(2, new java.sql.Date(l.getDateDebut().getTime()));
           ps.setDate(3, new java.sql.Date(l.getDateFin().getTime()));
            ps.setDouble(4, l.getLoyer());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Location l) {
        String sql = "UPDATE location SET bien_id=?, dateDebut=?, dateFin=?, loyer=? WHERE id=?";

        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, l.getBienId());
            ps.setDate(2, new java.sql.Date(l.getDateDebut().getTime()));
ps.setDate(3, new java.sql.Date(l.getDateFin().getTime()));
            ps.setDouble(4, l.getLoyer());
            ps.setInt(5, l.getId());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try (PreparedStatement ps = cn.prepareStatement("DELETE FROM location WHERE id=?")) {
            ps.setInt(1, id);
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Location findById(int id) {
        String sql = "SELECT * FROM location WHERE id=?";

        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Location(
                        rs.getInt("id"),
                        rs.getInt("bien_id"),
                        rs.getDate("dateDebut"),
                        rs.getDate("dateFin"),
                        rs.getDouble("loyer")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Location> findAll() {
        List<Location> list = new ArrayList<>();

        try (PreparedStatement ps = cn.prepareStatement("SELECT * FROM location")) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Location(
                        rs.getInt("id"),
                        rs.getInt("bien_id"),
                        rs.getDate("dateDebut"),
                        rs.getDate("dateFin"),
                        rs.getDouble("loyer")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<Object[]> getLoyerParVille() {
    List<Object[]> liste = new ArrayList<>();
    String sql = "SELECT b.ville, SUM(l.loyer) " +
                 "FROM location l JOIN bien b ON l.bien_id = b.id " +
                 "GROUP BY b.ville";

    try {
        PreparedStatement ps = cn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Object[] row = new Object[2];
            row[0] = rs.getString(1); // ville
            row[1] = rs.getDouble(2); // total loyers
            liste.add(row);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return liste;
}
    
   
}

