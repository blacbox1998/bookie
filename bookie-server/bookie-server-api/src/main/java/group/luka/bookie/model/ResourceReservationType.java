package group.luka.bookie.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ResourceReservationType {

    private Integer id;
    private Integer resource;
    private String reservationType;
    private BigDecimal price;

}
