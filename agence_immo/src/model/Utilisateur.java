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
public class Utilisateur {
    private int id;
    private String login;
    private String passwordHash;
    private String email;

    
    public Utilisateur() {
    }

    
    public Utilisateur(String login, String passwordHash, String email) {
    this.login = login;
    this.passwordHash = passwordHash;
    this.email = email;
}

public Utilisateur(int id, String login, String passwordHash, String email) {
    this.id = id;
    this.login = login;
    this.passwordHash = passwordHash;
    this.email = email;
}

    
    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPasswordHash() {
        
        return passwordHash;
    }
    
    public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}
    
    

   
    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    
    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + id +
                ", login='" + login + '\'' +
                '}';
    }
}

