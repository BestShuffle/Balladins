package org.btssiomacon.balladins;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe contenant les méthodes de gestion de l'application
 */
public class BalladinsMethods implements BalladinsVars {

    /**
     * Fonction de remplissage de la liste d'hôtels
     */
    public static void loadHotels() {
        // Connexion et récupération des données
        ServerConnection sC = new ServerConnection(BalladinsVars.HOST, "/android_balladins/hotels.php", new Execution() {
            @Override
            public void exec(String s) {
                try {
                    // Conversion de la chaîne de caractères en liste JSON
                    JSONArray elements = new JSONArray(s);
                    // Parcours de la liste
                    for (int i = 0; i < elements.length(); i++) {
                        // Récupération de l'objet en cours
                        JSONObject element = elements.getJSONObject(i);

                        final List<Equipement> equipements = new ArrayList<Equipement>();

                        /*
                            DEBUT EQUIPEMENTS
                         */

                        // Connexion et récupération des équipements
                        ServerConnection sC = new ServerConnection(BalladinsVars.HOST,
                                "/android_balladins/equips.php?idH=" +
                                        element.getInt("idH"), new Execution() {
                            @Override
                            public void exec(String s) {
                                try {
                                    // Conversion de la chaîne de caractères en liste JSON
                                    JSONArray elements = new JSONArray(s);
                                    // Parcours de la liste
                                    for (int i = 0; i < elements.length(); i++) {
                                        // Récupération de l'objet en cours
                                        JSONObject element = elements.getJSONObject(i);
                                        equipements.add(new Equipement(element.getInt("idE"),
                                                element.getString("libE")));
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                        sC.execute();
                        /*
                            FIN EQUIPEMENTS
                         */

                        // Ajout de l'hôtel dans la liste
                        // Conversion du type double natif de JSON en Float
                        hotels.add(new Hotel(element.getInt("idH"), element.getString("nomH"),
                                element.getString("adr1"), element.getString("adr2"),
                                element.getString("ville"), element.getString("cp"),
                                element.getString("tel"), element.getString("descourt"),
                                element.getString("deslong"),
                                BigDecimal.valueOf(element.getDouble("prix")).floatValue(),
                                equipements));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        sC.execute();
    }

    /**
     * Fonction retournant un adaptateur à partir d'une chaîne de caractères JSON
     * @param c Contexte actuel (page)
     * @return Adaptateur
     */
    public static ArrayAdapter<String> hotelsToAdapter(Context c) {
        // Création de l'adaptateur
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(c, android.R.layout.simple_list_item_1);
        // Parcours de la liste
        for (Hotel h : hotels) {
            // Ajout de la ligne à l'adaptateur
            adapter.add(h.getNom() + " - " + h.getVille());
        }
        return adapter;
    }

    /**
     * Fonction retournant un adaptateur à partir d'une chaîne de caractères JSON
     * @param c Contexte actuel (page)
     * @return Adaptateur
     */
    public static ArrayAdapter<String> hotelEquipsToAdapter(Context c, Hotel h) {
        // Création de l'adaptateur
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(c, android.R.layout.simple_list_item_1);
        // Parcours de la liste
        for (Equipement e : h.getEquipements()) {
            // Ajout de la ligne à l'adaptateur
            adapter.add(e.getLibelle());
        }
        return adapter;
    }

    /**
     * Fonction de remplissage de la liste de réservations à partir d'un nom
     * @param context Contexte
     * @param lst Liste
     * @param name Nom
     */
    public static void loadReservsFromName(final Context context, final ListView lst, String name) {
        // Connexion et récupération des données
        ServerConnection sC = new ServerConnection(BalladinsVars.HOST,
                "/android_balladins/reserv.php?nomR=" + name, new Execution() {
            @Override
            public void exec(String s) {
                try {
                    // Réinitialisation de la liste
                    reservations.clear();
                    // Conversion de la chaîne de caractères en liste JSON
                    JSONArray elements = new JSONArray(s);
                    // Parcours de la liste
                    for (int i = 0; i < elements.length(); i++) {
                        // Récupération de l'objet en cours
                        JSONObject element = elements.getJSONObject(i);
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                        // Ajout de l'hôtel dans la liste
                        // Conversion du type double natif de JSON en Float
                        // Conversion des dates String en objet Date
                        // Récupération d'un objet Hotel à partir d'un id
                        reservations.add(new Reservation(element.getInt("idR"), element.getString("nomR"),
                                element.getString("telR"), element.getString("codeR"),
                                formatter.parse(element.getString("datedebut")), formatter.parse(element.getString("datefin")),
                                getHotelFromId(element.getInt("idH")), element.getInt("nbChambres")));

                        // Affichage dans la liste
                        lst.setAdapter(BalladinsMethods.reservsToAdapter(context));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });
        sC.execute();
    }

    /**
     * Méthode permettant de supprimer une réservation en base de données
     * @param idR Numéro de réservation
     * @param codeR Code de réservation
     */
    public static void deleteReserv(final Context context, int idR, String codeR) {
        // Mise en final du contexte pour le rendre accessible à la classe anonyme
        // Connexion et envoi des données
        ServerConnection sC = new ServerConnection(BalladinsVars.HOST,
                "/android_balladins/annul.php?idR=" + idR + "&codeR=" + codeR, new Execution() {
            @Override
            public void exec(String s) {
                Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
            }
        });
        sC.execute();
    }

    /**
     * Fonction retournant un adaptateur à partir d'une chaîne de caractères JSON
     * @param c Contexte actuel (page)
     * @return Adaptateur
     */
    public static ArrayAdapter<String> reservsToAdapter(Context c) {
        // Création de la liste
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(c, android.R.layout.simple_list_item_1);
        // Création du formatteur de date
        DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        // Parcours de la liste
        for (Reservation r : reservations) {
            // Ajout de la ligne à l'adaptateur
            adapter.add(r.getHotel().getNom() + " - " + f.format(r.getDatedebut()) +
                    " - " + r.getNbChambres() + " chambre(s)");
        }
        return adapter;
    }

    /**
     * Fonction retournant un hôtel à partir d'un identifiant
     * @param idH Identifiant
     * @return Hôtel
     */
    public static Hotel getHotelFromId(int idH) {
        Hotel foundHotel = null;
        boolean found = false;
        int i = 0;
        // Parcours de la liste
        while (!found && i < hotels.size()) {
            // Vérification de l'identifiant
            if (hotels.get(i).getId() == idH) {
                // L'hôtel a été trouvé
                foundHotel = hotels.get(i);
                found = true;
            } else {
                i++;
            }
        }
        return foundHotel;
    }
}
