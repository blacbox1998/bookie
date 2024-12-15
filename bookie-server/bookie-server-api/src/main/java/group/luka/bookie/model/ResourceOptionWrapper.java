package group.luka.bookie.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ResourceOptionWrapper {

    private Resource resource;
    private BigDecimal price;

}
