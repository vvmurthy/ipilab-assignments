package assignment1;

public class PrimeNumbers {

    public static boolean BadPrimeExample(int n){
        return false;
    }

    public static boolean BadPrimeNumbers1(int n){
        if(n % 2 == 1){
            return true;
        }else{
            return false;
        }
    }

    public static boolean BadPrimeNumbers2(int n){
        for(int i = 1 ; i <= n ; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }

    /**
     * A good implementation of prime numbers,
     * written by you.
     *
     * If assignment3 <= 1, return false (not really
     * definition of prime, but will work for now).
     *
     * if assignment3 == 2, return true
     *
     * Otherwise, for all numbers in between 2 and assignment3 - 1 inclusive,
     * if assignment3 is divisible by that number, return false.
     *
     * @param n input to determine whether it is prime
     * @return true if prime, false if not
     */
    public static boolean YourGoodPrimeNumbers(int n){
        return false; // TODO: delete and replace
    }

}
