package com.terrencenewton.hotelreservationmanagement.external.storage.room;

import com.terrencenewton.hotelreservationmanagement.domain.room.PageRoom;
import com.terrencenewton.hotelreservationmanagement.domain.room.Room;
import com.terrencenewton.hotelreservationmanagement.domain.room.RoomRepository;
import com.terrencenewton.hotelreservationmanagement.domain.roomtype.RoomTypeAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Log
public class RoomStorageAdapter implements RoomRepository {

    private final JpaRoomRepository roomRepository;
    private final RoomEntityMapper mapper;

    @Override
    public Room save(final Room room) {
        try {
            RoomEntity saved = roomRepository.save(mapper.toEntity(room));
            log.info("Saved entity " + saved);
            return mapper.toDomain(saved);
        } catch (DataIntegrityViolationException ex) {
            log.warning("Room Number " + room.getRoomNumber() + " already exits in db");
            throw new RoomTypeAlreadyExistsException();
        }
    }

    @Override
    public Optional<Room> findByRoomNumber(final String roomNumber) {
        return roomRepository.findByRoomNumber(roomNumber).map(mapper::toDomain);
    }

    @Override
    public Optional<Room> findById(final Integer id) {
        return roomRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public PageRoom findAll(Pageable pageable) {
        Page<RoomEntity> pageOfRoomEntity = roomRepository.findAll(pageable);
        List<Room> roomsOnCurrentPage = pageOfRoomEntity.getContent().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
        return new PageRoom(
                roomsOnCurrentPage,
                pageable.getPageNumber() + 1,
                pageOfRoomEntity.getTotalPages(),
                pageOfRoomEntity.getTotalElements()
        );
    }
}
