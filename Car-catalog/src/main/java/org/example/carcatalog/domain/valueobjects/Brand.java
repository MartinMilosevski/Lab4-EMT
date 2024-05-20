package org.example.carcatalog.domain.valueobjects;


import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import lombok.Getter;
import lombok.NonNull;

import java.sql.Date;

@Embeddable
@Getter
public class Brand {
    private final String Manufacturer;

    private final String color;

    private final int Year_of_Production;

    private final String Country;


    protected Brand(){
        Manufacturer="";
        color="";
        Year_of_Production=2003;
        Country="";
    }

    protected Brand(@NonNull String Manufacturer, @NonNull String color, int Year_of_Production,@NonNull String Country) {
        this.Manufacturer = Manufacturer;
        this.color = color;
        this.Year_of_Production = Year_of_Production;
        this.Country = Country;
    }



}
