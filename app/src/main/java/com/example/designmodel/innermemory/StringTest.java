package com.example.designmodel.innermemory;

/**
 * s1 == s2：这将比较s1和s2的引用地址。尽管它们包含相同的字符串内容，但它们是不同的对象，因为s2使用new String()构造函数创建。因此，这个比较返回false。
 * s1 == s5：这将比较s1和s5的引用地址。虽然s5是通过字符串字面量拼接而成，但编译器会在编译时执行这个拼接操作，因此s5被优化为一个常量，与s1引用的对象相同。因此，这个比较返回true。
 * s1 == s6：这将比较s1和s6的引用地址。在这种情况下，s6是通过字符串变量s3和s4的拼接而成的，这会在运行时进行。这会创建一个新的字符串对象，因此s1和s6引用的是不同的对象，所以这个比较返回false。
 * s1 == s6.intern()：这将比较s1和s6.intern()的引用地址。intern()
 * 方法会在字符串常量池中查找字符串对象，并返回它的引用（如果已存在），或者在池中添加该字符串并返回新的引用（如果不存在）。在这种情况下，由于字符串"programming"已经存在于常量池中（因为s1引用的对象就是它），所以s6
 * .intern()返回的是常量池中的引用。因此，这个比较返回true。
 * s2 == s2.intern()：这将比较s2和s2.intern()的引用地址。由于s2是通过new String()构造函数创建的，它不会自动添加到常量池中。因此，调用s2.intern()
 * 会将s2的引用添加到常量池中，并返回常量池中的引用。由于s2和常量池中的引用不同，所以这个比较返回false。
 * 总结一下，字符串常量池是Java中用于存储字符串的特殊区域。字符串字面量（如s1中的"programming"）会自动存储在常量池中，并且对相同的字符串字面量进行的引用比较会返回true。使用new String()
 * 构造函数创建的字符串对象不会自动添加到常量池中，而是在堆内存中创建，因此其引用与常量池中的引用不同。通过调用intern()方法可以将字符串对象添加到常量池中，如果常量池中已经存在相同内容的字符串，则返回常量池中的引用。
 *
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
    //5.对象和值的比较
}
