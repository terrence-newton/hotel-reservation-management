package com.terrencenewton.hotelreservationmanagement.external.storage.roomtype;

import com.terrencenewton.hotelreservationmanagement.domain.roomtype.RoomType;
import com.terrencenewton.hotelreservationmanagement.domain.roomtype.RoomTypeAlreadyExistsException;
import com.terrencenewton.hotelreservationmanagement.domain.roomtype.RoomTypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Optional;

@RequiredArgsConstructor
@Log
public class RoomTypeStorageAdapter implements RoomTypeRepository {

    private final JpaRoomTypeRepository roomTypeRepository;
    private final RoomTypeEntityMapper mapper;

    @Override
    public RoomType save(final RoomType roomType) {
        try {
            RoomTypeEntity saved = roomTypeRepository.save(mapper.toEntity(roomType));
            log.info("Saved entity " + saved);
            return mapper.toDomain(saved);
        } catch (DataIntegrityViolationException ex) {
            log.warning("Room Type " + roomType.getName() + " already exits in db");
            throw new RoomTypeAlreadyExistsException();
        }
    }

    @Override
    public Optional<RoomType> findByName(final String name) {
        return roomTypeRepository.findByName(name).map(mapper::toDomain);
    }

    @Override
    public Optional<RoomType> findById(final Integer id) {
        return roomTypeRepository.findById(id).map(mapper::toDomain);
    }

    public Boolean existsById(Integer id) {
        return roomTypeRepository.existsById(id);
    }
}
