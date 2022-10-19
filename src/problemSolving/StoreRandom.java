package problemSolving;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class StoreRandom {
    public static final int THRESHOLD = 1000000;
    public static final int NUM_OF_BUCKET = 2000;
    public static HashMap<String, BinarySearchTree> storage = new HashMap<>();

    public static void loadData() throws Exception{
        int counter = THRESHOLD;
        while(counter > 0) {
            int num = (int)(Math.random() * THRESHOLD + 1);
            //String key = HashCreator.createMD5Hash("" + num);
            String key = String.valueOf(num % NUM_OF_BUCKET + 1);
            if(storage.isEmpty() || storage.get(key) == null){
                BinarySearchTree node = new BinarySearchTree(num);
                storage.put(key, node);
            } else if(storage.get(key) != null) {
                BinarySearchTree aTree = storage.get(key);
                aTree.insert(aTree.root, num);
            }

            counter--;
        }
    }

    public static void insertInto(int num) {
        String key = String.valueOf(num % NUM_OF_BUCKET + 1);
        if(storage.get(key) != null) {
            BinarySearchTree tree = storage.get(key);
            tree.insert(tree.root, num);
        } else {
            BinarySearchTree tree = new BinarySearchTree(num);
            storage.put(key, tree);
        }
    }

    public static boolean find(int number) {
        String key = String.valueOf(number % NUM_OF_BUCKET + 1);
        if(storage.get(key) != null) {
            BinarySearchTree tree = storage.get(key);
            tree.searchNode(tree.root, number);
            return tree.flag;
        } else {
            return false;
        }
    }
    public static void print() {
        for(Map.Entry<String, BinarySearchTree> es : storage.entrySet()) {
            System.out.println("===========Key:" + es.getKey());
            BinarySearchTree.printBinaryTree(es.getValue().root);
        }
    }

    public static void main(String args[]) throws Exception{
        loadData();
        //print();
        Scanner sc = new Scanner(System.in);
        String ans = null;

        do {
            System.out.println("Please input a number you are looking for: ");
            int input = Integer.parseInt(sc.nextLine());
            boolean found = find(input);

            if(found) {
                System.out.println("OK! The number you have inputted is found in our storage!");
            } else {
                System.out.println("NOT FOUND! The number you have inputted is not found in pur storage!");
                insertInto(input);
                System.out.println("The number has been stored!");
            }
            System.out.println("Do you want to quit?[Y/n]:");
            ans = sc.nextLine();
        }while(ans != null && ans.equalsIgnoreCase("N"));

    }
}
