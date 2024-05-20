package org.example.reservationmanagment.service.forms;

import lombok.Data;
import org.example.reservationmanagment.domain.valueobjects.Car;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class WishListCarForm {

    @NotNull
    private Car car;

    @Min(1)
    private int quantity;
}
