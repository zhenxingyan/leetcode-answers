package com.yanzhenxing.leetcode;

/**
 * @author Jason Yan
 * @date 19/11/2018
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        int[] result = new int[2];
        for (int i = 0; i < length-1; i++) {
            for (int j = i+1; j < length; j++) {
                if(nums[i]+nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] originalInput = {2,7,11,5};
        int[] result = twoSum.twoSum(originalInput,9);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
