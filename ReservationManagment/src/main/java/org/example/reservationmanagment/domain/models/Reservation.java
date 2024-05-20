package org.example.reservationmanagment.domain.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import org.example.carcatalog.domain.models.CarId;
import org.example.reservationmanagment.domain.valueobjects.CARID;
import org.example.reservationmanagment.domain.valueobjects.Car;
import org.example.sharedkernel.domain.base.AbstractEntity;

import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Reservations")
@Getter
public class Reservation extends AbstractEntity<ReservationId> {

    private Integer TotalPriceToPay;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
    private Set<WishList> WishLists;

    public Integer calculateRentalPrice() {
        return WishLists.stream().map(WishList::subtotal).reduce(0, Integer::sum);
    }

    public WishList addCarToWishList(@NonNull Car CarToAdd,int quantity){
        Objects.requireNonNull(CarToAdd,"Car must be not null");
        var item=new WishList(CarToAdd.getCarid(),CarToAdd.getMoneyPerDay(),quantity);
        WishLists.add(item);
        return item;
    }

    public void removeCarFromWishList(@NonNull WishListId wishListId){
        Objects.requireNonNull(wishListId,"WishList Id must not be null");
        WishLists.removeIf(t->t.getId().equals(wishListId));
    }

    public boolean isAvailableForRental(Date startDate, Date endDate) {
        for (WishList wishList : WishLists) {
            if (wishList.getContract().overlaps(startDate, endDate)) {
                return false;
            }
        }
        return true;
    }


}
