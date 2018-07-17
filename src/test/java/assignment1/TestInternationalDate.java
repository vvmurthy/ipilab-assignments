package assignment1;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestInternationalDate {
    @Test
    public void testAmericanDate(){

        // Note: DO NOT CHANGE ANY VARIABLES HERE
        String day = "20";
        String month = "January";
        String year = "2011";
        String answer = "January 20, 2011";

        // run your program
        String yourAnswer = InternationalDate.AmericanDate(day, month, year);

        // Check if the answers are equal
        assertEquals(answer, yourAnswer);
    }

    @Test
    public void testEuropeanDate(){
        // Note: DO NOT CHANGE ANY VARIABLES HERE
        String day = "20";
        String month = "January";
        String year = "2011";
        String answer = "20 January 2011";

        // run your program
        String yourAnswer = InternationalDate.EuropeanDate(day, month, year);

        // Check if the answers are equal
        assertEquals(answer, yourAnswer);
    }
}
