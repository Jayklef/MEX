package com.jayklef.mex.repository;

import com.jayklef.mex.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {

    @Query(value = "SELECT q FROM Bill q WHERE q.resident = :residentId")
    List<Bill> findAllByResidentId(Long residentId);
}
