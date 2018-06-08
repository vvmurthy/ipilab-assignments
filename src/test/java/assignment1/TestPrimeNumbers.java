package assignment1;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestPrimeNumbers {

    @Test
    public void exampleBadPrime(){
        int n = 2;
        assertEquals(false, PrimeNumbers.BadPrimeExample(n));
    }

    @Test
    public void yourBadPrime1(){
        int n = 0; // TODO: add in number here
        boolean expectedAnswer = false; // TODO: add what the output of assignment3 should be
        assertEquals(expectedAnswer, PrimeNumbers.BadPrimeNumbers1(n)); // TODO: test should fail
    }

    @Test
    public void yourBadPrime2(){
        int n = 0; // TODO: add in number here
        boolean expectedAnswer = false; // TODO: add what the output of assignment3 should be
        assertEquals(expectedAnswer, PrimeNumbers.BadPrimeNumbers2(n)); // TODO: test should fail
    }

    @Test
    public void testYourGoodPrime1(){
        int n = 1;
        boolean expectedAnswer = false;
        assertEquals(expectedAnswer, PrimeNumbers.YourGoodPrimeNumbers(n)); // TODO: test should pass
    }

    @Test
    public void testYourGoodPrime2(){
        int n = 2;
        boolean expectedAnswer = true;
        assertEquals(expectedAnswer, PrimeNumbers.YourGoodPrimeNumbers(n)); // TODO: test should pass
    }

    @Test
    public void testYourGoodPrimePrimeAnswer(){
        int n = 7; // TODO: add in number here
        boolean expectedAnswer = true;
        assertEquals(expectedAnswer, PrimeNumbers.YourGoodPrimeNumbers(n));
    }

    @Test
    public void testYourGoodPrimeNonPrime(){
        int n = 9;
        boolean expectedAnswer = false;
        assertEquals(expectedAnswer, PrimeNumbers.YourGoodPrimeNumbers(n));
    }




}
