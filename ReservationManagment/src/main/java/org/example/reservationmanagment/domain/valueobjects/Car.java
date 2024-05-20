package org.example.reservationmanagment.domain.valueobjects;


import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import org.example.sharedkernel.domain.base.ValueObject;

@Getter
public class Car implements ValueObject {

    private final CARID carid;
    private final String Name;
    private final Integer MoneyPerDay;

    private Car(){
        carid=CARID.randomId(CARID.class);
        Name="";
        MoneyPerDay=0;
    }

    @JsonCreator
    public Car(CARID carid, String name, Integer moneyPerDay) {
        this.carid = carid;
        Name = name;
        MoneyPerDay = moneyPerDay;
    }
}
