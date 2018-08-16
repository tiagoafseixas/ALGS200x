import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class MaxSalary {

    static class StringNumComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            /**if(Integer.valueOf(s1.charAt(0)) > Integer.valueOf(s2.charAt(0))) {
                return -1;
            } else if (Integer.valueOf(s1.charAt(0)) < Integer.valueOf(s2.charAt(0))) {
                return 1;
            } else if (s1.equals(s2)) {
                return 0;
            }
    
            final char[] aArray = s1.toCharArray();
            final char[] bArray = s2.toCharArray();
            Arrays.sort(aArray);
            Arrays.sort(bArray);

            if(
                Character.getNumericValue(aArray[0]) >= Character.getNumericValue(bArray[0])
            ) {
                return -1;
            } else {
                return 1;
            }*/
            final int a = Integer.valueOf(s1 + s2 );
            final int b = Integer.valueOf(s2 + s1 );
            if(a > b) {
                return -1;
            } else if (b > a) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        final Scanner s = new Scanner(System.in);
        final int n = s.nextInt();

        final String[] digits = new String[n];
        for(int i = 0; i < n; i++) {
            digits[i] = String.valueOf(s.nextLong());
        }

        s.close();
        Arrays.sort(digits, new StringNumComparator());

        for(String i : digits) {
            System.out.print(i);
        }
        
    }

}