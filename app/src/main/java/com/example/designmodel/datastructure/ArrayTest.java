package com.example.designmodel.datastructure;

/**
 * Created by hp on 2020/4/13.
 */
public class ArrayTest {
    public static void main(String[] args) {
        Array array = new Array(10);
//        System.out.println("query=" + array.query(2));
//        if (array.update(1, 100)) {
//            System.out.println("update=" + array.array[1]);
//        }
        array.output();
        array.insert(0, 9);
        System.out.println("====================");
        array.output();
    }

    public static class Array {
        public int[] array;
        public int size;

        public Array(int capacity) {
            if (capacity < 0) {
                throwOutOfBoundsException();
            }
            this.array = new int[capacity];
            size = 0;
        }

        public int query(int index) {
            if (index < 0 || index > size - 1) {
                throwOutOfBoundsException();
            }
            return array[index];
        }

        public boolean update(int index, int value) {
            if (index < 0 || index > size - 1) {
                throwOutOfBoundsException();
            }
            array[index] = value;
            return true;
        }

        public void insert(int index, int value) {
            if (index < 0 || index > size) {
                throwOutOfBoundsException();
            }
            for (int i = size - 1; i >= index; i--) {
                array[i + 1] = array[i];
            }
            array[index] = value;
            size++;
        }

        public void delete(int index) {

        }

        public void output() {
            for (int i = 0; i < size; i++) {
                System.out.println(array[i]);
            }
        }

        private void throwOutOfBoundsException() {
            throw new IndexOutOfBoundsException();
        }
    }
}
