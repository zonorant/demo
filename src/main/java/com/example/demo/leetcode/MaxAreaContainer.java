package com.example.demo.leetcode;

/**
 * 盛最多水的容器
 * <p>
 * 给定一个长度为 n 的整数数组height。有n条垂线，第 i 条线的两个端点是(i, 0)和(i, height[i])。
 * <p>
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 * <p>
 * 返回容器可以储存的最大水量。
 */
public class MaxAreaContainer {

    /**
     * 解题思路：使用的是空间排除法，最矮的柱子和其他柱子匹配水位不会上升，面积只会缩小，要找最大的那么需要找出其他不确定的
     * 面积，于是双指针，获取当前面积后谁短就扔掉谁。
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int res = 0;
        while (i < j) {
            int curArea = (j - i) * Math.min(height[i], height[j]);
            res = Math.max(res, curArea);
            if (height[i] < height[j]){
                i++;
            } else {
                j--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int height[] = {1,8,6,2,5,4,8,3,7};
        int res = maxArea(height);
        System.out.println(res);
    }
}
