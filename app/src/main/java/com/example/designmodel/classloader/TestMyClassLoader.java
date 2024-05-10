package com.example.designmodel.classloader;

/**
 * Created by hp on 2020/5/27.
 */

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import dalvik.system.PathClassLoader;

/**
 * // First, check if the class has already been loaded
 * Class<?> c = findLoadedClass(name);
 * if (c == null) {
 * try {
 * if (parent != null) {
 * c = parent.loadClass(name, false);
 * } else {
 * c = findBootstrapClassOrNull(name);
 * }
 * } catch (ClassNotFoundException e) {
 * // ClassNotFoundException thrown if class not found
 * // from the non-null parent class loader
 * }
 * <p>
 * if (c == null) {
 * // If still not found, then invoke findClass in order
 * // to find the class.
 * c = findClass(name);
 * }
 * }
 * <p>
 * 1.双亲委派，亲是关联关系，非继承
 * 2.双亲委派，优先加载缓存，其次采用父类的！
 * 3.系统类加载器也是应用类加载器，加载classpath指定的类，我们的代码
 * 根类加载器加载核心类，拓展类加载器加载utils等
 */
public class TestMyClassLoader {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
        IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException,
        InvocationTargetException {
        //自定义类加载器的加载路径,null才能用自己的！否则会通过appClassLoader找
        MyClassLoader myClassLoader = new MyClassLoader(null,
            "C:\\Users\\Administrator\\AndroidStudioProjects\\DesignModel\\app\\build\\intermediates\\javac\\debug" +
                "\\classes");
        System.out.println("step1:" + myClassLoader);
        System.out.println("step2:" + myClassLoader.getParent());
        System.out.println("step3:" + myClassLoader.getParent().getParent());
        System.out.println("step4:" + myClassLoader.getParent().getParent().getParent());
        //包名+类名
        Class c = myClassLoader.loadClass("com.example.designmodel.classloader.bean.MyClass");

        if (c != null) {
            Object obj = c.newInstance();
            System.out.println(obj.getClass().getClassLoader());
            Method method = c.getMethod("say", null);
            method.invoke(obj, null);
            System.out.println(c.getClassLoader().toString());
        }

    }
}
