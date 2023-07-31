package com.terrencenewton.hotelreservationmanagement.api.room;

import java.util.List;

public record PageRoomDto(
        List<RoomDto> rooms,
        Integer currentPage,
        Integer totalPages,
        Long totalElements
) {
}
