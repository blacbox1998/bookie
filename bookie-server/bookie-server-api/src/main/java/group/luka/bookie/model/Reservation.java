package group.luka.bookie.model;

import lombok.Data;

import java.util.Date;

@Data
public class Reservation {

    private Integer id;
    private ReservationStatus status;
    private ReservationType type;
    private Integer customer;
    private Integer resource;
    private Date dateTime;

    private Date statusModifiedAt;
    private String statusModifiedBy;
    private Integer workingUnit;

}
