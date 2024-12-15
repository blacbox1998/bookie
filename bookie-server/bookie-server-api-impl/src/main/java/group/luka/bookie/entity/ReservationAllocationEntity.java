package group.luka.bookie.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservationallocation")
@Getter
@Setter
public class ReservationAllocationEntity {

    @Id
    private Integer id;

    @Column(name = "reservationid")
    private Integer reservationId;

    @Column(name = "customer")
    private Integer customer;

    @Column(name = "resource")
    private Integer resource;

}
