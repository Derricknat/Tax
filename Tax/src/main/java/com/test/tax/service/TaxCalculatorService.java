package com.test.tax.service;

import com.test.tax.model.TaxCalculatorResponse;

/**
 *
 * @author Derrick
 */
public interface TaxCalculatorService {
    TaxCalculatorResponse calculateTax(double annualIncome);
}
