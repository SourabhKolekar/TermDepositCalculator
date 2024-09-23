import org.example.model.TermDeposit;
import org.example.service.CalculateService;
import org.example.utils.Frequency;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculateServiceTest {

    CalculateService calculateService = new CalculateService();

    @Test
    public void testCalculateFinalBalance_at_Maturity() {
        TermDeposit termDeposit = new TermDeposit(10000.00, 1.10, 3, Frequency.AT_MATURITY);
        double result = calculateService.calculateFinalBalance(termDeposit);
        Assertions.assertEquals(10330, result);
    }

    @Test
    public void testCalculateFinalBalance_Annually() {
        TermDeposit termDeposit = new TermDeposit(10000.00, 1.10, 3, Frequency.ANNUALLY);
        double result = calculateService.calculateFinalBalance(termDeposit);
        Assertions.assertEquals(10334, result);
    }

    @Test
    public void testCalculateFinalBalance_Quarterly() {
        TermDeposit termDeposit = new TermDeposit(10000.00, 1.10, 3, Frequency.QUARTERLY);
        double result = calculateService.calculateFinalBalance(termDeposit);
        Assertions.assertEquals(10335, result);
    }

    @Test
    public void testCalculateFinalBalance_Monthly() {
        TermDeposit termDeposit = new TermDeposit(10000.00, 1.10, 3, Frequency.MONTHLY);
        double result = calculateService.calculateFinalBalance(termDeposit);
        Assertions.assertEquals(10335, result);
    }

    @Test
    public void testCalculateFinalBalance_Invalid_initialDepositAmount_Negative() {
        TermDeposit termDeposit = new TermDeposit(-10000.00, 1.10, 3, Frequency.ANNUALLY);
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculateService.calculateFinalBalance(termDeposit)) ;
    }

    @Test
    public void testCalculateFinalBalance_Invalid_initialDepositAmount_Zero() {
        TermDeposit termDeposit = new TermDeposit(0, 1.10, 3, Frequency.ANNUALLY);
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculateService.calculateFinalBalance(termDeposit)) ;
    }

    @Test
    public void testCalculateFinalBalance_Invalid_initialDepositAm_More_than_MAX() {
        TermDeposit termDeposit = new TermDeposit(20000000, 1.10, 3, Frequency.ANNUALLY);
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculateService.calculateFinalBalance(termDeposit)) ;
    }

    @Test
    public void testCalculateFinalBalance_Invalid_interest_rate_negative() {
        TermDeposit termDeposit = new TermDeposit(10000, -1.10, 3, Frequency.ANNUALLY);
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculateService.calculateFinalBalance(termDeposit)) ;
    }

    @Test
    public void testCalculateFinalBalance_Invalid_investment_term_negative() {
        TermDeposit termDeposit = new TermDeposit(10000, 1.10, -3, Frequency.ANNUALLY);
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculateService.calculateFinalBalance(termDeposit)) ;
    }

    @Test
    public void testCalculateFinalBalance_Invalid_investment_term_More_than_MAX_term() {
        TermDeposit termDeposit = new TermDeposit(10000, 1.10, 10, Frequency.ANNUALLY);
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculateService.calculateFinalBalance(termDeposit)) ;
    }

    @Test
    public void testCalculateFinalBalance_Invalid_Frequency() {
        TermDeposit termDeposit = new TermDeposit(10000, 1.10, 10, "invalid");
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculateService.calculateFinalBalance(termDeposit)) ;
    }
}
