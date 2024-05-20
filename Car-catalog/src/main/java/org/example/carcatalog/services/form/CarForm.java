package org.example.carcatalog.services.form;

import lombok.Data;
import org.example.carcatalog.domain.valueobjects.Brand;

@Data
public class CarForm {

    private String Name;
    private Brand brand;
    private Integer Money;

}
