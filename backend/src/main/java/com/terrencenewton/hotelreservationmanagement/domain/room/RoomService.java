package com.terrencenewton.hotelreservationmanagement.domain.room;

import com.terrencenewton.hotelreservationmanagement.domain.roomtype.RoomTypeNotFoundException;
import com.terrencenewton.hotelreservationmanagement.domain.roomtype.RoomTypeRepository;
import com.terrencenewton.hotelreservationmanagement.domain.roomtype.RoomTypeService;
import com.terrencenewton.hotelreservationmanagement.external.storage.room.RoomNumberAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;

@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;
    //private final RoomTypeService roomTypeService;
    private final RoomTypeRepository roomTypeRepository;

    public Room save(Room room) {

        if (roomRepository.findByRoomNumber(room.getRoomNumber()).isEmpty()) {
            throw new RoomNumberAlreadyExistsException();
        }

        if(!roomTypeRepository.existsById(room.getRoomType().getId())) {
            throw new RoomTypeNotFoundException();
        }

        return roomRepository.save(room);

    }

    public Room findById(Integer id) {
        return roomRepository.findById(id)
                .orElseThrow(RoomNotFoundException::new);
    }

    public PageRoom findAll(Pageable pageable) {
        return roomRepository.findAll(pageable);
    }
}
