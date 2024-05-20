package org.example.carcatalog.domain.models;

import lombok.NonNull;
import org.example.sharedkernel.domain.base.DomainObjectId;

public class CarId extends DomainObjectId {

    private CarId() {
        super(CarId.randomId(CarId.class).getId());
    }

    public CarId(@NonNull String uuid) {
        super(uuid);
    }

    public static CarId of(String uuid) {
        CarId p = new CarId(uuid);
        return p;
    }

}
