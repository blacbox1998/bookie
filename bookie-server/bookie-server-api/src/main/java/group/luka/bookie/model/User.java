package group.luka.bookie.model;

import lombok.Data;

@Data
public class User {

    private String username;
    private String passwordHash;
    private String name;
    private UserType userType;
    private Address address;

}
