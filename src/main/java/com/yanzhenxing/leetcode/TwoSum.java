package com.yanzhenxing.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jason Yan
 * @date 19/11/2018
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        int[] result = new int[2];
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }

        return result;
    }

    public int[] twoSum_1(int[] nums, int target) {
        int length = nums.length;

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        int[] result = new int[2];
        for (int i = 0; i < length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
            if (map.containsKey(target - nums[i]) && i != map.get(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                return result;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] originalInput = {3, 2, 4};
        int[] result = twoSum.twoSum_1(originalInput, 6);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
