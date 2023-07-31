package com.terrencenewton.hotelreservationmanagement.api.roomtype;

import com.terrencenewton.hotelreservationmanagement.domain.roomtype.RoomType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoomTypeDtoMapper {
    RoomTypeDto toDto(RoomType domain);
    RoomType toDomain(RoomTypeDto dto);
}
