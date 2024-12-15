package group.luka.bookie.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Address {

    private Integer id;
    private String email;
    private String phoneNumber;
    private String country;
    private String city;
    private String street;
    private String streetNumber;
    private BigDecimal latitude;
    private BigDecimal longitude;

}
