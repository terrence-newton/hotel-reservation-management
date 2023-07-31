package com.terrencenewton.hotelreservationmanagement.api.roomtype;

import com.terrencenewton.hotelreservationmanagement.domain.room.RoomStatus;
import com.terrencenewton.hotelreservationmanagement.domain.roomtype.RoomType;

public record RoomTypeDto(
        Integer id,
        String name,
        Integer maxOccupants,
        Boolean suite,
        Boolean balcony,
        String direction
) {
}
