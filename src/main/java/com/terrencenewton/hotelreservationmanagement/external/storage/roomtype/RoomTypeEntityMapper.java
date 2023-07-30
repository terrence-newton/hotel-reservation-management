package com.terrencenewton.hotelreservationmanagement.external.storage.roomtype;

import com.terrencenewton.hotelreservationmanagement.domain.roomtype.RoomType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoomTypeEntityMapper {

    RoomTypeEntity toEntity(RoomType domain);

    RoomType toDomain(RoomTypeEntity entity);

}
