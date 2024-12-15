package group.luka.bookie.model;

import lombok.Data;

@Data
public class Customer {

    private Integer id;
    private String username;
    private String name;
    private boolean active;

}
