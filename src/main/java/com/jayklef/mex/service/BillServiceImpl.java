package com.jayklef.mex.service;

import com.jayklef.mex.dto.BillDTO;
import com.jayklef.mex.entity.Bill;
import com.jayklef.mex.exception.BillNotFoundException;
import com.jayklef.mex.repository.BillRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BillServiceImpl implements BillService{

    private BillRepository billRepository;

    public BillServiceImpl(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    @Override
    public List<Bill> findAllBills() {
        return billRepository.findAll();
    }

    @Override
    public Bill saveBill(BillDTO billDTO) {

        Bill newBill = Bill.builder()
                .billName(billDTO.getBillName())
                .amount(billDTO.getAmount())
                .build();
        return billRepository.save(newBill);
    }

    @Override
    public Bill findById(Long billId) throws BillNotFoundException{

        Optional<Bill> bill = billRepository.findById(billId);

        if (billId == null){
            throw new BillNotFoundException("No Bill found");
        }
        return billRepository.findById(billId).get();
    }

    @Override
    public Bill update(Long billId, Bill bill) {

        Bill billInDB = billRepository.findById(billId).get();
        if (Objects.nonNull(bill.getBillName()) && !bill.getBillName().isBlank()) {
            billInDB.setBillName(bill.getBillName());

            if (Objects.nonNull(bill.getAmount()) &&
                    !"".equalsIgnoreCase(bill.getAmount().toString())) {
                billInDB.setAmount(bill.getAmount());
            }

            if (Objects.nonNull(bill.getResident()) &&
                    !"".equalsIgnoreCase(bill.getResident().getResidentId().toString())) {
                billInDB.setResident(billInDB.getResident());
            }
        }
        return billRepository.save(billInDB);
    }
}
