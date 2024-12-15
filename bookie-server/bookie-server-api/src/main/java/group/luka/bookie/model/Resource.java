package group.luka.bookie.model;

import lombok.Data;

@Data
public class Resource {

    private Integer id;
    private String username;
    private String name;
    private Integer workingUnit;
    private boolean active;

}
