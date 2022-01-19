package org.btssiomacon.balladins;

/**
 * Classe d'objet Equipement
 */
public class Equipement {
    private int id;
    private String libelle;

    /**
     * Construit un objet Equipement
     * @param id Id
     * @param libelle Libelle
     */
    public Equipement(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
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
     * Méthode de récupération du libelle
     * @return Libelle
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * Fonction de définition du libelle
     * @return Libelle
     */
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
