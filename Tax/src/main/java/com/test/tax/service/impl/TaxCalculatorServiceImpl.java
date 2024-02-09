package com.test.tax.service.impl;

import com.test.tax.model.TaxBracket;
import com.test.tax.model.TaxCalculatorResponse;
import com.test.tax.service.TaxCalculatorService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Derrick
 */
@Service
public class TaxCalculatorServiceImpl implements TaxCalculatorService{
    
    public  List<TaxBracket> initializeTaxBrackets() {
        List<TaxBracket> taxBrackets = new ArrayList<>();
        taxBrackets.add(new TaxBracket('A', 0, 5000, 0, 0));
        taxBrackets.add(new TaxBracket('B', 0, 5000, 0, 0));
        taxBrackets.add(new TaxBracket('B', 5001, 20000, 1, 150));
        taxBrackets.add(new TaxBracket('C', 0, 20000, 0, 150));
        taxBrackets.add(new TaxBracket('C', 20001, 35000, 3, 450));
        taxBrackets.add(new TaxBracket('D', 0, 35000, 0, 600));
        taxBrackets.add(new TaxBracket('D', 35001, 50000, 6, 900));
        taxBrackets.add(new TaxBracket('E', 0, 50000, 0, 1500));
        taxBrackets.add(new TaxBracket('E', 50001, 70000, 11, 2200));
        taxBrackets.add(new TaxBracket('F', 0, 70000, 0, 3700));
        taxBrackets.add(new TaxBracket('F', 70001, 100000, 19, 5700));
        taxBrackets.add(new TaxBracket('G', 0, 100000, 0, 9400));
        taxBrackets.add(new TaxBracket('G', 100001, 400000, 25, 75000));
        taxBrackets.add(new TaxBracket('H', 0, 400000, 0, 84400));
        taxBrackets.add(new TaxBracket('H', 400001, 600000, 26, 52000));
        taxBrackets.add(new TaxBracket('I', 0, 600000, 0, 136400));
        taxBrackets.add(new TaxBracket('I', 600001, 2000000, 28, 392000));
        taxBrackets.add(new TaxBracket('J', 0, 2000000, 0, 528400));
        return taxBrackets;
    }
    
    public List<String> getTaxOptions(){
        List<String> taxOptions = new ArrayList();
        taxOptions.add("Medical expenses for parents <= RM 4000");
        taxOptions.add("Husband/wife/alimony <= RM 4000");
        return taxOptions;
    }
    
    
    @Override
    public TaxCalculatorResponse calculateTax(double annualIncome) {
        List<TaxBracket> taxBrackets = initializeTaxBrackets();
        
        double tax = 0.0;
        String taxCategory = "";
        for (int i = 0; i < taxBrackets.size(); i++) {
            if (annualIncome < taxBrackets.get(i).getMaxIncome()) {
                tax += (annualIncome - taxBrackets.get(i-1).getMaxIncome()) * taxBrackets.get(i).getRate() / 100 + taxBrackets.get(i-1).getFixedTax();
                taxCategory = String.valueOf(taxBrackets.get(i).getCategory());
                break;
            }
        }
        if(annualIncome > 2000000){
            tax = annualIncome * 0.3;
            taxCategory = "J";
        }
        TaxCalculatorResponse taxResponse = new TaxCalculatorResponse();
        taxResponse.setTaxAmount(tax);
        taxResponse.setTaxSlab(taxCategory);
        taxResponse.setTaxClaimOptions(getTaxOptions());
        return taxResponse;
    }
   
}
