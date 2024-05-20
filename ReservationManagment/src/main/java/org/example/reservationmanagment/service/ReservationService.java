package org.example.reservationmanagment.service;

import org.example.reservationmanagment.domain.models.Reservation;
import org.example.reservationmanagment.domain.models.ReservationId;
import org.example.reservationmanagment.domain.models.WishListId;
import org.example.reservationmanagment.service.forms.WishListCarForm;

import java.util.List;
import java.util.Optional;

public interface ReservationService {

    ReservationId MakeReservation();

    List<Reservation> getAllReservations();

    Optional<Reservation> findById(ReservationId reservationId);

    void addCarInReservation(ReservationId reservationId, WishListCarForm wishListCarForm);

    void deleteCarInReservation(ReservationId reservationId, WishListId wishListId);

}
