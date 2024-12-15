package group.luka.bookie.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "resource")
@Getter
@Setter
public class ResourceEntity {

    @Id
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "name")
    private String name;

    @Column(name = "workingunit")
    private Integer workingUnit;

    @Column(name = "active")
    private boolean active;

}
