package com.terrencenewton.hotelreservationmanagement.external.storage.room;

import com.terrencenewton.hotelreservationmanagement.domain.room.Room;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class RoomEntityMapper {

    abstract RoomEntity toEntity(Room domain);

    abstract Room toDomain(RoomEntity entity);

}