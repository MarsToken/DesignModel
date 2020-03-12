package com.example.designmodel.pattern.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by hp on 2020/3/12.
 */
public class ProtoType implements Cloneable, Serializable {
    private static final long serialVersionUID = 1L;
    private String string;
    private SerializableObject object;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        ProtoType prototype = (ProtoType) super.clone();
        return prototype;
    }

    public ProtoType deepClone() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return (ProtoType) ois.readObject();
    }

    public String getString() {
        return string == null ? "" : string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public SerializableObject getObject() {
        return object;
    }

    public void setObject(SerializableObject object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "ProtoType{" +
                "string='" + string + '\'' +
                ", object=" + object +
                '}';
    }

    public static class SerializableObject implements Serializable {
        private static final long serialVersionUID = 1L;

    }
}
