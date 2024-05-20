package org.example.reservationmanagment.domain.valueobjects;

import org.example.sharedkernel.domain.base.DomainObjectId;

public class CARID extends DomainObjectId {

    private CARID() {
        super(CARID.randomId(CARID.class).getId());
    }

    public CARID(String uuid) {
        super(uuid);
    }

}
