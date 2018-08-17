import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class MajorityElement {
    
    private static final boolean TEST_MODE_ON = false;

    static class MajorityElementService {
        static final int existsMajorityElement(final int[] a) {
            Arrays.sort(a);
            if(TEST_MODE_ON) {
                System.out.println(" a  = " + Arrays.toString(a));
            }
            int candidate = a[0];
            int count = 0;
            int target = a.length / 2 + 1;

            for(int i : a) {
                if(i == candidate) {
                    count += 1;
                } else {
                    candidate = i;
                    count = 1;
                }

                if(TEST_MODE_ON) {
                    System.out.println(" candidate = " + candidate+ ", count = " + count);
                }

                if (count >= target) {return 1;}
            }

            if(TEST_MODE_ON) {
                System.out.println("returning: candidate = " + candidate+ ", count = " + count);
            }
            
            return 0;
        }
    }

    static class MajorityElementTests {

        static final void test() {
            existsInSmallArray();
            notExistsInSmallArray();
            existsInMiddleOddArray();
            existsInBottomEvenArray();
            existsInTopEvenArray();
            notExistsInEvenArray();;
            existsInBottomOddArray();
            existsInTopOddArray();
            notExistsInEvenArray();
        }

        static final void existsInSmallArray() {
            System.out.println(">existsInSmallArray");
            final int[] a = {2, 2};
            final int result = MajorityElementService.existsMajorityElement(a);
            if(result != 1) {System.out.println("TEST FAILED!");}
            else { System.out.println("TEST PASSED!");}
            System.out.println("<existsInSmallArray");
        }

        static final void notExistsInSmallArray() {
            System.out.println(">notExistsInSmallArray");
            final int[] a = {1, 2};
            final int result = MajorityElementService.existsMajorityElement(a);
            if(result != 0) {System.out.println("TEST FAILED!");}
            else { System.out.println("TEST PASSED!");}
            System.out.println("<notExistsInSmallArray");
        }

        static final void existsInMiddleOddArray() {
            System.out.println(">existsInMiddleOddArray");
            final int[] a = {1, 2, 2, 2, 3};
            final int result = MajorityElementService.existsMajorityElement(a);
            if(result != 1) {System.out.println("TEST FAILED!");}
            else { System.out.println("TEST PASSED!");}
            System.out.println("<existsInMiddleOddArray");
        }

        static final void existsInBottomEvenArray() {
            System.out.println(">existsInBottomEvenArray");
            final int[] a = {0, 0, 1, 4, 0, 0};
            final int result = MajorityElementService.existsMajorityElement(a);
            if(result != 1) {System.out.println("TEST FAILED!");}
            else { System.out.println("TEST PASSED!");}
            System.out.println("<existsInBottomEvenArray");
        }

        static final void existsInTopEvenArray() {
            System.out.println(">existsInTopEvenArray");
            final int[] a = {5, 5, 1, 5, 5, 1};
            //{1, 1, 5, 5, 5, 5}
            final int result = MajorityElementService.existsMajorityElement(a);
            if(result != 1) {System.out.println("TEST FAILED!");}
            else { System.out.println("TEST PASSED!");}
            System.out.println("<existsInTopEvenArray");
        }

        static final void notExistsInEvenArray() {
            System.out.println(">notExistsInEvenArray");
            final int[] a = { 512766168, 717383758, 5, 126144732, 5, 573799007, 5, 5, 5, 405079772};
            final int result = MajorityElementService.existsMajorityElement(a);
            if(result != 0) {System.out.println("TEST FAILED!");}
            else { System.out.println("TEST PASSED!");}
            System.out.println("<notExistsInEvenArray");
        }

        static final void existsInBottomOddArray() {
            System.out.println(">existsInBottomOddArray");
            int[] a = {0, 0, 0, 4, 0, 1, 0};
            int result = MajorityElementService.existsMajorityElement(a);
            if(result != 1) {System.out.println("TEST FAILED!");}
            else { System.out.println("TEST PASSED!");}

            int[] b = {2, 3, 9, 2, 2};
            result = MajorityElementService.existsMajorityElement(b);
            if(result != 1) {System.out.println("TEST FAILED!");}
            else { System.out.println("TEST PASSED!");}

            System.out.println("<existsInBottomOddArray");
        }

        static final void existsInTopOddArray() {
            System.out.println(">existsInTopOddArray");
            final int[] a = {5, 5, 5, 4, 5, 1, 5};
            final int result = MajorityElementService.existsMajorityElement(a);
            if(result != 1) {System.out.println("TEST FAILED!");}
            else { System.out.println("TEST PASSED!");}
            System.out.println("<existsInTopOddArray");
        }

        static final void notExistsInOddArray() {
            System.out.println(">notExistsInOddArray");
            final int[] a = {5, 2, 1, 5, 0, 1, 5};
            final int result = MajorityElementService.existsMajorityElement(a);
            if(result != 0) {System.out.println("TEST FAILED!");}
            else { System.out.println("TEST PASSED!");}
            System.out.println("<notExistsInOddArray");
        }

    }
    
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
    
    public static void main(String[] args) {
        if(TEST_MODE_ON) {
            MajorityElementTests.test();
        } else {
            // 1 Ordenar Lista
            // 2 Partir ao meio
            FastScanner scanner = new FastScanner(System.in);
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(MajorityElementService.existsMajorityElement(a));
        }
        
    }
}