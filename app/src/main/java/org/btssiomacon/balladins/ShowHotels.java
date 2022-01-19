package org.btssiomacon.balladins;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Classe de gestion d'affichage de la liste d'hôtels
 */
public class ShowHotels extends Fragment implements BalladinsVars {

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
        view = inflater.inflate(R.layout.show_hotels, container, false);

        final ListView lstHotels = view.findViewById(R.id.lst_hotels);
        // Ajout de chaque hôtel dans l'adaptateur
        lstHotels.setAdapter(BalladinsMethods.hotelsToAdapter(getActivity()));

        lstHotels.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int i, long id) {
                // Récupération de l'hôtel sélectionné
                MainActivity.selectedHotel = i;

                getFragmentManager().beginTransaction().replace(R.id.content_frame,
                        new ShowHotel()).commit();
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
