package com.terrencenewton.hotelreservationmanagement.api.roomtype;

import com.terrencenewton.hotelreservationmanagement.domain.roomtype.RoomType;
import com.terrencenewton.hotelreservationmanagement.domain.roomtype.RoomTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/room-type",
        produces = "application/json",
        consumes = "application/json"
)
public class RoomTypeController {

    private final RoomTypeService roomTypeService;
    private final RoomTypeDtoMapper roomTypeDtoMapper;

    @PostMapping
    public ResponseEntity<RoomTypeDto> saveRoomType(@RequestBody RoomTypeDto dto) {

        RoomType roomType = roomTypeService.save(roomTypeDtoMapper.toDomain(dto));
        return ResponseEntity
                .ok(roomTypeDtoMapper.toDto(roomType));
    }

}
