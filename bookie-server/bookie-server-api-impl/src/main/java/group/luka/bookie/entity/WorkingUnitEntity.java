package group.luka.bookie.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Table(name = "workingunit")
@Getter
@Setter
public class WorkingUnitEntity {

    @Id
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "address")
    private AddressEntity address;

}
