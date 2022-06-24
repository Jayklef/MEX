package com.jayklef.mex.service;

import com.jayklef.mex.dto.BillDTO;
import com.jayklef.mex.entity.Bill;
import com.jayklef.mex.exception.BillNotFoundException;

import java.util.List;

public interface BillService {
    List<Bill> findAllBills();

    Bill saveBill(BillDTO billDTO);

    Bill findById(Long billId) throws BillNotFoundException;

    Bill update(Long billId, Bill bill);

}
