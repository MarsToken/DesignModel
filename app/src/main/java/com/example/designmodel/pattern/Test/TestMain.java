package com.example.designmodel.pattern.Test;

import java.io.IOException;

/**
 * Created by hp on 2020/3/12.
 */
public class TestMain {
    public static void main(String[] args) {
        ProtoType protoType = new ProtoType();
        protoType.setString("123");
        protoType.setObject(new ProtoType.SerializableObject());
        System.out.println(protoType.toString());
        try {
            ProtoType protoType_low = (ProtoType) protoType.clone();
            System.out.println(protoType_low.toString());
            ProtoType protoType_high = protoType.deepClone();
            System.out.println(protoType_high.toString());
            System.out.println(protoType.getString() == protoType_low.getString());
            System.out.println(protoType.getString() == protoType_high.getString());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
