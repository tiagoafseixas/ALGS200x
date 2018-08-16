import java.util.Scanner;

public class SumOfTwoDigits {
    public static final void main(String[] args) {
        final Scanner s = new Scanner(System.in);
        final int a = s.nextInt();
        final int b = s.nextInt();
        s.close();
        System.out.println(add(a, b));
    }

    private static final int add(final int a, final int b) {
        return a + b;
    }
}