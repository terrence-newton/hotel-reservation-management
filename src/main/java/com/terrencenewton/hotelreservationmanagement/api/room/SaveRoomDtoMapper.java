package com.terrencenewton.hotelreservationmanagement.api.room;

import com.terrencenewton.hotelreservationmanagement.domain.room.Room;
import com.terrencenewton.hotelreservationmanagement.domain.roomtype.RoomType;
import com.terrencenewton.hotelreservationmanagement.domain.roomtype.RoomTypeService;
import com.terrencenewton.hotelreservationmanagement.external.storage.room.RoomEntity;
import com.terrencenewton.hotelreservationmanagement.external.storage.roomtype.JpaRoomTypeRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class SaveRoomDtoMapper {
    @Autowired
    protected RoomTypeService roomTypeService;

    @Mapping(source = "roomTypeId", target = "roomType", qualifiedByName = "roomTypeIdToRoomType")
    abstract Room toDomain(SaveRoomDto dto);

    @Mapping(source = "roomType", target = "roomTypeId", qualifiedByName = "RoomTypeToRoomTypeId")
    abstract SaveRoomDto toDto(Room room);

    @Named("roomTypeIdToRoomType")
    public RoomType roomType(Integer roomTypeId) {
        return roomTypeService.findById(roomTypeId);
    }

    @Named("RoomTypeToRoomTypeId")
    public Integer roomTypeId(RoomType roomType) {
        return roomType.getId();
    }
}
