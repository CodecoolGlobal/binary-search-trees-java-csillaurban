package com.codecool.javabst;

import java.io.IOException;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) throws IOException {

        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 1; i < 8; i++) {
            numbers.add(i);
        }

        numbers.add(55);

        System.out.println(numbers);

        BinarySearchTree myTree = new BinarySearchTree();
        myTree.build(numbers);

        // write some test code here
        System.out.println(myTree.search(7)); // should be true
        System.out.println(myTree.search(55)); // should be true
        System.out.println(myTree.search(34535)); // should be false

        myTree.add(10);
        myTree.add(22);
        myTree.add(132);
        myTree.add(12);
        myTree.add(8);
        System.out.println(myTree.search(10));
        System.out.println(myTree.search(12));
        System.out.println(myTree.search(4));
        myTree.remove(12);
        System.out.println(myTree.search(12));
        System.out.println("done");
    }
}