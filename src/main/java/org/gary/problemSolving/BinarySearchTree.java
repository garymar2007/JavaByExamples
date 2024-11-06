package org.gary.problemSolving;

import java.util.LinkedList;

public class BinarySearchTree {
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public Node root;
    public static boolean flag = false;
    public BinarySearchTree() {
        this.root = null;
    }
    public BinarySearchTree(int value) {
        this.root = new Node(value);
        this.root.left = null;
        this.root.right = null;
    }

    //To calculate the factorial of a given number
    public int factorial(int num) {
        if (num == 0 || num == 1) {
            return 1;
        } else {
            return num * factorial(num - 1);
        }
    }

    public void searchNode(Node temp, int value) {
        if(temp == null) {
            System.out.println("Tree is empty");
        } else {
            if(temp.data == value) {
                flag = true;
                return;
            }

            if(!flag && temp.data > value && temp.left != null) {
                searchNode(temp.left, value);
            } else if(!flag && temp.right != null) {
                searchNode(temp.right, value);
            }
        }
    }

    public void insert(Node node, int value) {
        if(value < node.data) {
            if(node.left != null) {
                insert(node.left, value);
            } else {
                node.left = new Node(value);
            }
        } else if(value > node.data) {
            if(node.right != null) {
                insert(node.right, value);
            } else {
                node.right = new Node(value);
            }
        }
    }

    public static void main(String args[]) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.root = new Node(11);
        bst.insert(bst.root, 8);
        bst.insert(bst.root, 12);
        bst.insert(bst.root, 78);
        bst.insert(bst.root, 23);
        bst.insert(bst.root, 36);

        printBinaryTree(bst.root);

        bst.searchNode(bst.root, 23);

        if(flag)
            System.out.println("Element is present in the binary tree.");
        else
            System.out.println("Element is not present in the binary tree.");
    }

    public static int heightOfTree(Node root) {
        if(root == null) {
            return 0;
        }
        return 1 + Math.max(heightOfTree(root.left), heightOfTree(root.right));
    }

    public static void printSpace(double n, Node removed) {
        for (; n > 0; n--) {
            System.out.print("\t");
        }
        if (removed == null) {
            System.out.print(" ");
        }
        else {
            System.out.print(removed.data);
        }
    }

    public static void printBinaryTree(Node root) {
        LinkedList<Node> treeLevel = new LinkedList<>();
        treeLevel.add(root);
        LinkedList<Node> temp = new LinkedList<>();
        int counter = 0;
        int height = heightOfTree(root) -1;
        double numberOfElements
                = (Math.pow(2, (height + 1)) - 1);
        // System.out.println(numberOfElements);
        while (counter <= height) {
            Node removed = treeLevel.removeFirst();
            if (temp.isEmpty()) {
                printSpace(numberOfElements
                                / Math.pow(2, counter + 1),
                        removed);
            }
            else {
                printSpace(numberOfElements
                                / Math.pow(2, counter),
                        removed);
            }
            if (removed == null) {
                temp.add(null);
                temp.add(null);
            }
            else {
                temp.add(removed.left);
                temp.add(removed.right);
            }

            if (treeLevel.isEmpty()) {
                System.out.println("");
                System.out.println("");
                treeLevel = temp;
                temp = new LinkedList<>();
                counter++;
            }
        }
    }
}
