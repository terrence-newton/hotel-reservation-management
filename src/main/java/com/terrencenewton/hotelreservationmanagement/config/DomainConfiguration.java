package com.terrencenewton.hotelreservationmanagement.config;

import com.terrencenewton.hotelreservationmanagement.domain.roomtype.RoomTypeRepository;
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

}
