package com.codecool.javabst;

import java.util.List;

// https://www.journaldev.com/23086/binary-search-tree-bst-search-insert-remove#bst-removing-element-recursively
//https://www.geeksforgeeks.org/binary-search-tree-set-2-delete/

// Skeleton for the Binary search tree. Feel free to modify this class.
public class BinarySearchTree {
    Node root;

    BinarySearchTree() {
        root = null;
    }

    public void build(List<Integer> elements) {
        root = rootConstructor(elements, 0, elements.size() -1);
    }

    private Node rootConstructor(List<Integer> elements, int startIndex, int endIndex) {
        if(startIndex > endIndex) {
            return null;
        }

        //get the index of the middle element
        int middleValue = (startIndex + endIndex) / 2;

        //define the root in the list = the middle element of the list
        Node rootNode = new Node(elements.get(middleValue));

        //define the left child
        rootNode.left = rootConstructor(elements, startIndex, middleValue - 1);

        //define the right child
        rootNode.right = rootConstructor(elements, middleValue + 1, endIndex);

        //return the list element as Node
        return rootNode;
    }

    public boolean search(Integer toFind) {
        Node currentNode = root;

        while(currentNode != null){
            //if find the Node, return the Node
            if(currentNode.value == toFind) {
                return true;
                //continue the search on the left side, if the searched value smaller than the value of the examined, current Node
            }else if(currentNode.value > toFind) {
                currentNode = currentNode.left;
                //continue the search on the right side, if the searched value bigger than the value of the examined, current Node
            }else{
                currentNode = currentNode.right;
            }
        }

        //return false, if there is no such element in the tree
        return false;

    }

    public void add(Integer toAdd) {
        root = addNode(root, toAdd);
    }

    private Node addNode(Node root, Integer toAdd) {
        //during recursion, this method will invoke with the left or right child of the current root
        //it the child does not exist, a new node will be inserted
        // the recursion will stop when a new node will be created
        if (root == null) {
            System.out.println("no root, added value: " + toAdd );
            root = new Node(toAdd);
            return root;
        }

        //Compare the added value to the value of the current root
        //it it is smaller
        if(toAdd < root.value) {
            //continue to examine the left edge (while it is not null)
            root.left = addNode(root.left, toAdd);
            //if the added value is bigger, continue to examine the right edge (while it is null)
        } else if(toAdd > root.value) {
            root.right = addNode(root.right, toAdd);
        }

        return root;
    }


    public void remove(Integer toRemove) {
        //replace the deleted root with a new root (one of its children)
        root = deleteRec(root, toRemove);
    }

    private Node deleteRec(Node root, Integer toRemove) {
        if (root == null)  return root;

        //recur down the tree and examine the left and right childs and pass them as argument to this method
        if (toRemove < root.value) {
            root.left = deleteRec(root.left, toRemove);
        } else if (toRemove > root.value) {
            root.right = deleteRec(root.right, toRemove);
        }
        //if the node is found
        else {
            //"save" right child
            if (root.left == null)
                return root.right;
            // "save" left child
            else if (root.right == null)
                return root.left;

            //reorder the tree if there is two children
            root.value = minValue(root.right);

            root.right = deleteRec(root.right, root.value);
        }

        return root;
    }

    int minValue(Node root)
    {
        int minv = root.value;
        while (root.left != null)
        {
            minv = root.left.value;
            root = root.left;
        }
        return minv;
    }

    public void printNodes(Node node) {
        if(node == null) {
            return;
        }

        System.out.println(node.value + " ");
        printNodes(node.left);
        printNodes(node.right);
    }

}
