package com.terrencenewton.hotelreservationmanagement.domain.roomtype;

import java.util.List;
import java.util.Optional;

public interface RoomTypeRepository {

    RoomType save(RoomType roomType);

    Optional<RoomType> findById(Integer id);

    Optional<RoomType> findByName(String name);

    //List<RoomType> findAll();

}
