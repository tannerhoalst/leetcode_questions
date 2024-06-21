package Hashmap;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
        public boolean isHappy(int n) {
        Set<Integer> seenNumbers = new HashSet<>();
        
        while (n != 1 && !seenNumbers.contains(n)) {
            seenNumbers.add(n);
            n = getSumOfSquares(n);
        }
        
        return n == 1;
    }

    private int getSumOfSquares(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        HappyNumber hn = new HappyNumber();
        int n = 19; 
        boolean result = hn.isHappy(n);
        System.out.println("Is " + n + " a happy number? " + result);
    }
}
