package group.luka.bookie.model;

import lombok.Data;

@Data
public class ReservationAllocation {

    private Integer reservationId;
    private Customer customer;
    private Resource resource;

}
