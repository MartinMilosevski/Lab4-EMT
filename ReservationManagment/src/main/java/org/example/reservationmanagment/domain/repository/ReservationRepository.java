package org.example.reservationmanagment.domain.repository;

import org.example.reservationmanagment.domain.models.Reservation;
import org.example.reservationmanagment.domain.models.ReservationId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, ReservationId> {
}
