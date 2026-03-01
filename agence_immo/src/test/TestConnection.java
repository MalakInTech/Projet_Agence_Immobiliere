/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.Connection;
import util.Connexion;

public class TestConnection {
    public static void main(String[] args) {
        Connection cn = Connexion.getConnection();
        if (cn != null) {
            System.out.println(" Connexion réussie !");
        } else {
            System.out.println(" Connexion échouée !");
        }
    }
}