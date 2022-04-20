package com.example.algor;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class AlgorApplication {
    public static void main(String[] args) {
        final StringListImpl stringList = new StringListImpl();

        // stringList.add("мандарин");
        //stringList.add(2,"курица");

        //stringList.set(0,"дерево");
        // stringList.remove(5);
        //System.out.println(stringList.contains("корова"));

        // System.out.println(stringList.lastIndexOf("курица"));

        // System.out.println(stringList.get(5));

        // System.out.println(stringList.size());

        // System.out.println(stringList.isEmpty());

        var copyOfArray = stringList.toArray();

        System.out.println(Arrays.toString(stringList.getArray()));
        System.out.println(Arrays.toString(copyOfArray));

        stringList.clear();


        System.out.println(Arrays.toString(stringList.getArray()));
        System.out.println(Arrays.toString(copyOfArray));


        //stringList.clear();

        //stringList.toArray();
        // System.out.println(Arrays.toString(stringList.getArray()));
    }
}



