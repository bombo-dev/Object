package object.domain;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private List<Reservation> reservations = new ArrayList<>();

    public void addReservation(Reservation reservation) {
        this.reservations.add(reservation);
    }
}
