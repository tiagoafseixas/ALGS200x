
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FibonacciService  {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final long n = scanner.nextLong();
        final long m = scanner.nextLong();
        scanner.close();
        
        System.out.println(computeMODM(n, m));
    }

    /**
     * Computes the mod of M for a given position of the fibonacci sequence
     * 
     * @param long n : the position of the fibonacci sequence that is to be calculated
     * @param long m : the modulo
     * 
     * @return BigDecimal the value of the modulo
     */
    private static final BigDecimal computeMODM(final long n, final long m) {
        final long periodM = FibonacciHelper.getPisanoPeriod(m);
        System.out.println(String.format("Period for %d is %d", m, periodM));

        final long targetN = n % periodM;
        System.out.println("#computeMODM -> Computing value for " + String.valueOf(targetN));

        return FibonacciHelper.compute(targetN).remainder(BigDecimal.valueOf(m));
    }

    /**
     * Class with helper functions.
     */
    static class FibonacciHelper {
        private static final HashMap<Long, BigDecimal> NUMBERS;
        private static final HashMap<Long, BigDecimal> PISANO;

        static {
            NUMBERS = new HashMap<Long, BigDecimal>();
            NUMBERS.put(0L, BigDecimal.ZERO);
            NUMBERS.put(1L, BigDecimal.ONE);

            PISANO = new HashMap<Long, BigDecimal>();

        }

        static final BigDecimal compute(final long position) {
            if (true == NUMBERS.containsKey(position)) {
                return NUMBERS.get(position);
            }
            // calculate and store values for all positions 
            for(int i = 0; i <= position; i++) {
                if(false == NUMBERS.containsKey((long) i)) {  NUMBERS.put((long) i, (compute(i - 1).add(compute(i - 2)))); }
            }

            System.out.println(String.format("#compute -> Returning value %s for position %d.", NUMBERS.get(position).toPlainString(), position));
            return NUMBERS.get(position);
        }

        static final void setPisanoPeriods(final long k, final long m) {
            long moduloI = 0;
            long moduloJ = 0;
            long i = 0;

            while(false == (moduloI == 0 && moduloJ == 1 )) {
                PISANO.put(
                    i,
                    compute(i - 1).remainder(BigDecimal.valueOf(m)).add(compute(i - 2).remainder(BigDecimal.valueOf(m)))
                );
            }
        }
    }   
}