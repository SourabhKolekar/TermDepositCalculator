import org.example.utils.ValidationUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.example.utils.ValidationUtil.MAX_VALUE;
import static org.example.utils.ValidationUtil.MAX_VALUE_INVESTMENT_TERM;

public class ValidationUtilTest {
    @Test
    public void validateDoubleInput_valid_input() {
        double input = 1.10;
        double result = ValidationUtil.validateInput(input, "input");
        Assertions.assertEquals(input, result);
    }

    @Test
    public void validateDoubleInput_invalid_input_ZERO() {
        double input = 0;
        Assertions.assertThrows(IllegalArgumentException.class, () -> ValidationUtil.validateInput(input, "input"));
    }

    @Test
    public void validateDoubleInput_invalid_NEGATIVE_NUMBER() {
        double input = -10.10;
        Assertions.assertThrows(IllegalArgumentException.class, () -> ValidationUtil.validateInput(input, "input"));
    }

    @Test
    public void validateDoubleInput_invalid_MAX_PLUS_1() {
        double input = MAX_VALUE + 1;
        Assertions.assertThrows(IllegalArgumentException.class, () -> ValidationUtil.validateInput(input, "input"));
    }

    @Test
    public void validateIntInput_valid_input() {
        int input = 3;
        int result = ValidationUtil.validateInput(input, "input");
        Assertions.assertEquals(input, result);
    }

    @Test
    public void validateIntInput_invalid_input_ZERO() {
        int input = 0;
        Assertions.assertThrows(IllegalArgumentException.class, () -> ValidationUtil.validateInput(input, "input"));
    }

    @Test
    public void validateIntInput_invalid_NEGATIVE_NUMBER() {
        int input = -10;
        Assertions.assertThrows(IllegalArgumentException.class, () -> ValidationUtil.validateInput(input, "input"));
    }

    @Test
    public void validateDoubleInput_invalid_MAX_VALUE_PLUS_1() {
        int input = MAX_VALUE_INVESTMENT_TERM + 1;
        Assertions.assertThrows(IllegalArgumentException.class, () -> ValidationUtil.validateInput(input, "input"));
    }
}
