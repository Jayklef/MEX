package com.jayklef.mex.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {

    private Long residentId;
    private Long billId;
    private BigDecimal accountBalance;
}
