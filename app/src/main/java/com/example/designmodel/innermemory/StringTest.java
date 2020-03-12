package com.example.designmodel.innermemory;

/**
 * Created by hp on 2020/3/12.
 */
public class StringTest {
    public static void main(String[] args) {
        String s1 = "programming";
        String s2 = new String("programming");
        String s3 = "program";
        String s4 = "ming";
        String s5 = "program" + "ming";
        String s6 = s3 + s4;
        System.out.println(s1 == s2);//false
        System.out.println(s1 == s5);//true
        System.out.println(s1 == s6);//false
        System.out.println(s1 == s6.intern());//true
        System.out.println(s2 == s2.intern());//false
    }
    //== and equal 四种情况
    // 1、对于基本类型：只能用 == 比较的是值，
    // 2、包装类型：==内存地址，equal是值
    // 3、对象 都是内存地址，即是否为同一个对象，因为equals没有被重写，没有被重写的都是object的equals
    // 4、特殊对象：String ==比较的地址，equal比较的值 对于equals 只不过 String的equals已重写，实际上是比较的值，而不是内存地址

    // toString hasCode 区别和联系

    //1.false s1在常量池中 s2在堆内存中创建了个对象
    //2.true + and append
    //+相当于 创建stringBuilder对象然后执行append的操作，所以+更耗性能 拼接后的对象用toString处理，处理后的字符串放到常量池中，有就直接引用没有就创建 so 2 true
    //3.类加载时初始化问题，s3,34的结果无法在编译时确定，如果final 则true，但是在运行时才知道，所以为false
    //4.
}
