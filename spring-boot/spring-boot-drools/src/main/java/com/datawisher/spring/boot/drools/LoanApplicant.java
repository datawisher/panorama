package com.datawisher.spring.boot.drools;

import java.io.Serializable;
import lombok.Data;

/**
 * @author h407644
 * @date 2021-06-18
 */
@Data
public class LoanApplicant implements Serializable {

    public static final long serialVersionUID = 1L;

    private long income;
    private String name;
    private long loanAmount;
    private boolean checkCreditOk;
}
