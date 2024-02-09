package com.test.tax.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Derrick
 */
@Setter
@Getter
@Data
public class TaxBracket {
    private char category;
    private double minIncome;
    private double maxIncome;
    private double rate;
    private double fixedTax;
    
    public TaxBracket(char category, double minIncome, double maxIncome, double rate, double fixedTax){
        this.category = category;
        this.minIncome = minIncome;
        this.maxIncome = maxIncome;
        this.rate = rate;
        this.fixedTax = fixedTax;
    }
    
}
