package org.example.reservationmanagment.domain.models;

import lombok.NonNull;
import org.example.sharedkernel.domain.base.DomainObjectId;

public class ReservationId extends DomainObjectId {

    private ReservationId(){
        super(ReservationId.randomId(ReservationId.class).getId());
    }

    public ReservationId(@NonNull String uuid){
        super(uuid);
    }

}
