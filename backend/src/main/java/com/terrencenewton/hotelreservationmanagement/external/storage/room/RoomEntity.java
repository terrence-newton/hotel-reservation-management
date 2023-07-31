package com.terrencenewton.hotelreservationmanagement.external.storage.room;

import com.terrencenewton.hotelreservationmanagement.domain.room.RoomStatus;
import com.terrencenewton.hotelreservationmanagement.domain.roomtype.RoomType;
import com.terrencenewton.hotelreservationmanagement.external.storage.roomtype.RoomTypeEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "room_number_unique",
                        columnNames = "roomNumber"
                )
        },
        name = "room"
)
@Getter
@Setter
@NoArgsConstructor
public class RoomEntity {
    @Id
    @SequenceGenerator(
            name = "room_id_seq",
            sequenceName = "room_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "room_id_seq"
    )
    private Integer id;

    @Column(
            nullable = false
    )
    @Enumerated(EnumType.STRING)
    private RoomStatus status;

    @ManyToOne
    @JoinColumn(
            name="roomTypeId",
            referencedColumnName = "id"
            ,nullable = false
    )
    private RoomTypeEntity roomType;

    @Column(
            nullable = false
    )
    private Integer floor;

    @Column(
            nullable = false
    )
    private String roomNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomEntity that = (RoomEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
