package org.gary.problemSolving;

/**
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
 *
 * Return true if you can reach the last index, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10^4
 * 0 <= nums[i] <= 10^5
 */
public class MinimalJump {
//    public boolean canJump(int[] nums) {
//        int len = nums.length;
//
//        if(len == 1) {
//            return true;
//        }
//
//        int max = 0;
//        for(int index = 0; index < len -1 && max >= index; index++) {
//            if(max < index + nums[index]) {
//                max = index + nums[index];
//            }
//
//            if(max >= len -1) {
//                return true;
//            }
//        }
//        return false;
//    }
    public boolean canJump(int[] nums) {
        int lastGoodIndex = nums.length - 1;
        for(int index = lastGoodIndex; index >=0; index--) {
            if(index + nums[index] >= lastGoodIndex) {
                //the current index is reachable
                lastGoodIndex = index;
            }
        }
        return lastGoodIndex == 0;
    }


    static int[] initializeLargeArray() {
        int len = 9999;
        int[] largeArray = new int[len + 1];
        for(int i = 0; i < 9999; i++) {
            largeArray[i] = len--;
        }
        largeArray[len] = 0;

        return largeArray;
    }

    public static void main(String args[]) {
        MinimalJump mj = new MinimalJump();
        int[] nums = {2,3,1,0,4};
        System.out.println(mj.canJump(nums));
        int[] nums1 = {2,3,1,1,4};
        System.out.println(mj.canJump(nums1));
        int[] nums2 = {5,0};
        System.out.println(mj.canJump(nums2));
        int[] nums22 = {2,5,0,0};
        System.out.println(mj.canJump(nums22));
        int[] nums222 = {3,0,8,2,0,0,1};
        System.out.println(mj.canJump(nums222));
        int[] nums6 = {5,0,0,0,0,1,0};
        System.out.println(mj.canJump(nums6));
        int[] nums8 = {8,2,4,4,4,9,5,2,5,8,8,0,8,6,9,1,1,6,3,5,1,2,6,6,0,4,8,6,0,3,2,8,7,6,5,1,7,0,3,4,8,3,5,9,0,4,0,1,0,5,9,2,0,7,0,2,1,0,8,2,5,1,2,3,9,7,4,7,0,0,1,8,5,6,7,5,1,9,9,3,5,0,7,5};
        System.out.println(mj.canJump(nums8));

        int[] nums3 = {0,5};
        System.out.println(mj.canJump(nums3));
        int[] nums4 = {3,2,1,0,5};
        System.out.println(mj.canJump(nums4));
        int[] nums5 = {5,0,0,0,0,0,0};
        System.out.println(mj.canJump(nums5));
        int[] nums7 = {5,0,0,0,0,0,0};
        System.out.println(mj.canJump(nums7));

        System.out.println(mj.canJump(initializeLargeArray()));

        int[] random = {2,0,6,9,8,4,5,0,8,9,1,2,9,6,8,8,0,6,3,1,2,2,1,2,6,5,3,1,2,2,6,4,2,4,3,0,0,0,3,8,2,4,0,1,2,0,1,
                4,6,5,8,0,7,9,3,4,6,6,5,8,9,3,4,3,7,0,4,9,0,9,8,4,3,0,7,7,1,9,1,9,4,9,0,1,9,5,7,7,1,5,8,2,8,2,6,8,2,2,7,5,1,7,9,6};
        System.out.println(mj.canJump(random));
    }
}
