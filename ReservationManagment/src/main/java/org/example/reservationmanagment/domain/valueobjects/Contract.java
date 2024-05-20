package org.example.reservationmanagment.domain.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.util.Date;

@Embeddable
@Getter
public class Contract {

    private final Date Start_Date;

    private final Date End_Date;

    protected  Contract(Date Start_Date, Date End_Date) {
        this.Start_Date = Start_Date;
        this.End_Date = End_Date;
    }

    protected Contract() {
        Start_Date = new Date();
        End_Date = new Date();
    }

    public boolean overlaps(Date startDateToCheck, Date endDateToCheck) {
        return !(endDateToCheck.before(this.Start_Date) || startDateToCheck.after(this.End_Date));
    }

}
