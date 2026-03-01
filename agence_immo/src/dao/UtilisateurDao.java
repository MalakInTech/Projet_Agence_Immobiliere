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
import model.Utilisateur;
import util.Connexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UtilisateurDao implements IDao<Utilisateur> {

    private Connection cn = Connexion.getConnection();

    @Override
    public boolean create(Utilisateur u) {
        String sql = "INSERT INTO utilisateur(login, passwordHash, email) VALUES (?, ?, ?)";

        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, u.getLogin());
            ps.setString(2, u.getPasswordHash()); 
            ps.setString(3, u.getEmail());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Utilisateur u) {
        String sql = "UPDATE utilisateur SET login=?, passwordHash=? WHERE id=?";

        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, u.getLogin());
            ps.setString(2, u.getPasswordHash());
            ps.setInt(3, u.getId());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try (PreparedStatement ps = cn.prepareStatement("DELETE FROM utilisateur WHERE id=?")) {
            ps.setInt(1, id);
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Utilisateur findById(int id) {
        String sql = "SELECT * FROM utilisateur WHERE id=?";

        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Utilisateur(
                        rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("passwordHash"),
                        rs.getString("email")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Utilisateur> findAll() {
        List<Utilisateur> list = new ArrayList<>();

        try (PreparedStatement ps = cn.prepareStatement("SELECT * FROM utilisateur")) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Utilisateur(
                        rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("passwordHash"),
                        rs.getString("email")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Utilisateur findByLogin(String login) {
        String sql = "SELECT * FROM utilisateur WHERE login=?";

        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Utilisateur(
    rs.getInt("id"),
    rs.getString("login"),
    rs.getString("passwordHash"),
    rs.getString("email")
);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Utilisateur findByEmail(String email) {
    String sql = "SELECT * FROM utilisateur WHERE email=?";

    try (PreparedStatement ps = cn.prepareStatement(sql)) {
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return new Utilisateur(
                rs.getInt("id"),
                rs.getString("login"),
                rs.getString("passwordHash"),
                rs.getString("email")
            );
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}
    
}