package com.terrencenewton.hotelreservationmanagement.config;

import com.terrencenewton.hotelreservationmanagement.domain.room.RoomRepository;
import com.terrencenewton.hotelreservationmanagement.domain.room.RoomService;
import com.terrencenewton.hotelreservationmanagement.domain.roomtype.RoomTypeRepository;
import com.terrencenewton.hotelreservationmanagement.domain.roomtype.RoomTypeService;
import com.terrencenewton.hotelreservationmanagement.external.storage.room.JpaRoomRepository;
import com.terrencenewton.hotelreservationmanagement.external.storage.room.RoomStorageAdapter;
import com.terrencenewton.hotelreservationmanagement.external.storage.room.RoomEntityMapper;
import com.terrencenewton.hotelreservationmanagement.external.storage.roomtype.JpaRoomTypeRepository;
import com.terrencenewton.hotelreservationmanagement.external.storage.roomtype.RoomTypeEntityMapper;
import com.terrencenewton.hotelreservationmanagement.external.storage.roomtype.RoomTypeStorageAdapter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("domain.properties")
@EnableConfigurationProperties
public class DomainConfiguration {

    @Bean
    public RoomTypeRepository roomTypeRepository(JpaRoomTypeRepository jpaRoomTypeRepository,
                                                 RoomTypeEntityMapper mapper) {
        return new RoomTypeStorageAdapter(jpaRoomTypeRepository, mapper);
    }

    @Bean
    public RoomRepository roomRepository(JpaRoomRepository jpaRoomRepository,
                                         RoomEntityMapper mapper) {
        return new RoomStorageAdapter(jpaRoomRepository, mapper);
    }

    @Bean
    public RoomService roomService(RoomRepository roomRepository, RoomTypeRepository roomTypeRepository) {
        return new RoomService(roomRepository, roomTypeRepository);
    }

    @Bean
    public RoomTypeService roomTypeService(RoomTypeRepository roomTypeRepository) {
        return new RoomTypeService(roomTypeRepository);
    }

}
