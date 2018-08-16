import java.util.Scanner;

public class GCD {
    
    public static final void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final long a = scanner.nextLong();
        final long b = scanner.nextLong();
        scanner.close();

        long r = 0L;
        if(a > b) {
            //r = computeGCD(a, b);
            r = computeLCM(a, b);
        } else {
            r = computeLCM(b, a);
        }

        System.out.println(r);
    }

    private static final long computeGCD(final long a, final long b) {

        if(b == 0L) return a;
        return computeGCD(b, a % b);
    }

    private static final long computeLCM(final long a, final long b) {
        return (a * b) / computeGCD(a, b);
    }

}