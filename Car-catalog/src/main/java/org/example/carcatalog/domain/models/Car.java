package org.example.carcatalog.domain.models;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import org.example.carcatalog.domain.valueobjects.Brand;
import org.example.sharedkernel.domain.base.AbstractEntity;

@Entity
@Table(name = "cars")
@Getter
public class Car extends AbstractEntity<CarId> {

    private String Name;

    @Embedded
    private Brand brand;

    private Integer MoneyPerDay;


    public Car(String Name, Brand brand, Integer MoneyPerDay){
        this.Name = Name;
        this.brand = brand;
        this.MoneyPerDay = MoneyPerDay;
    }

    public Car() {
        super(CarId.randomId(CarId.class));
    }

    public boolean MoneyPerDayIsValid(){
        return this.MoneyPerDay>=0;
    }

    public String DisplayCarInfo(){
        return this.Name+" - " + this.brand.getYear_of_Production()+ " година е по цена на ден: " +
            this.MoneyPerDay;
    }




}
