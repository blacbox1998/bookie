package group.luka.bookie.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "resourcereservationtype")
@Getter
@Setter
public class ResourceReservationTypeEntity {

    @Id
    private Integer id;

    @Column(name = "resource")
    private Integer resource;

    @Column(name = "reservationtype")
    private String reservationType;


}
