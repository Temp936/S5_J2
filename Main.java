package com.company;
import java.util.Scanner;
import java.util.ArrayList;


public class Main {
    public static void function(String str){ //задание 2
        str = str.trim();
        String[] words = str.split(" ");

        ArrayList<String> text = new ArrayList<String>();
        for(int i = 0; i < words.length; i++) text.add(words[i]);

        ArrayList<Integer> counts = new ArrayList<Integer>();

        for(int i = 0; i< text.size(); i++){
            if(i!= text.lastIndexOf(text.get(i))) {

                if(counts.size() == i) counts.add(1);

                text.remove(text.lastIndexOf(text.get(i)));

                counts.set(i, counts.get(i)+1);
                i--;
            }
            else counts.add(1);
        }
        for(int i = 0; i < text.size(); i++){
            System.out.print(text.get(i) + ":" + counts.get(i) + " ");
        }
        System.out.println();
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
