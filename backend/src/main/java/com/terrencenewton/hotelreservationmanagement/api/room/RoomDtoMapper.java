package com.terrencenewton.hotelreservationmanagement.api.room;

import com.terrencenewton.hotelreservationmanagement.domain.room.Room;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoomDtoMapper {
    RoomDto toDto(Room domain);
    Room toDomain(RoomDto dto);
}
