package group.luka.bookie.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservationstatus")
@Getter
@Setter
public class ReservationStatusEntity {

    @Id
    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

}
