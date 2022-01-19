package org.btssiomacon.balladins;

import java.util.List;

/**
 * Classe d'objet Hotel
 */
public class Hotel {
    private int id;
    private String nom;
    private String adresse;
    private String complement;
    private String ville;
    private String codePostal;
    private String telephone;
    private String desCourt;
    private String desLong;
    private float prix;
    private List<Equipement> equipements;

    /**
     * Construit un objet Hotel
     * @param id Id
     * @param nom Nom
     * @param adresse Adresse
     * @param complement Complément d'adresse
     * @param ville Ville
     * @param codePostal Code postal
     * @param telephone Téléphone
     * @param desCourt Description courte
     * @param desLong Description longue
     * @param prix Prix
     * @param equipements Equipements
     */
    public Hotel(int id, String nom, String adresse, String complement, String ville,
                 String codePostal, String telephone, String desCourt, String desLong,
                 float prix, List<Equipement> equipements) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.complement = complement;
        this.ville = ville;
        this.codePostal = codePostal;
        this.telephone = telephone;
        this.desCourt = desCourt;
        this.desLong = desLong;
        this.prix = prix;
        this.equipements = equipements;
    }

    /**
     * Méthode de récupération de l'identifiant
     * @return Identifiant
     */
    public int getId() {
        return id;
    }

    /**
     * Fonction de définition de l'identifiant
     * @return Identifiant
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Méthode de récupération du nom
     * @return Nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Fonction de définition du nom
     * @return Nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Méthode de récupération de l'adresse
     * @return Adresse
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * Fonction de définition de l'adresse
     * @return Adresse
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * Méthode de récupération du complément d'adresse
     * @return Complément d'adresse
     */
    public String getComplement() {
        return complement;
    }

    /**
     * Fonction de définition du complément d'adresse
     * @return Complément d'adresse
     */
    public void setComplement(String complement) {
        this.complement = complement;
    }

    /**
     * Méthode de récupération de la ville
     * @return Ville
     */
    public String getVille() {
        return ville;
    }

    /**
     * Fonction de définition de la ville
     * @return Ville
     */
    public void setVille(String ville) {
        this.ville = ville;
    }

    /**
     * Méthode de récupération du code postal
     * @return Code postal
     */
    public String getCodePostal() {
        return codePostal;
    }

    /**
     * Fonction de définition du code postal
     * @return Code postal
     */
    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    /**
     * Méthode de récupération du numéro de téléphone
     * @return Numéro de téléphone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * Fonction de définition du numéro de téléphone
     * @return Numéro de téléphone
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * Méthode de récupération de la description courte
     * @return Description courte
     */
    public String getDesCourt() {
        return desCourt;
    }

    /**
     * Fonction de définition de la description courte
     * @return Description courte
     */
    public void setDesCourt(String desCourt) {
        this.desCourt = desCourt;
    }

    /**
     * Méthode de récupération de la description longue
     * @return Description longue
     */
    public String getDesLong() {
        return desLong;
    }

    /**
     * Fonction de définition de la description longue
     * @return Description longue
     */
    public void setDesLong(String desLong) {
        this.desLong = desLong;
    }

    /**
     * Méthode de récupération du prix
     * @return Prix
     */
    public float getPrix() {
        return prix;
    }

    /**
     * Fonction de définition du prix
     * @return Prix
     */
    public void setPrix(float prix) {
        this.prix = prix;
    }

    /**
     * Méthode de récupération de la liste d'équipements
     * @return Liste d'équipements
     */
    public List<Equipement> getEquipements() {
        return equipements;
    }

    /**
     * Fonction de définition de la liste d'équipements
     * @return Liste d'équipements
     */
    public void setEquipements(List<Equipement> equipements) {
        this.equipements = equipements;
    }
}
