import java.util.Arrays;
import java.util.Scanner;

public class MaxRevenueAd {

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);
        int items = s.nextInt();
        final int[] a = new int[items];
        final int[] b = new int[items];

        for (int i = 0; i < items; i++) {
            a[i] = s.nextInt();
        }

        for (int i = 0; i < items; i++) {
            b[i] = s.nextInt();
        }

        Arrays.sort(a);
        Arrays.sort(b);
        
        long total = 0;
        for(int i = 0; i < items; i++) {
            total += (long) a[i] * (long) b[i];
        }

        System.out.println(total);
    }

}