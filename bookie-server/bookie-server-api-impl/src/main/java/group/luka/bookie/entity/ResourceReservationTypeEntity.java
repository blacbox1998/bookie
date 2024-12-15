package group.luka.bookie.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "resourcereservationtype")
@Getter
@Setter
public class ResourceReservationTypeEntity {

    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "resource")
    private ResourceEntity resource;

    @Column(name = "reservationtype")
    private String reservationType;

    @Column(name = "price")
    private BigDecimal price;


}
