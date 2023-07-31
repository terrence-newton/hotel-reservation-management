package com.terrencenewton.hotelreservationmanagement.api.room;

import com.terrencenewton.hotelreservationmanagement.domain.room.PageRoom;
import com.terrencenewton.hotelreservationmanagement.domain.room.Room;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PageRoomDtoMapper {

    @Mapping(target = "rooms", qualifiedByName = "toRoomDtoList")
    PageRoomDto toPageDto(PageRoom domain);

    @Named("toRoomDtoList")
    @IterableMapping(qualifiedByName = "roomToRoomDto")
    List<RoomDto> toListDto(List<Room> rooms);

    @Named("roomToRoomDto")
    RoomDto toDto(Room domain);
}
