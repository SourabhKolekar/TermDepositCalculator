import org.example.utils.Frequency;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FrequencyTest {

    @Test
    public void testGetFrequencyFromSelection() {
        int[] frequency = {1, 2, 3, 4};

        Assertions.assertAll("frequency Selection",
                () -> Assertions.assertEquals(Frequency.MONTHLY, Frequency.getFrequencyFromSelection(frequency[0])),
                () -> Assertions.assertEquals(Frequency.QUARTERLY, Frequency.getFrequencyFromSelection(frequency[1])),
                () -> Assertions.assertEquals(Frequency.ANNUALLY, Frequency.getFrequencyFromSelection(frequency[2])),
                () -> Assertions.assertEquals(Frequency.AT_MATURITY, Frequency.getFrequencyFromSelection(frequency[3])));
    }

    @Test
    public void testGetFrequency() {
        String[] frequency = {Frequency.MONTHLY, Frequency.QUARTERLY,
                Frequency.ANNUALLY, Frequency.AT_MATURITY};

        Assertions.assertAll("frequency",
                () -> Assertions.assertEquals(12, Frequency.getFrequency(frequency[0])),
                () -> Assertions.assertEquals(4, Frequency.getFrequency(frequency[1])),
                () -> Assertions.assertEquals(1, Frequency.getFrequency(frequency[2])),
                () -> Assertions.assertEquals(1, Frequency.getFrequency(frequency[3])));
    }

    @Test
    public void testGetFrequency_InvalidFrequencySelection() {
        int selection = 7;
        Assertions.assertThrows(IllegalArgumentException.class, () -> Frequency.getFrequencyFromSelection(selection));
    }

    @Test
    public void testGetFrequency_InvalidFrequency() {
        String frequency = "invalid frequency";

        Assertions.assertThrows(IllegalArgumentException.class, () -> Frequency.getFrequency(frequency));
    }
}
