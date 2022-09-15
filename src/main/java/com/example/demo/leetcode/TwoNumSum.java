package com.example.demo.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 */
public class TwoNumSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> resMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (resMap.containsKey(target - nums[i])) {
                int[] ints = {resMap.get(target - nums[i]), i};
                return ints;
            }
            resMap.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        twoSum(nums, target);
    }
}
