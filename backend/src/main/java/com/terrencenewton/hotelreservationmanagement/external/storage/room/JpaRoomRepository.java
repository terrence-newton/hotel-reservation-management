package com.terrencenewton.hotelreservationmanagement.external.storage.room;

import com.terrencenewton.hotelreservationmanagement.domain.room.PageRoom;
import com.terrencenewton.hotelreservationmanagement.external.storage.roomtype.RoomTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaRoomRepository extends JpaRepository<RoomEntity, Integer> {

    Optional<RoomEntity> findById(Integer id);
    Optional<RoomEntity> findByRoomNumber(String roomNumber);

}
