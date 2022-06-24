package com.jayklef.mex.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class House {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private Long houseId;
    private String houseName;

    @OneToOne
    private Price price;

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private Set<Amenities> amenities;

    @ManyToOne
    private Category category;
}
