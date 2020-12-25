package com.example.designmodel.pattern.structure.flyWeightPattern;

import java.math.BigDecimal;

/**
 * 享元模式的主要目的是实现对象的共享，即共享池，当系统中对象多的时候可以减少内存的开销，通常与工厂模式一起使用
 * String类型就是使用了享元模式。String对象是final类型，对象一旦创建就不可改变。在JAVA中字符串常量都是存在常量池中的，
 * JAVA会确保一个字符串常量在常量池中只有一个拷贝。String a="abc"，其中"abc"就是一个字符串常量享元模式采用一个共享来避免大量拥有相同内容对象的开销。
 * 这种开销最常见、最直观的就是内存的损耗。享元对象能做到共享的关键是区分内蕴状态(Internal State)和外蕴状态(External State)。
 * 　　一个内蕴状态是存储在享元对象内部的，并且是不会随环境的改变而有所不同。因此，一个享元可以具有内蕴状态并可以共享。
 * 　　一个外蕴状态是随环境的改变而改变的、不可以共享的。享元对象的外蕴状态必须由客户端保存，并在享元对象被创建之后，在需要使用的时候再传入到享元对象内部。
 *    外蕴状态不可以影响享元对象的内蕴状态，它们是相互独立的，享元模式可以分成单纯享元模式和复合享元模式两种形式。
 *
 * Created by hp on 2020/3/13.
 */
public class TestMain {

    public static void main(String[] args) {//1.99499999999999999999
        //最大误差：0.004999999999/2=0.2499%=0.25%=0.3%
        long original = 2142114938;
        double result = divide(multiply(2142114938.879999d,100), multiply(multiply(multiply(2, 1024L), 1024L), 1024L));
        System.out.println("Big======"+result);
        System.out.println("Normal========" + ((2142114938.879999d) / (2L * (1024L * 1024L * 1024L))));
        String result1 = String.format("%.1f",result);
        System.out.println("String=========" + result1);
        BigDecimal b = new BigDecimal((2142114938.879999d*100.0f) / (2L*(1024L*1024L*1024L)));
        //BigDecimal b=new BigDecimal(Double.valueOf(result));
        double localProgress = b.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println("origin=" + localProgress);

    }
    public static double divide(double divisor, double dividend) {
        BigDecimal divisor_res = new BigDecimal(Double.valueOf(divisor));
        BigDecimal dividend_res = new BigDecimal(Double.valueOf(dividend));
        return divisor_res.divide(dividend_res).doubleValue();
    }
    public static double multiply(double multiValue, double factor) {
        BigDecimal multiValue_res = new BigDecimal(Double.valueOf(multiValue));
        BigDecimal factor_res = new BigDecimal(Double.valueOf(factor));
        return multiValue_res.multiply(factor_res).doubleValue();
    }
}
