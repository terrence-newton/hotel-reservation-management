package com.terrencenewton.hotelreservationmanagement.domain.room;


import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface RoomRepository {

    Room save(Room room);
    Optional<Room> findById(Integer id);
    Optional<Room> findByRoomNumber(String roomNumber);
    PageRoom findAll(Pageable pageable);
}
