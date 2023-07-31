package com.terrencenewton.hotelreservationmanagement.api.room;

import com.terrencenewton.hotelreservationmanagement.domain.room.RoomStatus;

public record SaveRoomDto(
        Integer id,
        RoomStatus status,
        Integer roomTypeId,
        Integer floor,
        String roomNumber
) {
}
