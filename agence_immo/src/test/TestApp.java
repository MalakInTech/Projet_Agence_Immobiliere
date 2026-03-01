/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author PC
 */

import model.*;
import service.*;

import java.text.SimpleDateFormat;
import java.util.List;

public class TestApp {

    public static void main(String[] args) throws Exception {

        BienService bienService = new BienService();
        ProprietaireService proprietaireService = new ProprietaireService();
        LocationService locationService = new LocationService();
        UtilisateurService utilisateurService = new UtilisateurService();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        
        System.out.println("===== TEST UTILISATEUR =====");

     
        boolean created = utilisateurService.register("admin", "1234","khadijaaziz670@gmail.com" );
        System.out.println("Utilisateur créé ? " + created);

boolean ok1 = utilisateurService.login("admin", "1234" );
System.out.println("Login correct ? " + ok1);

boolean ok2 = utilisateurService.login("admin", "wrong");
System.out.println("Login incorrect ? " + ok2);

        
        System.out.println("\n===== TEST PROPRIETAIRE =====");

        Proprietaire p = new Proprietaire(
                0,
                "Ahmed",
                "0600000000",
                "Marrakech"
        );

        boolean propAdded = proprietaireService.create(p);
        System.out.println("Proprietaire ajouté ? " + propAdded);

        List<Proprietaire> props = proprietaireService.findAll();
        System.out.println("Nombre proprietaires: " + props.size());

        if (props.isEmpty()) {
            System.out.println(" Aucun proprietaire trouvé !");
            return;
        }

        int proprietaireId = props.get(props.size() - 1).getId();

        
        System.out.println("\n===== TEST BIEN =====");

        Bien b = new Bien(
                0,
                "Appartement",
                "Marrakech",
                80,
                3000,
                proprietaireId
        );

        boolean bienAdded = bienService.create(b);
        System.out.println("Bien ajouté ? " + bienAdded);

        List<Bien> biens = bienService.findAll();
        System.out.println("Nombre biens: " + biens.size());

        if (biens.isEmpty()) {
            System.out.println("❌ Aucun bien trouvé !");
            return;
        }

        int bienId = biens.get(biens.size() - 1).getId();


        System.out.println("\n===== TEST LOCATION =====");

        Location loc = new Location(
                0,
                bienId,
                sdf.parse("2025-01-01"),
                sdf.parse("2025-06-01"),
                3000
        );

        boolean locAdded = locationService.create(loc);
        System.out.println("Location ajoutée ? " + locAdded);

        List<Location> locations = locationService.findAll();
        System.out.println("Nombre locations: " + locations.size());

        
        System.out.println("\n===== TEST FILTRE PAR VILLE =====");

        List<Bien> biensVille = bienService.findByVille("Marrakech");
        System.out.println("Biens à Marrakech: " + biensVille.size());

        
        System.out.println("\n===== TEST REVENUS PAR VILLE =====");

      List<Object[]> revenusList = locationService.getLoyerParVille();

     for (Object[] row : revenusList) {
    String ville = (String) row[0];
    double totalLoyer = (Double) row[1];

    if (ville.equalsIgnoreCase("Marrakech")) {
        System.out.println("Revenus Marrakech: " + totalLoyer);
    }
    }

        
        System.out.println("\n===== TEST DELETE BIEN =====");

        if (!biens.isEmpty()) {
            boolean deleted = bienService.supprimerBien(bienId);
            System.out.println("Bien supprimé ? " + deleted);
        }

        System.out.println("\n===== FIN DES TESTS =====");
    }
}
