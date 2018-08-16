import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class MaximizeLoot {

    static class KnapSack {
        private long capacity; // W
        private long availableCapacity; // w - sum(wi)
        private ArrayList<Item> items;

        public KnapSack(final long capacity) {
            this.capacity = capacity;
            this.availableCapacity = capacity;
            items = new ArrayList<Item>();
        }

        public void addItem(final Item i) {
            this.items.add(i);
            this.availableCapacity -= i.getWeight();
        }

        public double getTotalValue() {
            double total = 0;
            for(Item i : this.items) {
                total += i.getValue();
            }
            return total;
        }

        public long getAvailableCapacity() {
            return this.availableCapacity;
        }

    }

    static class Item implements Comparable {

        double value;
        long weight;

        public Item(final double value, final long weight) {
            this.value = value;
            this.weight = weight;
        }

        public double getValuePerUnit() {
            return value / (double) weight;
        }

        public double getValue() {
            return value;
        }

        public long getWeight() {
            return weight;
        }

        /**
         * 
         */
        public int compareTo(Object i ) {
            if(this.getValuePerUnit() > ((Item)i).getValuePerUnit()) {
                return 1;
            } else if (this.getValuePerUnit() < ((Item)i).getValuePerUnit()) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    static class KnapSackService {
        static final void fillKnapSack(final Item[] items, final KnapSack k) {
            Arrays.sort(items, Collections.reverseOrder());
            long lootedAmmount = 0;
            for(Item i: items) {
                if(k.getAvailableCapacity() == 0) {
                    break;
                }

                //System.out.println(String.format("item has %d available at %f per unit.", i.getWeight(), i.getValuePerUnit()));
                lootedAmmount =  (k.getAvailableCapacity() > i.getWeight()) ? i.getWeight() : k.getAvailableCapacity();
                k.addItem(new Item(i.getValuePerUnit() * lootedAmmount, lootedAmmount));
                //System.out.println(String.format("added ammount %d with total value of %f", lootedAmmount, i.getValue()));
            }
        }
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        final int capacity = scanner.nextInt();
        final Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Item(scanner.nextDouble(), scanner.nextLong());
        }
        scanner.close();

        final KnapSack k = new KnapSack(capacity);
        KnapSackService.fillKnapSack(items, k);
        System.out.println(k.getTotalValue());
    }
}