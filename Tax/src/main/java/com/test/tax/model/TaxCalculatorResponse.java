package com.test.tax.model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Derrick
 */
@Getter
@Setter
public class TaxCalculatorResponse {
    private double taxAmount;
    public String taxSlab;
    public List<String> taxClaimOptions;
    
}
