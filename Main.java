package com.company;
import java.util.Scanner;

class List { ///Arraylist
    private int size;
    private Object[] arr;

    List() {
        this.arr = new Object[1];
        arr[0] = null;
        this.size = 1;
    }

    List(int size, Object[] arr) {
        this.arr = arr;
        this.size = size;
    }

    void add(Object ob) {
        Object[] temp = new Object[this.size + 1];
        for (int i = 0; i < this.size; i++) temp[i] = this.arr[i];
        temp[this.size] = ob;

        this.size += 1;
        this.arr = temp;
    }
    void add(Object ob, int index) {
        if (index < 0) index = 0;
        if (index > this.size - 1) index = this.size - 1;

        Object[] temp = new Object[this.size + 1];
        for (int i = 0; i < index; i++) temp[i] = this.arr[i];
        temp[index] = ob;
        for (int i = index; i < this.size; i++) temp[i + 1] = this.arr[i];

        this.size += 1;
        this.arr = temp;
    }

    Object get(int index) {
        if (index < 0) index = 0;
        if (index > this.size - 1) index = this.size - 1;

        return this.arr[index];
    }
    Object set(Object ob, int index) {
        if (index < 0) index = 0;
        if (index > this.size - 1) index = this.size - 1;

        Object temp = this.arr[index];
        this.arr[index] = ob;
        return temp;
    }

    boolean contains(Object ob) {
        boolean t = false;
        for (int i = 0; i < this.size; i++)
            if (this.arr[i] == ob) {
                t = true;
                break;
            }
        return t;
    }

    int indexOf(Object ob) {
        int index = -1;
        for (int i = 0; i < this.size; i++) {
           // System.out.println(i + " " + this.arr[i] + " (" + ob);

            if (this.arr[i].equals(ob)) {
                index = i;
                break;
            }
        }

        return index;
    }
    int lastIndexOf(Object ob) {
        int index = -1;
        for (int i = this.size-1; i >= 0; i--) {
            if (this.arr[i].equals(ob)) {
                index = i;
                break;
            }
        }

        return index;
    }

    int size() {
        return this.size;
    }

    boolean is_empty() {
        if (this.size == 0) return true;
        else return false;
    }

    void remove(int index) {
        if (index < 0) index = 0;
        if (index > this.size - 1) index = this.size - 1;
        if (this.size > 0) {
            Object[] temp = new Object[this.size - 1];
            for (int i = 0; i < index; i++) temp[i] = this.arr[i];
            for (int i = index; i < this.size - 1; i++) temp[i] = this.arr[i + 1];

            this.size -= 1;
            this.arr = temp;
        }
    }

}

public class Main {
    public static void function(String str){ //задание 2
        str = str.trim();
        String[] words = str.split(" ");

        List text = new List(words.length, words);

        for(int i = 0; i< text.size(); i++){
            //System.out.println("func " + text.get(i) + " "+ text.indexOf(text.get(i)) + " "  + text.lastIndexOf(text.get(i)) + " " );
            if(i!= text.lastIndexOf(text.get(i))) {

                text.remove(text.lastIndexOf(text.get(i)));
                i--;

            }
        }
        for(int i = 0; i< text.size(); i++){
            System.out.print(text.get(i) + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input a string");
        String str = in.nextLine();
        function(str);
    }
}
