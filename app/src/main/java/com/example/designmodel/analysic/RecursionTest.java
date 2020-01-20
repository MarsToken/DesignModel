package com.example.designmodel.analysic;

/**
 * Created by hp on 2020/1/20.
 */
public class RecursionTest {
    public static void main(String[] args) {
        long currentTime1 = System.currentTimeMillis();
        long sum = cyclic(50);//max 92
        System.out.println("\n" + sum);
        long currentTime2 = System.currentTimeMillis();
        long result = currentTime2 - currentTime1;
        System.out.println("Cycle result=" + result);
        long sum2 = feiBo(50);
        System.out.println("\n" + sum2);
        long currentTime3 = System.currentTimeMillis();
        long result2 = currentTime3 - currentTime2;
        System.out.println("feiBo result=" + result2);
    }

    private static long feiBo(int n) {
        //n=40 300ms n=50 41696ms
        if (n > 1)
            return feiBo(n - 1) + feiBo(n - 2);
        return n;
    }

    private static long cyclic(int n) {
        //n=40 or n=50ms
        if (n > 1) {
            long a, b = 1;
            n--;
            a = n & 1;
            n /= 2;
            while (n-- > 0) {
                a += b;
                b += a;
            }
            return b;
        }
        return n;
    }
}
