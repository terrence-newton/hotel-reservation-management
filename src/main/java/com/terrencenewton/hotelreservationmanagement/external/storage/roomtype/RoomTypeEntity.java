package com.terrencenewton.hotelreservationmanagement.external.storage.roomtype;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "room_type_name_unique",
                        columnNames = "name"
                )
        }
)
@Getter
@Setter
@NoArgsConstructor
public class RoomTypeEntity {
    @Id
    @SequenceGenerator(
            name = "room_type_id_seq",
            sequenceName = "room_type_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "room_type_id_seq"
    )
    private Integer id;
    @Column(
            nullable = false
    )
    private String name;
    @Column(
            nullable = false
    )
    private Integer maxOccupants;
    @Column(
            nullable = false
    )
    private Boolean suite;
    @Column(
            nullable = false
    )
    private Boolean balcony;
    @Column(
            nullable = false
    )
    private String direction;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomTypeEntity that = (RoomTypeEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
