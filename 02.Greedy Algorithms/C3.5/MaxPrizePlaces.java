import java.util.ArrayList;
import java.util.Scanner;

public class MaxPrizePlaces {


    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int candies = scanner.nextInt();

        // Greedy choice: the first person receives 1 candy if there are > 2 candies
        // available otherwise it gets the full prize.

        final ArrayList<Integer> prizes = new ArrayList<Integer>();
        int lastPrize = 0;
        int prize = 0;
        while(candies > 0) {
            prize = lastPrize + 1;
            lastPrize = prize;
            candies -= prize;
            if(candies <= prize) {
                prize += candies;
                candies = 0;
            }
            prizes.add(prize);
        }
        System.out.println(prizes.size());
        for(int i : prizes) {
            System.out.print(""+ i +" ");
        }
    }
}