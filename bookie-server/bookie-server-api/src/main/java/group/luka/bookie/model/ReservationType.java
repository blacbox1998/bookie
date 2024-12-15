package group.luka.bookie.model;

import lombok.Data;

@Data
public class ReservationType {

    private String code;
    private String name;
    private Integer durationInMinutes;

}
