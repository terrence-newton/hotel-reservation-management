package com.terrencenewton.hotelreservationmanagement.api.room;

import com.terrencenewton.hotelreservationmanagement.domain.room.RoomStatus;
import com.terrencenewton.hotelreservationmanagement.domain.roomtype.RoomType;

public record RoomDto(
        Integer id,
        RoomStatus status,
        RoomType roomType,
        Integer floor,
        String roomNumber
) {
}
