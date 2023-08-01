package com.terrencenewton.external.storage.roomtype;

import com.terrencenewton.AbstractTestcontainers;
import com.terrencenewton.hotelreservationmanagement.domain.roomtype.RoomType;
import com.terrencenewton.hotelreservationmanagement.external.storage.roomtype.JpaRoomTypeRepository;
import com.terrencenewton.hotelreservationmanagement.external.storage.roomtype.RoomTypeEntityMapper;
import com.terrencenewton.hotelreservationmanagement.external.storage.roomtype.RoomTypeStorageAdapter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.verify;

public class RoomTypeTest extends AbstractTestcontainers {


    private RoomTypeStorageAdapter underTest;
    @Autowired
    private RoomTypeEntityMapper mapper;
    private AutoCloseable autoCloseable;
    @Mock
    private JpaRoomTypeRepository roomTypeRepository;
    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new RoomTypeStorageAdapter(roomTypeRepository, mapper);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void selectRoomTypeById() {
        //Given

        RoomType roomType = new RoomType();
        roomType.setName("Test Room");
        roomType.setBalcony(false);
        roomType.setSuite(true);
        roomType.setDirection("South");
        roomType.setMaxOccupants(2);

        underTest.save(roomType);

        //When
        underTest.existsById(1);

        //Then
        verify(roomTypeRepository).existsById(1);
    }
}
