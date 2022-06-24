package com.jayklef.mex.controller;

import com.jayklef.mex.dto.BillDTO;
import com.jayklef.mex.entity.Bill;
import com.jayklef.mex.exception.BillNotFoundException;
import com.jayklef.mex.service.BillService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/bills")
public class BillController {

    private BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Bill>> getAllBills(){
        List<Bill> billsList = billService.findAllBills();
        return new ResponseEntity<>(billsList, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Bill> saveBill(@RequestBody BillDTO billDTO){
        Bill newbill = billService.saveBill(billDTO);
        return new ResponseEntity<>(newbill, HttpStatus.CREATED);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Bill> findById(@PathVariable ("billId") Long billId) throws BillNotFoundException {
        Bill bill = billService.findById(billId);
        return new ResponseEntity<>(bill, HttpStatus.OK);
    }

    @PutMapping("/update/{billId}")
    public ResponseEntity<Bill> updateBill(@PathVariable("billId") Long billId,
                                           @RequestBody Bill bill){
        Bill updateBill = billService.update(billId, bill);
        return new ResponseEntity<>(updateBill, HttpStatus.OK);
    }
}
