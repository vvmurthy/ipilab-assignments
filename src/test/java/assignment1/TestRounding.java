package assignment1;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

public class TestRounding {

    @Test
    public void TestBadRounding(){
        double n = 0.0; // TODO: fill in input
        int expectedOutput = 1; // TODO: fill in output for input

        assertEquals(expectedOutput, Rounding.BadRound(n));
    }

    @Test
    public void TestRoundPositiveDecimal(){
        double n = 0.1;
        int expectedOutput = 0;
        assertEquals(expectedOutput, Rounding.YourGoodRound(n));
    }

    @Test
    public void TestRoundPositiveDecimal2(){
        double n = 0.8;
        int expectedOutput = 1;
        assertEquals(expectedOutput, Rounding.YourGoodRound(n));
    }

    @Test
    public void TestRoundNegativeDecimal(){
        double n = -0.1;
        int expectedOutput = 0;
        assertEquals(expectedOutput, Rounding.YourGoodRound(n));
    }

    @Test
    public void TestRoundNegativeDecimal2(){
        double n = -0.8;
        int expectedOutput = -1;
        assertEquals(expectedOutput, Rounding.YourGoodRound(n));
    }
}
