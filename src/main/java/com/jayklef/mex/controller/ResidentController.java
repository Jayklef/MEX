package com.jayklef.mex.controller;

import com.jayklef.mex.dto.ResidentDTO;
import com.jayklef.mex.entity.Bill;
import com.jayklef.mex.entity.Resident;
import com.jayklef.mex.exception.ResidentNotFoundException;
import com.jayklef.mex.repository.BillRepository;
import com.jayklef.mex.service.ResidentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/residents")
public class ResidentController {

    private ResidentService residentService;

    private BillRepository billRepository;

    public ResidentController(ResidentService residentService, BillRepository billRepository) {
        this.residentService = residentService;
        this.billRepository = billRepository;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Resident>> findAllResident(){
        List<Resident> residents = residentService.findAllResidents();
        return new ResponseEntity<>(residents, HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<Resident> saveResident(@RequestBody ResidentDTO residentDTO){
        Resident newResident = residentService.saveResident(residentDTO);
        return new ResponseEntity<>(newResident, HttpStatus.CREATED);
    }

    @PutMapping("/update/{residentId}")
    public ResponseEntity<Resident> updateResident(@PathVariable("residentId") Long residentId,
                                                   @RequestBody Resident resident){
        Resident updatedResident = residentService.updateResident(resident, residentId);
        return new ResponseEntity<>(updatedResident, HttpStatus.OK);
    }

    @GetMapping("/resident/{residentId}")
    public ResponseEntity<Resident> findResidentById(@PathVariable("residentId") Long residentId) throws ResidentNotFoundException {
        Resident resident = residentService.findById(residentId);
        return new ResponseEntity<>(resident, HttpStatus.OK);
    }

    @DeleteMapping("delete/{residentId}")
    public ResponseEntity<Resident> deleteResident(@PathVariable("residentId") Long residentId){
        Resident resident = residentService.deleteById(residentId);
        return new ResponseEntity<>(resident, HttpStatus.OK);
    }

    @GetMapping("{residentId}/bills")
    public ResponseEntity<List<Bill>> getAllBills(@PathVariable("residentId") Long residentId){
        List<Bill> bills = billRepository.findAllByResidentId(residentId);
        return new ResponseEntity<>(bills, HttpStatus.OK);
    }
}
