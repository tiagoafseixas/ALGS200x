import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Scanner;

public class FibonacciService {

    private static BigDecimal BIGDECIMALTEN;

    static {
        BIGDECIMALTEN = new BigDecimal(10);
    }

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
            //System.out.println(String.format("calculating fib value for index %d", index));

            if(true == NUMBERS.containsKey(index)) { return NUMBERS.get(index); }

            for(int i = 2; i <= index; i++) {
                NUMBERS.put((long) i, (getFibonacciValue(i - 1).add(getFibonacciValue(i - 2)))); 
            }

            return NUMBERS.get(index);
        }

        static final BigDecimal getSumofFibonacci(final long index) {
            return getFibonacciValue(index + 2).subtract(BigDecimal.ONE);
        }
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final long n = scanner.nextLong();
        scanner.close();

        final long period = FibonacciHelper.getPisanoPeriod(10);
        final long newTarget = n % period;
        System.out.println(FibonacciHelper.getSumofFibonacci(newTarget).remainder(BIGDECIMALTEN));
    }
}