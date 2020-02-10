package com.example.designmodel.analysic;

/**
 * Created by hp on 2020/1/20.
 */
public class RecursionTest {
    public static void main(String[] args) {
        long currentTime1 = System.currentTimeMillis();
        long sum = cyclic(40);//max 92
        System.out.println("循环计算：" + sum);
        System.out.println("调用次数：" + count_cyclic);
        long currentTime2 = System.currentTimeMillis();
        long result = currentTime2 - currentTime1;
        System.out.println("Cycle result time=" + result);
        long sum2 = feiBo(40);
        System.out.println("递归计算：" + sum2);
        System.out.println("调用次数：" + count);
        long currentTime3 = System.currentTimeMillis();
        long result2 = currentTime3 - currentTime2;
        System.out.println("feiBo result time=" + result2);
        long result3 = whileTest(40);
        System.out.println("result3=" + result3);
    }

    private static int count, count_cyclic;

    private static long feiBo(int n) {
        count++;
        //n=40 380ms n=50 41696ms
//        if (n > 1)
//            return feiBo(n - 1) + feiBo(n - 2);
//        return n;

        //n=40 270ms 减少一个方法调用 165580141次调用
//        if (n > 1) {
//            long result = 1;
//            do {
//                result += feiBo(n - 2);
//                n--;
//            } while (n > 1);
//            return result;
//        }
//        return n;
        //or
        if (n > 1) {
            int sum = 1;//sum 从n=10-2
            while (n > 1) {
                sum += feiBo(n - 2);
                n--;
            }
            return sum;
        }
        return n;

    }

    private static long whileTest(int n) {
        int sum = 0;
        if (n > 1) {
            int a, b;
            while (n > 0) {
                n--;
                a = n;
                b = n - 1;
                sum += (a + b);
            }
        }
        return sum;
    }

    private static long cyclic(int n) {
        //n=40 or n=50ms
        if (n > 1) {
            long a, b = 1;
            n--;
            a = n & 1;
            n /= 2;
            while (n-- > 0) {
                count_cyclic++;
                a += b;
                b += a;
            }
            return b;
        }
        return n;
    }
}
