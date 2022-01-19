package org.btssiomacon.balladins;

import android.content.Context;
import android.os.AsyncTask;

import java.net.URL;
import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Classe de récupération de données via HTTP
 */
public class ServerConnection extends AsyncTask<Void, Void, String> {

    private String host;
    private String complements;
    private Execution execution;

    /**
     * Constructeur
     * @param host Hôte du service web recherché
     * @param complements Compléments de l'URL (page recherchée)
     * @param execution Interface d'exécution
     */
    public ServerConnection(String host, String complements, Execution execution){
        super();
        this.host = host;
        this.complements = complements;
        this.execution = execution;
    }

    /**
     * Fonction exécutée
     * @param s Données récupérées
     */
    @Override
    protected void onPostExecute(String s) {
        execution.exec(s);
    }

    /**
     * Méthode exécutée en tâche de fond retournant les données récupérées
     * @param voids Méthodes
     * @return
     */
    @Override
    protected String doInBackground(Void... voids) {
        try {
            // Connexion à l'URL
            HttpURLConnection cnn = (HttpURLConnection) new URL("http://" + host + "/" + complements).openConnection();
            StringBuilder lines = new StringBuilder();
            // Lecture des données retournées par l'URL
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(cnn.getInputStream()));
            String line;
            // Lecture des données récupérées ligne par ligne
            while ((line = bufferedReader.readLine()) != null) {
                lines.append(line + "\n");
            }
            // Retour des données
            return lines.toString().trim();
        } catch (Exception e) {
            // En cas d'erreur écriture en console des erreurs
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Méthode de récupération de l'hôte
     * @return Hôte
     */
    public String getHost() {
        return host;
    }

    /**
     * Fonction de définition de l'hôte
     * @param host Hôte
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * Méthode de récupération du complément d'URL
     * @return Complément d'URL
     */
    public String getComplements() {
        return host;
    }

    /**
     * Fonction de définition du complément d'URL
     * @param complements Complément d'URL
     */
    public void setComplements(String complements) {
        this.complements = complements;
    }

    /**
     * Méthode de récupération de l'interface d'exécution
     * @return Interface d'exécution
     */
    public Execution getExecution() {
        return execution;
    }

    /**
     * Fonction de définition de l'interface d'exécution
     * @param execution Interface d'exécution
     */
    public void setExecution(Execution execution) {
        this.execution = execution;
    }
}