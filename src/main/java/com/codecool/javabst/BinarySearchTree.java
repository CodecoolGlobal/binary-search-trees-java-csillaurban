package com.codecool.javabst;

import java.util.List;

// Skeleton for the Binary search tree. Feel free to modify this class.
public class BinarySearchTree {
    private static Node root;

    public BinarySearchTree() {
    }

    public BinarySearchTree(Node root) {
        this.root = root;
    }

    public static BinarySearchTree build(List<Integer> elements) {
        int length = elements.size();

        Node constructedRoot = rootConstructor(elements, 0, length -1);
        printNodes(constructedRoot);

        BinarySearchTree tree = new BinarySearchTree(constructedRoot);
        return tree;
    }

    private static Node rootConstructor(List<Integer> elements, int startIndex, int endIndex) {
        if(startIndex > endIndex) {
            return null;
        }

        //get the index of the middle element
        int middleValue = (startIndex + endIndex) / 2;

        //define the root = the middle element of the list
        Node root = new Node(elements.get(middleValue));

        //define the left child
        root.left = rootConstructor(elements, startIndex, middleValue - 1);

        //define the right child
        root.right = rootConstructor(elements, middleValue + 1, endIndex);

        return root;
    }

    public boolean search(Integer toFind) {
        // TODO return true if the element has been found, false if its not in the tree.
        return false;
    }

    public void add(Integer toAdd) {
        // TODO adds an element. Throws an error if it exist.
    }

    public void remove(Integer toRemove) {
        // TODO removes an element. Throws an error if its not on the tree.
    }

    public static void printNodes(Node node) {
        if(node == null) {
            return;
        }

        System.out.println(node.value + " ");
        printNodes(node.getLeft());
        printNodes(node.getRight());
    }

}
