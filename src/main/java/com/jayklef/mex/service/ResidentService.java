package com.jayklef.mex.service;

import com.jayklef.mex.dto.ResidentDTO;
import com.jayklef.mex.entity.Bill;
import com.jayklef.mex.entity.Resident;
import com.jayklef.mex.exception.ResidentNotFoundException;

import java.util.List;

public interface ResidentService {
    List<Resident> findAllResidents();

    Resident saveResident(ResidentDTO residentDTO);

    Resident updateResident(Resident resident, Long residentId);

    Resident findById(Long residentId) throws ResidentNotFoundException;

    Resident deleteById(Long residentId);

    List<Bill> findAllByResidentId(Long residentId);
}
