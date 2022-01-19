package org.btssiomacon.balladins;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Classe d'affichage de la page d'annulation de réservation
 */
public class ShowAnnulReserv extends Fragment {

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
        view = inflater.inflate(R.layout.show_annul_reserv, container, false);

        Button btnValidAnnulRes = (Button) view.findViewById(R.id.btn_valid_annul_res);
        btnValidAnnulRes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Récupération du champ de nom et de la liste
                final EditText txtNum = view.findViewById(R.id.txt_num_res);
                final EditText txtCode = view.findViewById(R.id.txt_code_res);

                // Vérification que les champs sont bien remplis
                if (txtNum.getText().length() != 0 && txtCode.getText().length() > 0) {
                    // Mise en place de l'évènement de clic de la fenêtre de dialogue
                    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch (which) {
                                case DialogInterface.BUTTON_POSITIVE:
                                    BalladinsMethods.deleteReserv(getActivity(),
                                            Integer.parseInt(txtNum.getText().toString()),
                                            txtCode.getText().toString()
                                    );
                                    break;
                                case DialogInterface.BUTTON_NEGATIVE:

                                    break;
                            }
                        }
                    };

                    // Affichage de la fenêtre de dialogue
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage("Annuler la réservation n°" + txtNum.getText())
                            .setPositiveButton("Oui", dialogClickListener)
                            .setNegativeButton("Non", dialogClickListener).show();
                } else {
                    // Si un champ est vide affichage d'un message pour prévenir l'utilisateur
                    Toast.makeText(getActivity(), "Veuillez remplir tous les champs.",
                            Toast.LENGTH_SHORT).show();
                }
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