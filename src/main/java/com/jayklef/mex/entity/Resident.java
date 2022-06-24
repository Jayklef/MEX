package com.jayklef.mex.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Date;
import java.util.Set;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Resident {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long residentId;
    private String firstname;
    private String lastname;
    private Date age;
    @Lob
    private byte[] image;
    private String gender;
    private String email;
    private String phoneNumber;

    @OneToMany
    private Set<Bill> bills;
}
