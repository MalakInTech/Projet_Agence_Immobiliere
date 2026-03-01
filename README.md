# 🏢 Agence Immobilière – Gestion complète des biens et locations

## Table des matières
1. [👥 Auteurs](#auteurs)  
2. [📝 Description du projet](#description-du-projet) 
3. [🛠 Technologies utilisées](#technologies-utilisees)
4. [🏷 Entités et attributs](#entites-et-attributs)  
5. [🏗 Architecture et couches](#architecture-et-couches) 
6. [📊 Diagrammes UML](#diagrammes-uml)
7. [✨ Fonctionnalités de l’application](#fonctionnalites-de-lapplication)  
8. [🧠 Logique métier](#logique-metier)  
9. [💾 Requêtes SQL et configuration de la base](#requetes-sql-et-configuration-de-la-base)  
10. [⚙️ Installation et exécution](#installation-et-execution)  
11. [🎁 Livrables finaux](#livrables-finaux)  
12. [📹 Video démo](#video-demo)  

---

## 👥 Auteurs
Ce projet a été réalisé par :  
- Malak El Mallouky  
- Khadija Aziz  

---

## 📝 Description du projet
Ce projet est une **application Java Swing** pour gérer une agence immobilière.  
Il permet de gérer :  
- les biens,  
- les propriétaires,  
- les locations.  
 

Fonctionnalités principales :  
- CRUD complet pour biens, propriétaires et locations,  
- Recherche et filtrage dans les JTable,  
- Statistiques des revenus locatifs par ville via graphiques JFreeChart.  

---

## 🛠 Technologies utilisées

- **Java** : Swing pour l’interface graphique
- **MySQL** : Base de données relationnelle  
  - Pour le projet, **Malak** a utilisé MySQL Workbench  
  - **Khadija** a utilisé XAMPP avec PhpMyAdmin
- **JDBC** : Pour la connexion et les opérations SQL
- **JFreeChart** : Pour l’affichage des graphiques
- **NetBeans IDE** : Développement Java
- **StarUML** : Création des diagrammes UML

---

## 🏷 Entités et attributs

### Bien
- **Type** : Appartement, Maison, Studio…  
- **Ville** : localisation du bien  
- **Surface** : en m²  
- **Prix mensuel** : loyer du bien  
- **Propriétaire associé**  

### Propriétaire
- **Nom**  
- **Contact** : téléphone ou email  
- **Adresse**  

### Location
- **Bien** : référence du bien loué  
- **Date de début**  
- **Date de fin**  
- **Loyer**  

### Utilisateur
- **Login**  
- **Mot de passe** (hashé pour sécurité)  

---

## 🏗  Architecture et couches
Le projet utilise un **MVC léger** :

1. **DAO (Data Access Object)**  
   - Accès aux données SQL  
   - CRUD pour chaque entité  

2. **Service (Logique métier)**  
   - Validation des données  
   - Calculs et règles métier (dates, revenus, sécurité)  
   - Gestion des utilisateurs et hashage des mots de passe  

3. **Interface graphique (Swing)**  
   - Formulaires CRUD et filtres  
   - JTable pour affichage dynamique  
   - Graphiques avec **JFreeChart**  

4. **Base de données (MySQL)**  
   - Tables : `bien`, `proprietaire`, `location`, `utilisateur`  
   - Données de test

       
![WhatsApp Image 2026-03-01 at 20 41 00](https://github.com/user-attachments/assets/3ddcc24f-b77c-401b-a19f-f23eb060a50a)

---

## 📊 Diagrammes UML

Le projet dispose de diagrammes UML pour mieux comprendre la structure et le fonctionnement :

1. **Diagramme de cas d’utilisation**  

<img width="743" height="561" alt="Capture d&#39;écran 2026-02-27 221939" src="https://github.com/user-attachments/assets/0ecf8a82-4f2b-4645-bc40-6a3eaf6e3e71" />

2. **Diagramme de classes**  

![WhatsApp Image 2026-03-01 at 15 14 19](https://github.com/user-attachments/assets/0dbe3cdf-359e-4c4f-91ec-57ce7cbc61df)

---

## ✨ Fonctionnalités de l’application

1. Gestion des biens : ajout, modification, suppression, filtrage par ville/type  
2. Gestion des propriétaires : CRUD complet  
3. Gestion des locations : ajout avec vérification des dates, calcul du revenu locatif  
4. Gestion des utilisateurs : ajout et authentification sécurisée  
5. Filtrage et recherche dans les JTable  
6. Statistiques : graphique des loyers totaux par ville  

---

## 🧠 Logique métier

- Les biens doivent avoir un type, une ville, une surface et un prix mensuel valides  
- Chaque bien doit être associé à un propriétaire existant  
- La date de fin d’une location doit être **après** la date de début  
- Les utilisateurs ont un mot de passe hashé (SHA-256 + sel)  
- Les revenus locatifs sont calculés par ville  

---

## 💾 Configuration de la base

### Instructions pour configurer la base :

1. Installer MySQL Workbench ou utiliser XAMPP.

2. Exécuter le fichier `agence_immo.sql` fourni.

3. Vérifier que toutes les tables et les données sont correctement créées.

---

## ⚙️ Installation et exécution

### Avec NetBeans

1. **Cloner le projet** depuis GitHub ou extraire le ZIP fourni.
2. **Ouvrir NetBeans**.
3. Aller dans **Fichier → Ouvrir un projet**.
4. Naviguer jusqu’au **dossier du projet “AgenceImmo”** (celui qui contient `src/`, `lib/` et `nbproject/`) et cliquer sur **Ouvrir le projet**.
5. Vérifier que toutes les **librairies nécessaires sont présentes** dans le dossier `lib/` et bien ajoutées dans le projet via **Propriétés → Bibliothèques**.
6. Faire un **Clean and Build** pour compiler le projet.
7. Pour lancer l’application, exécuter la **classe principale `UtilisateurForm.java`**.


### Avec le setup Windows

1. Ouvrir le dossier agence_immo_setup/ du projet qui contient agence_immo_Setup.exe.

2. Double‑cliquer sur agence_immo_Setup.exe pour installer l’application.

3. Suivre les instructions de l’installateur (choix du dossier, création de raccourcis).

4. Lancer l’application via le raccourci créé sur le Bureau.

---

## 🎁 Livrables finaux

- Code source complet (src/, nbproject/)

- Base SQL (agence_immo.sql)

- README avec instructions

- Setup Windows via Inno Setup (agence_immo_setup/agence_immo_Setup.exe)

---

## 📹 Video démo 


[▶️ Voir la vidéo](vidéo.mp4)























