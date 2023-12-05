import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RewardValueTests {
    private static final double DELTA = 1e-6;

    @Test
    void create_with_cash_value() {
        double cashValue = 100;
        var rewardValue = new RewardValue(cashValue);
        assertEquals(cashValue, rewardValue.getCashValue());
    }

    @Test
    void create_with_miles_value() {
        int milesValue = 10000;
        var rewardValue = new RewardValue(milesValue);
        System.out.println("Actual Value: " + rewardValue.getMilesValue());
        System.out.println("Expected Value: " + milesValue);
        System.out.println("Actual Cash Value: " + rewardValue.getCashValue());
        assertEquals(milesValue,rewardValue.getCashValue(),0.001);
    }

    @Test
    void convert_from_miles_to_cash() {
        // Given
        int milesValue = 10000;
        RewardValue rewardValue = new RewardValue(milesValue, true);

        // When
        double cashValue = rewardValue.getCashValue();

        // Then
        double expectedCashValue = milesValue * 0.0035;
        assertEquals(expectedCashValue, cashValue, 1); // Using a delta for double comparison
    }

    @Test
    void convert_from_cash_to_miles() {
        // Given
        int cashValue = 100;
        RewardValue rewardValue = new RewardValue(cashValue);

        // When
        double milesValue = rewardValue.getMilesValue();

        // Then
        double expectedMilesValue = cashValue / 0.0035;

        assertEquals(expectedMilesValue, milesValue, 1); // Using a delta for double comparison
    }


}
