package problemSolving;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import java.util.*;
import java.util.stream.Collectors;

public class JavaBasicReivew {
    public static void main(String[] args) {
        System.out.println("This is to prepare for Java programming interview....");

        String txt = "Hello Everybody";
        System.out.println("Find the first occurent of letter e of " + txt + ": " + txt.indexOf("e"));

        System.out.println("The size of a String: " + args.length);
        System.out.println("Substring - " + txt.substring(0, txt.length()-1));

        Integer[] intArray = {};
        System.out.println("The size of an array: " + intArray.length);

        //linear search
//        System.out.print("Please input a number:");
//        Scanner sc = new Scanner(System.in);
//        Integer n = sc.nextInt();
        Integer[] list = {3,4,9,45,7,8,2,4,3};
//        for(int i = 0; i < list.length;i++){
//            if(list[i].intValue() == n.intValue()) {
//                System.out.println("Result from linear search: " + i);
//            }
//        }
//        System.out.println("Result from linear search: -1 (Not found)");

        //reverse a string
        System.out.println("Reverse a string: " + reverse("abaa"));

        //Average value (Java 8 lambdas)
        List<Integer> listInt = new ArrayList<Integer>();
        listInt.add(0);
        listInt.add(100);
        listInt.add(20);
        listInt.add(15);
        listInt.add(90);
        listInt.add(23);
        listInt.add(56);
        listInt.add(12);
        System.out.println(listInt.stream().mapToInt(i -> i).average().getAsDouble());
        System.out.println("an element=" + listInt.get(2) + " in size=" + listInt.size());

        List<String> listStr = new ArrayList<String>();
        listStr.add("gary");
        listStr.add("carol");
        listStr.add("nathan");
        listStr.add("jerry");
        listStr.add("crystal");
        listStr.add("kevin");
        listStr.add("wyan");
        listStr.add("lin");
        System.out.println(listStr.stream().map(String::toUpperCase).collect(Collectors.toList()));

        //Number of Tree nodes: TreeNode API - node.left() and node.right()



    }

    static Integer findSecondLargest(Integer[] arr) {
//        Integer secondLargest = intArrays[0];
//        for(int i = 0; i < intArrays.length; i++) {
//            int lessThanCounter = 0;
//            for(int j = 0; j < intArrays.length;  j++)  {
//                if(intArrays[i] < intArrays[j]) {
//                    lessThanCounter ++;
//                }
//
//                if(lessThanCounter > 1) {
//                    break;
//                }
//            }
//            if(lessThanCounter == 1) {
//                secondLargest = intArrays[i];
//            }
//        }
//        return secondLargest;

        //alternatively
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
            }

            if (arr[i] < max && arr[i] > secondMax) {
                secondMax = arr[i];
            }
        }
        return secondMax;
    }

    static String reverse(String s) {
        if(s.length() == 2) {
            return "" + s.charAt(1) + s.charAt(0);
        }

        int lastIndex = s.length() - 1;
        //substring(startIndex, endIndex) - [startIndex, endIndex)
        return "" + s.charAt(lastIndex) + reverse(s.substring(0,lastIndex));
    }

//    static Integer getNumberOfNodes(TreeNode node) {
//        if (node == null) {
//            return 0;
//        }
//
//        return 1 + getNumberOfNodes(node.left()) + getNumberOfNodes(node.right());
//    }
//
//    static Integer countLeafNodes(TreeNode node){
//        if(node == null) {
//            return 0;
//        }
//
//        if(node.left() == null && node.right() ==  null) {
//            return 1;
//        }
//
//        return countLeafNodes(node.left()) + countLeafNodes(node.right());
//    }

//    static Integer depthBinaryTree(TreeNode node) {
//        if(node == null) {
//            return 1;
//        }
//        if(node.left() == null && node.right() == null) {
//            return 1;
//        }else if(node.left() == null && node.right() !=null) {
//            return 1 + depthBinaryTree(node.right());
//        } else if (node.left() != null && node.right() == null) {
//            return 1 + depthBinaryTree(node.left());
//        } else{
//            return 1 + Math.max(depthBinaryTree(node.left()), depthBinaryTree(node.right()));
//        }
//
//        //alternatively
//        if(node == null) {
//            return 0;
//        }
//        return 1 + Math.max(depthBinaryTree(node.left()), depthBinaryTree(node.right()));
//    }
}
