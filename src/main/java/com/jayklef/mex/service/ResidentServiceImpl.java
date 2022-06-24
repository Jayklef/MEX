package com.jayklef.mex.service;

import com.jayklef.mex.dto.ResidentDTO;
import com.jayklef.mex.entity.Bill;
import com.jayklef.mex.entity.Resident;
import com.jayklef.mex.exception.ResidentNotFoundException;
import com.jayklef.mex.repository.BillRepository;
import com.jayklef.mex.repository.ResidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ResidentServiceImpl implements ResidentService{

    private ResidentRepository residentRepository;

    private BillRepository billRepository;

    @Autowired
    public ResidentServiceImpl(ResidentRepository residentRepository, BillRepository billRepository) {
        this.residentRepository = residentRepository;
        this.billRepository = billRepository;
    }

    @Override
    public List<Resident> findAllResidents() {

        return residentRepository.findAll().stream()
                .sorted(Comparator.comparing(Resident::getAge))
                .collect(Collectors.toList());
    }

    @Override
    public Resident saveResident(ResidentDTO residentDTO) {

        Resident newResident = Resident.builder()
                .firstname(residentDTO.getFirstname())
                .lastname(residentDTO.getLastname())
                .age(residentDTO.getAge())
                .image(residentDTO.getImage())
                .gender(residentDTO.getGender())
                .email(residentDTO.getEmail())
                .phoneNumber(residentDTO.getPhoneNumber())
                .bills(residentDTO.getBills())
                .build();

        return residentRepository.save(newResident);
    }

    @Override
    public Resident updateResident(Resident resident, Long residentId) {

        Resident residentInDb = residentRepository.findById(residentId).get();

        if (Objects.nonNull(resident.getFirstname()) &&
        !"".equalsIgnoreCase(resident.getFirstname())){
            residentInDb.setFirstname(residentInDb.getFirstname());
        }

        if (Objects.nonNull(resident.getLastname()) &&
        !"".equalsIgnoreCase(resident.getLastname())){
            residentInDb.setLastname(residentInDb.getLastname());
        }

        if (Objects.nonNull(resident.getAge()) &&
        !"".equalsIgnoreCase(resident.getAge().toString())){
            residentInDb.setAge(residentInDb.getAge());
        }

        if (Objects.nonNull(resident.getImage()) &&
        !"".equalsIgnoreCase(resident.getImage().toString())){
            residentInDb.setImage(residentInDb.getImage());
        }

        if (Objects.nonNull(resident.getGender()) &&
        !"".equalsIgnoreCase(resident.getGender())){
            residentInDb.setGender(residentInDb.getGender());
        }

        if (Objects.nonNull(resident.getEmail()) &&
        !"".equalsIgnoreCase(resident.getEmail())){
            residentInDb.setEmail(residentInDb.getEmail());
        }

        if (Objects.nonNull(resident.getPhoneNumber()) &&
        !"".equalsIgnoreCase(resident.getPhoneNumber())){
            residentInDb.setPhoneNumber(residentInDb.getPhoneNumber());
        }

        if (Objects.nonNull(resident.getBills().toArray()) &&
        !"".equalsIgnoreCase(String.valueOf(resident.getBills().toArray()))){
            residentInDb.setBills(residentInDb.getBills());
        }
        return residentRepository.save(residentInDb);
    }

    @Override
    public Resident findById(Long residentId) throws ResidentNotFoundException {

        Optional<Resident> resident = residentRepository.findById(residentId);

        if (resident == null){
            throw new ResidentNotFoundException("Resident not found");
        }

        return residentRepository.findById(residentId).get();
    }

    @Override
    public Resident deleteById(Long residentId) {

        Resident resident = residentRepository.findById(residentId).get();

        if (resident == null){
            throw new ResidentNotFoundException("resident not found");
        }

        residentRepository.deleteById(residentId);
        return resident;
    }

    @Override
    public List<Bill> findAllByResidentId(Long residentId) {

        List<Bill> bills = billRepository.findAllByResidentId(residentId);

        if (residentId == null){
            throw new ResidentNotFoundException("Resident not found");
        }

        return bills;
    }
}
