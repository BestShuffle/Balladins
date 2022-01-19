package org.btssiomacon.balladins;

import java.util.Date;

/**
 * Classe d'objet Reservation
 */

class Reservation {

    private int id;
    private String nom;
    private String telephone;
    private String code;
    private Date datedebut;
    private Date datefin;
    private Hotel hotel;
    private int nbChambres;

    /**
     * Construit un objet réservation
     * @param id Identifiant
     * @param nom Nom
     * @param telephone Téléphone
     * @param code Code
     * @param datedebut Date de début
     * @param datefin Date de fin
     * @param hotel Hôtel
     * @param nbChambres Nombre de chambres
     */
    public Reservation(int id, String nom, String telephone, String code, Date datedebut,
                       Date datefin, Hotel hotel, int nbChambres) {
        this.id = id;
        this.nom = nom;
        this.telephone = telephone;
        this.code = code;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.hotel = hotel;
        this.nbChambres = nbChambres;
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
     * Méthode de récupération du code
     * @return Code
     */
    public String getCode() {
        return code;
    }

    /**
     * Fonction de définition du Code
     * @return Code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Méthode de récupération de la date de debut
     * @return Date de debut
     */
    public Date getDatedebut() {
        return datedebut;
    }

    /**
     * Fonction de définition de la date de debut
     * @return Date de debut
     */
    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    /**
     * Méthode de récupération de la date de fin
     * @return Date de fin
     */
    public Date getDatefin() {
        return datefin;
    }

    /**
     * Fonction de définition de la date de fin
     * @return Date de fin
     */
    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    /**
     * Méthode de récupération de l'hôtel
     * @return Hôtel
     */
    public Hotel getHotel() {
        return hotel;
    }

    /**
     * Fonction de définition de l'hôtel
     * @return Hôtel
     */
    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    /**
     * Méthode de récupération du nombre de chambres
     * @return Nombre de chambres
     */
    public int getNbChambres() {
        return nbChambres;
    }

    /**
     * Fonction de définition du nombre de chambres
     * @return Nombre de chambres
     */
    public void setNbChambres(int nbChambres) {
        this.nbChambres = nbChambres;
    }
}
