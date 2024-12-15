package group.luka.bookie.entity;

import group.luka.bookie.model.ReservationStatus;
import group.luka.bookie.model.ReservationType;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reservation")
@Getter
@Setter
public class ReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reservationId")
    @SequenceGenerator(name="reservationId", sequenceName = "reservation_id_seq")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "status")
    private ReservationStatusEntity status;

    @ManyToOne
    @JoinColumn(name = "type")
    private ReservationTypeEntity type;

    @Column(name = "customer")
    private Integer customer;

    @Column(name = "resource")
    private Integer resource;

    @Column(name = "datetime")
    private Date dateTime;

    @Column(name = "statusmodifiedat")
    private Date statusModifiedAt;

    @Column(name = "statusmodifiedby")
    private String statusModifiedBy;

    @Column(name = "workingunit")
    private Integer workingUnit;


}
