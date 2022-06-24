package com.jayklef.mex.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {

    private Timestamp timestamp;
    private String status;
    private String error;
    private String message;
}
