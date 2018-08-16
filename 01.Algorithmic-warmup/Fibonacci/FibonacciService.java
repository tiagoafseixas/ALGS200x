import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Scanner;

public class FibonacciService {

    static class FibonacciHelper {

        private static HashMap<Long, BigDecimal> NUMBERS;

        static {
            NUMBERS = new HashMap<Long, BigDecimal>();
            NUMBERS.put(0L, BigDecimal.ZERO);
            NUMBERS.put(1L, BigDecimal.ONE);
        }

        private static final long getPisanoPeriod(final long m) {
            long current=0, next=1, tmpNext=0;
            int period = 0;

            for (long i = 0; i <= ( m * m ); i++) {
                if (current==0 && next==1 && period > 0){ break; }
    
                tmpNext = ( current + next ) % m;
                current = next % m;
                next = tmpNext % m;
                period = period + 1;  
            }
            return period;
    
        }

        static final BigDecimal getFibonacciValue(final long index) {
            if(true == NUMBERS.containsKey(index)) {
                return NUMBERS.get(index);
            }

            for(int i = 0; i <= index; i++) {
                if(false == NUMBERS.containsKey((long) i)) {  NUMBERS.put((long) i, (getFibonacciValue(i - 1).add(getFibonacciValue(i - 2)))); }
            }

            return NUMBERS.get(index);
        }

        private static  boolean isPerfectSquare(long x)
        {
            int s = (int) Math.sqrt(x);
            return (s*s == x);
        }
            
        // Returns true if n is a Fibonacci Number, else false
        private static boolean isFibonacci(long n)
        {
            // n is Fibonacci if one of 5*n*n + 4 or 5*n*n - 4 or both
            // is a perfect square
            return isPerfectSquare(5*n*n + 4) ||
                    isPerfectSquare(5*n*n - 4);
        }
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final long n = scanner.nextLong();
        final long m = scanner.nextLong();
        scanner.close();

        final long p = FibonacciHelper.getPisanoPeriod(m);
        System.out.println(FibonacciHelper.getFibonacciValue(n % p).remainder(BigDecimal.valueOf(m)));
    }

}