package com.jayklef.mex.dto;

import com.jayklef.mex.entity.Amenities;
import com.jayklef.mex.entity.Category;
import com.jayklef.mex.entity.Price;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseDTO {

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
