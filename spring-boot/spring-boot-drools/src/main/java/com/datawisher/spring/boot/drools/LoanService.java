package com.datawisher.spring.boot.drools;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

/**
 * @author h407644
 * @date 2021-06-18
 */
public class LoanService implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) {
        // TODO Auto-generated method stub
        LoanApplicant loan = new LoanApplicant();
        loan.setName((String) execution.getVariable("name"));
        loan.setLoanAmount((Long) execution.getVariable("amount"));
        loan.setIncome((Long) execution.getVariable("salary"));
        execution.setVariable("loanapplicant", loan);
    }
}
