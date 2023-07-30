package com.terrencenewton.hotelreservationmanagement.domain.roomtype;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class RoomType {
    private Integer id;
    private String name;
    private Integer maxOccupants;
    private Boolean suite;
    private Boolean balcony;
    private String direction;
}
