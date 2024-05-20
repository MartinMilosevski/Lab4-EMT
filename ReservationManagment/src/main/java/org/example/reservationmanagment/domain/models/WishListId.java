package org.example.reservationmanagment.domain.models;

import lombok.NonNull;
import org.example.sharedkernel.domain.base.DomainObjectId;

public class WishListId extends DomainObjectId {

    private WishListId(){
        super(WishListId.randomId(WishListId.class).getId());
    }

    public WishListId(@NonNull String uuid){
        super(uuid);
    }

}
