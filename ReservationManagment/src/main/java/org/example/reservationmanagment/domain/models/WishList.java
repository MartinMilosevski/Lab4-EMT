package org.example.reservationmanagment.domain.models;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import org.example.reservationmanagment.domain.valueobjects.CARID;
import org.example.reservationmanagment.domain.valueobjects.Contract;
import org.example.sharedkernel.domain.base.AbstractEntity;
import org.example.sharedkernel.domain.base.DomainObject;
import org.example.sharedkernel.domain.base.ValueObject;


@Entity
@Table(name = "wish_list")
@Getter
public class WishList extends AbstractEntity<WishListId> {

    private Integer MoneyPerDay;

    private Contract contract;

    private int NumberOfDays;

    @AttributeOverride(name="id",column = @Column(name = "car_id",nullable = false))
    private CARID carId;

    public WishList() {

    }

    public Integer subtotal(){
        return MoneyPerDay*NumberOfDays;
    }

    public WishList(@NonNull CARID carid,@NonNull Integer MoneyPrice,int NumberOfDays){

        this.carId=carid;
        this.MoneyPerDay=MoneyPrice;
        this.NumberOfDays=NumberOfDays;
    }

}
