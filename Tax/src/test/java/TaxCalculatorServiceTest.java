
import com.test.tax.model.TaxCalculatorResponse;
import com.test.tax.service.impl.TaxCalculatorServiceImpl;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 *
 * @author Derrick
 */
public class TaxCalculatorServiceTest {
    private final TaxCalculatorServiceImpl taxCalculatorService = new TaxCalculatorServiceImpl();

    @Test
    public void testCalculateTax() {
        // Test cases with different income levels and expectations

        // Test case 1: Income within bracket D
        double income1 = 37000;
        TaxCalculatorResponse response1 = taxCalculatorService.calculateTax(income1);
        assertEquals(720, response1.getTaxAmount());
        assertEquals("D", response1.getTaxSlab());

        // Test case 2: Income within bracket E
        double income2 = 55000;
        TaxCalculatorResponse response2 = taxCalculatorService.calculateTax(income2);
        assertEquals(2050, response2.getTaxAmount());
        assertEquals("E", response2.getTaxSlab());

        // Test case 3: Income above 2,000,000
        double income3 = 2500000;
        TaxCalculatorResponse response3 = taxCalculatorService.calculateTax(income3);
        assertEquals(750000, response3.getTaxAmount());
        assertEquals("J", response3.getTaxSlab());

    }
}
