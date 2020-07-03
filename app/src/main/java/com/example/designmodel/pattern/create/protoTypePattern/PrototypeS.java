package com.example.designmodel.pattern.create.protoTypePattern;

import java.io.Serializable;

/**
 * Created by hp on 2020/6/28.
 */
public class PrototypeS implements Cloneable{
    private static final long serialVersionUID = 1L;
    private String string;
    private int intValue;
    private SerializableObject serializableObject;

    /**
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected PrototypeS clone() throws CloneNotSupportedException {
        PrototypeS prototype = (PrototypeS) super.clone();//object里的
        prototype.serializableObject = prototype.serializableObject.clone();//deep copy
        return prototype;
    }


    public String getString() {
        return string == null ? "" : string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public int getIntValue() {
        return intValue;
    }
    public void setIntValue(int value){
        intValue = value;
    }
    public SerializableObject getSerializableObject() {
        return serializableObject;
    }

    public void setSerializableObject(SerializableObject serializableObject) {
        this.serializableObject = serializableObject;
    }

    @Override
    public String toString() {
        return "Prototype{" +
                "string='" + string + '\'' +
                ", intValue=" + intValue +
                ", serializableObject=" + serializableObject +
                '}';
    }

    public static class SerializableObject implements Cloneable {
        private static final long serialVersionUID = 1L;

        @Override
        protected SerializableObject clone() throws CloneNotSupportedException {
            return (SerializableObject) super.clone();
        }
    }
}
