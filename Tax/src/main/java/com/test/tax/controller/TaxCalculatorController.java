package com.test.tax.controller;

import com.test.tax.model.TaxCalculatorResponse;
import com.test.tax.service.TaxCalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Derrick
 */
@RestController
@RequestMapping("/tax")
@Api(value = "tax-controller", description = "Endpoints for handling and managing user items tax related operations", tags = "/tax")
public class TaxCalculatorController {
    private final TaxCalculatorService taxCalculatorService;

    public TaxCalculatorController(TaxCalculatorService taxCalculatorService) {
        this.taxCalculatorService = taxCalculatorService;
    }
    
    @GetMapping("")
    @ApiOperation(value = "Calculate Tax", response = TaxCalculatorResponse.class)
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "OK"),
                    @ApiResponse(code = 404, message = "Not Found"),
                    @ApiResponse(code = 500, message = "Internal Error"
                    )}
    )
    public TaxCalculatorResponse calculateTax(@RequestParam double annualIncome) {
        return taxCalculatorService.calculateTax(annualIncome);
    }
}
