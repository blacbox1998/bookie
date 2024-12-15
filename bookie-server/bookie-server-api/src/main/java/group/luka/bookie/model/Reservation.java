package group.luka.bookie.model;

import lombok.Data;

import java.util.Date;

@Data
public class Reservation {

    private Integer id;
    private ReservationStatus status;
    private ReservationType type;
    private Date reservationDateTime;
    private ReservationAllocation allocation;

    private Date statusModifiedAt;
    private String statusModifiedBy;
    private Integer workingUnit;

}
