package assignment1;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestFizzBuzz {

    @Test
    public void TestMultipleOf3(){
        int n = 3;
        assertEquals("Fizz", FizzBuzz.FizzBuzz(n));
    }

    @Test
    public void TestMultipleOf5(){
        int n = 5;
        assertEquals("Buzz", FizzBuzz.FizzBuzz(n));
    }

    @Test
    public void TestMultipleOf15(){
        int n = 15;
        assertEquals("FizzBuzz", FizzBuzz.FizzBuzz(n));
    }

    @Test
    public void TestNonMultiple(){
        int n = 7;
        assertEquals("7", FizzBuzz.FizzBuzz(n));
    }
}
