package com.terrencenewton.hotelreservationmanagement.api.room;

import com.terrencenewton.hotelreservationmanagement.domain.room.Room;
import com.terrencenewton.hotelreservationmanagement.domain.room.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/rooms",
        produces = "application/json"
)
public class RoomController {

    private final RoomService roomService;
    private final RoomDtoMapper roomDtoMapper;
    private final SaveRoomDtoMapper saveRoomDtoMapper;
    private final PageRoomDtoMapper pageRoomDtoMapper;

    @GetMapping( path = "/{id}")
    public ResponseEntity<RoomDto> getRoom(@PathVariable Integer id) {
        Room room = roomService.findById(id);
        return ResponseEntity
                .ok(roomDtoMapper.toDto(room));
    }

    @GetMapping
    public ResponseEntity<PageRoomDto> getRooms(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        PageRoomDto pageProviders = pageRoomDtoMapper.toPageDto(roomService.findAll(pageable));

        return ResponseEntity.ok(pageProviders);
    }

    @PostMapping
    public ResponseEntity<RoomDto> saveRoom(@RequestBody SaveRoomDto dto) {

        Room room = roomService.save(saveRoomDtoMapper.toDomain(dto));
        return ResponseEntity
                .ok(roomDtoMapper.toDto(room));
    }

}
