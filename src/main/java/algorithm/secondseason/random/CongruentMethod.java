package algorithm.secondseason.random;

import java.util.Random;

public class CongruentMethod {

    public static void main(String[] args) {
        Random random = new Random(0);
        random.nextInt();
        
        int seed = 0;
        int previous = seed;
        for (int i = 0; i < 1000; ++i) {
            int current = next(previous);
            System.out.printf("%d %d\n", previous, current);
            previous = current;
        }
    }
    
    // #cycle = 1
//    private static final int multiplicand = 0x12345678;
//    private static final int addend = 0x23456789;

    private static final int MULTIPLICAND = 3;
    private static final int ADDEND = 4;
    
    public static int next(int seed) {
        // int cast って mod 2**32?
        return (int) ((long) seed * MULTIPLICAND + ADDEND);
    }
}
