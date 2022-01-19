package org.btssiomacon.balladins;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Classe de gestion d'affichage d'hôtel
 */
public class ShowHotel extends Fragment implements BalladinsVars {

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
        view = inflater.inflate(R.layout.show_hotel, container, false);

        // Récupération des champs
        TextView lblName = (TextView) view.findViewById(R.id.lbl_hotel_name);
        TextView lblVilleCp = (TextView) view.findViewById(R.id.lbl_hotel_ville_cp);
        TextView lblAdr = (TextView) view.findViewById(R.id.lbl_hotel_adr);
        TextView lblComp = (TextView) view.findViewById(R.id.lbl_hotel_comp);
        TextView lblDesc = (TextView) view.findViewById(R.id.lbl_hotel_desclong);
        TextView lblPrix = (TextView) view.findViewById(R.id.lbl_hotel_prix);
        ListView lstEquips = (ListView) view.findViewById(R.id.lst_equips);

        // Récupération de l'hôtel sélectionné
        Hotel hotel = hotels.get(MainActivity.selectedHotel);

        // Affichage des données
        lblName.setText(hotel.getNom());
        lblVilleCp.setText(hotel.getVille() + " - " + hotel.getCodePostal());
        lblAdr.setText(hotel.getAdresse());
        lblComp.setText(hotel.getComplement());
        lblDesc.setText(hotel.getDesLong() + "\n");
        lblPrix.setText(hotel.getPrix() + "€");

        lstEquips.setAdapter(BalladinsMethods.hotelEquipsToAdapter(getActivity(), hotel));

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