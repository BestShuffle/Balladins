package org.btssiomacon.balladins;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

/**
 * Classe d'affichage des réservations
 */
public class ShowReservations extends Fragment {

    private View view;

    /**
     * Méthode exécutée lors de la création d'une vue (affichage)
     * @param inflater Objet affichant la page
     * @param container Conteneur de la page
     * @param savedInstanceState Etat de l'instance sauvegardée
     * @return Vue générée
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.show_reservations, container, false);

        Button btnValidRechRes = (Button) view.findViewById(R.id.btn_valid_rech_res);
        btnValidRechRes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Récupération du champ de nom et de la liste
                EditText txtNom = view.findViewById(R.id.txt_nom);
                ListView lstReservations = view.findViewById(R.id.lst_reservations);
                // Chargement des réservations au nom de l'entrée utilisateur
                // et affichage de toutes les réservations ayant le nom entré par l'utilisateur
                BalladinsMethods.loadReservsFromName(getActivity(), lstReservations,
                        txtNom.getText().toString());
            }
        });
        return view;
    }

    /**
     * Méthode de récupération de la view
     * @return View
     */
    public View getView() {
        return view;
    }

    /**
     * Fonction de définition de la view
     * @return View
     */
    public void setView(View view) {
        this.view = view;
    }
}