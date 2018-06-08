package assignment0;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestHelloLinearEq {

    @Test
    public void testZeroAsInput(){
        int X = 0;
        int y = HelloLinearEq.linearEquation(X);
        assertEquals(3, y);
    }

    @Test
    public void testNegativeInput(){
        int X = -1;
        int y = HelloLinearEq.linearEquation(X);
        assertEquals(-2, y);
    }

    @Test
    public void testPositiveInput(){
        int X = 1;
        int y = HelloLinearEq.linearEquation(X);
        assertEquals(8, y);
    }
}
