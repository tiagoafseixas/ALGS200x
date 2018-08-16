import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import javax.swing.text.Segment;

public class CollectSignatures {

    static class Segment implements Comparable {
        private long a;
        private long b;

        public Segment(final long a, final long b) {
            this.a = a;
            this.b = b;
        }

        public long getA() {
            return this.a;
        }

        public long getB() {
            return this.b;
        }

        public long getDistance() {
            return this.b - this.a;
        }

        public int compareTo(Object o) {
            if (this.getB() > ( (Segment) o).getB()) {
                return 1;
            } else if (this.getB() < ( (Segment) o).getB()) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        final Scanner s = new Scanner(System.in);
        final int nrSegments = s.nextInt();
        final Segment[] segments = new Segment[nrSegments];

        for(int i = 0; i < nrSegments; i++) {
            segments[i] = new Segment(s.nextLong(), s.nextLong());
        }

        Arrays.sort(segments);
        final ArrayList<Long> points = new ArrayList<Long>();
        long point = segments[0].getB(); 
        points.add(point);
        //System.out.println(String.format("first point is %d", point));
        for(Segment seg : segments) {
            //System.out.println(String.format("Segment a : %d, b: %d", seg.getA(), seg.getB()));
            if(seg.getA() > point || seg.getB() < point) {
                point = seg.getB();
                points.add(point);
                //System.out.println(String.format("added point is %d", point));
            }
        }

        System.out.println(points.size());
        for(long i : points) {
            System.out.print(String.format("%d ", i));
        }
    }

}