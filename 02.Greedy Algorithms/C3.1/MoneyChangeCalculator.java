import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Class that implements the greedychoice to reduce the number of coins
 * necessary to change a value.
 * 
 * The greedy choice is: select the highest value currency first and change
 * the maximum ammount first.
 * 
 * This choice is easily prooved since it is not possible to reduce the ammount 
 * of coins necessary with a lower value coin.
 */
public class MoneyChangeCalculator {

    private static int[] CHANGE;

    static {
        CHANGE = new int[3];
        CHANGE[0] = 10;
        CHANGE[1] = 5;
        CHANGE[2] = 1;
    }

    public static void main(String[] args) {
        final Scanner s = new Scanner(System.in);
        final long value = s.nextLong();
        s.close();

        long valueLeft = value;
        long totalCoins = 0;
        long coins = 0;
        
        for(int c : CHANGE) {

            if(valueLeft == 0) {
                break;
            }
            coins = valueLeft / c;
            totalCoins += coins;
            valueLeft -= coins * c;
            System.out.println(String.format("c = %d, coins = %d, totalCoins = %d, valueLeft = %d", c, coins, totalCoins, valueLeft));
        }

        System.out.println(totalCoins);
    }
}