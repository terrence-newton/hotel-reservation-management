package com.terrencenewton.hotelreservationmanagement.domain.room;

import lombok.Value;

import java.io.Serializable;
import java.util.List;

@Value
public class PageRoom implements Serializable {
    List<Room> rooms;
    Integer currentPage;
    Integer totalPages;
    Long totalElements;
}
