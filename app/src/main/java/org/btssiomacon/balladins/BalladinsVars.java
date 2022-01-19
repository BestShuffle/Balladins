package org.btssiomacon.balladins;

import java.util.ArrayList;
import java.util.List;

/**
 * Interface contenant les variables globales
 */
public interface BalladinsVars {
    List<Hotel> hotels = new ArrayList<>();
    List<Reservation> reservations = new ArrayList<>();
    String HOST = "172.20.10.3";
}
