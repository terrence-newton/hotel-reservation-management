package com.terrencenewton.hotelreservationmanagement.domain.room;

import com.terrencenewton.hotelreservationmanagement.domain.roomtype.RoomType;
import lombok.Data;

@Data
public class Room {
    private Integer id;
    private RoomStatus status;
    private RoomType roomType;
    private Integer floor;
    private String roomNumber;
}
