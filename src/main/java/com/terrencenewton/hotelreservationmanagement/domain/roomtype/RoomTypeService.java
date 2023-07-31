package com.terrencenewton.hotelreservationmanagement.domain.roomtype;

import com.terrencenewton.hotelreservationmanagement.domain.room.Room;
import com.terrencenewton.hotelreservationmanagement.domain.room.RoomNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RoomTypeService {

    private final RoomTypeRepository roomTypeRepository;

    public RoomType save(RoomType roomType) {
        return roomTypeRepository.save(roomType);
    }

    public RoomType findById(Integer id) {
        return roomTypeRepository.findById(id)
                .orElseThrow(RoomTypeNotFoundException::new);
    }

}
