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
import dao.UtilisateurDao;
import model.Utilisateur;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;

public class UtilisateurService {

    private UtilisateurDao dao = new UtilisateurDao();

    
    private String generateSalt() {
        byte[] salt = new byte[16];
        new SecureRandom().nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    
    private String hashPassword(String password, String salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt.getBytes());
            byte[] hashed = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hashed);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    
     public boolean register(String login, String password, String email){
        String salt = generateSalt();
        String hash = hashPassword(password, salt);

        
        String stored = salt + "$" + hash;

        Utilisateur u = new Utilisateur(login, stored, email);
        return dao.create(u);
    }

    
    public boolean login(String login, String password) {
        Utilisateur u = dao.findByLogin(login);
        if (u == null) return false;

        
        String[] parts = u.getPasswordHash().split("\\$");
        if (parts.length != 2) return false;

        String salt = parts[0];
        String hash = parts[1];

        return hashPassword(password, salt).equals(hash);
    }
    
    public String resetPassword(String email) {

    Utilisateur u = dao.findByEmail(email);
    if (u == null) return null;

    String newPassword = "AG" + (int)(Math.random() * 10000);

    String salt = generateSalt();
    String hash = hashPassword(newPassword, salt);
    String stored = salt + "$" + hash;

    u.setPasswordHash(stored);
    dao.update(u);

    return newPassword;
}
}
