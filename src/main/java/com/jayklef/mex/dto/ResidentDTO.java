package com.jayklef.mex.dto;

import com.jayklef.mex.entity.Bill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Lob;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResidentDTO {

    private String firstname;
    private String lastname;

    @Lob
    private byte[] image;
    private String gender;
    private String email;
    private String phoneNumber;
    private Date age;

    @OneToMany
    private Set<Bill> bills;
}
