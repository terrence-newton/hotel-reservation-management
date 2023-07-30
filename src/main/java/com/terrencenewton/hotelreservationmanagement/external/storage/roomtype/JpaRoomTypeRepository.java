package com.terrencenewton.hotelreservationmanagement.external.storage.roomtype;

import com.terrencenewton.hotelreservationmanagement.domain.roomtype.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaRoomTypeRepository extends JpaRepository<RoomTypeEntity, Integer> {
    Optional<RoomTypeEntity> findByName(String name);
}
