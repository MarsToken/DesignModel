package com.example.designmodel.classloader;

/**
 * Created by hp on 2020/5/27.
 */
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader{

    private String classpath;

    /**
     *
     * @param parent 不指定，默认是AppClassLoader，他会默认加载！
     *
     *               默认的类加载器
     *               ClassLoaders$AppClassLoader parent
     *               ClassLoaders$PlatformClassLoader parent.parent
     * @param classpath 要加载的class的环境变量
     */
    public MyClassLoader(ClassLoader parent,String classpath) {
        super(parent);
        this.classpath = classpath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte [] classDate=getDate(name);

            if(classDate==null){}

            else{
                //defineClass方法将字节码转化为类
                return defineClass(name,classDate,0,classDate.length);
            }

        } catch (IOException e) {

            e.printStackTrace();
        }

        return super.findClass(name);
    }
    //返回类的字节码
    private byte[] getDate(String className) throws IOException{
        System.out.println("name is "+className);
        InputStream in = null;
        ByteArrayOutputStream out = null;
        String path=classpath + File.separatorChar +
                className.replace('.',File.separatorChar)+".class";
        try {
            System.out.println("path is " + path);
            in=new FileInputStream(path);
            out=new ByteArrayOutputStream();
            byte[] buffer=new byte[2048];
            int len=0;
            while((len=in.read(buffer))!=-1){
                out.write(buffer,0,len);
            }
            return out.toByteArray();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally{
            in.close();
            out.close();
        }
        return null;
    }

    @Override
    public String toString() {
        return "MyClassLoader{" +
            "classpath='" + classpath + '\'' +
            '}';
    }
}
