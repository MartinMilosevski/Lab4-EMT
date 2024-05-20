package org.example.reservationmanagment.service.impl;

import lombok.AllArgsConstructor;
import org.example.reservationmanagment.domain.models.Reservation;
import org.example.reservationmanagment.domain.models.ReservationId;
import org.example.reservationmanagment.domain.models.WishListId;
import org.example.reservationmanagment.domain.repository.ReservationRepository;
import org.example.reservationmanagment.service.ReservationService;
import org.example.reservationmanagment.service.forms.WishListCarForm;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;


    @Override
    public ReservationId MakeReservation() {
        return null;
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Optional<Reservation> findById(ReservationId reservationId) {
        return reservationRepository.findById(reservationId);
    }

    @Override
    public void addCarInReservation(ReservationId reservationId, WishListCarForm wishListCarForm) {
        Reservation reservation=reservationRepository.findById(reservationId).orElseThrow(RuntimeException::new);
        reservation.addCarToWishList(wishListCarForm.getCar(),wishListCarForm.getQuantity());
        reservationRepository.saveAndFlush(reservation);
    }

    @Override
    public void deleteCarInReservation(ReservationId reservationId, WishListId wishListId) {
        Reservation reservation=reservationRepository.findById(reservationId).orElseThrow(RuntimeException::new);
        reservation.removeCarFromWishList(wishListId);
        reservationRepository.saveAndFlush(reservation);
    }




}
