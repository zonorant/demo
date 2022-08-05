package com.example.demo.leetcode;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Arrays;
import java.util.Stack;

/**
 * 接雨水
 * https://leetcode.cn/problems/trapping-rain-water/
 */
public class Water {

    /**
     * 解题思路：暴力破解
     * 想象成搭积木，先搭第一层，找出两个积木块之间的空格，再第二层，把每一层的空格计算出来就是存水的数量
     *
     * @param height
     * @return
     */
    public static int trap1(int[] height) {
        int totalWater = 0;
        //首先要计算出层高，就是找最高的那根柱子,因为最后一个坑位只参与比较不用遍历，使用冒泡求最大值，可以使用更快的
        int h = 0;
        for (int i = 0; i < height.length - 1; i++) {
            h = Math.max(height[i], height[i + 1]);
        }
        //开始每层遍历
        for (int i = 1; i <= h; i++) {
            //每层的开关
            boolean status = false;
            //临时水桶
            int temp = 0;
            for (int j = 0; j < height.length; j++) {
                //大于等于当前层高的，打开计算开关
                if (height[j] >= i) {
                    //倒入总集水器
                    totalWater += temp;
                    //清空临时水桶
                    temp = 0;
                    status = true;
                }
                //开关打开，且当前高度小于的层高的，则计算加水
                if (status && height[j] < i) {
                    temp++;
                }
            }
        }
        return totalWater;
    }

    /**
     * 解题思路：减少无用操作
     * 算出层高需要排序，多次循环清空临时桶，都比较费劲。这次把它看成一个整体，计算列和列之间的水
     *
     * @param height
     * @return
     */
    public static int trap2(int[] height) {
        int totalWater = 0;
        //两端的列可以不用考虑，因为无论它的高矮都不会存水
        for (int i = 1; i < height.length - 1; i++) {
            //找出当前列左边最高的高度
            int left = 0;
            for (int j = i - 1; j > 0; j--) {
                left = Math.max(left, height[j]);
            }
            //找出当前列右边最高的列
            int right = 0;
            for (int j = i + 1; j < height.length; j++) {
                right = Math.max(right, height[j]);
            }
            //只有当前高度比最矮的一端还要矮，那么才能存水
            int min = Math.min(left, right);
            if (min > height[i]) {
                totalWater += min - height[i];
            }
        }
        return totalWater;
    }

    /**
     * 解题思路：预先计算
     * 先计算出每次循环的左右墙，遍历时发现每次只要每次比对当前列高和前一个的列高，谁高就保留谁，
     * 利用冒泡的原理拿到每个列的左边最高和右边最高的排列集合，再进行遍历所有列求出存水。
     * 比上个方法节省了循环次数
     *
     * @param height
     * @return
     */
    public static int trap3(int[] height) {
        int totalWater = 0;
        //因为两端无论高低都不需要参与存水计算，所以抛弃，预测左边的最高列
        int[] left = new int[height.length];
        for (int i = 1; i < height.length - 1; i++) {
            left[i] = Math.max(left[i - 1], height[i - 1]);
        }
//        System.out.println(Arrays.toString(left));
        //预测右侧的最高列
        int[] right = new int[height.length];
        for (int i = height.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }
//        System.out.println(Arrays.toString(right));
        //遍历所有列计算存水
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(left[i], right[i]);
            if (min > height[i]) {
                totalWater += min - height[i];
            }
        }
        return totalWater;
    }

    /**
     * 解题思路：双指针
     * 上面已经进行了预测，用两个数组装载了左右列，进一步减少循环，使用指针指来记录每次指向的两边的最高列
     *
     * @param height
     * @return
     */
    public static int trap4(int[] height) {
        int totalWater = 0;
        int left_h = 0;
        int right_h = 0;
        int left_i = 1;
        int right_i = height.length - 2;
        for (int i = 1; i < height.length - 1; i++) {
            if (height[left_i - 1] < height[right_i + 1]) {
                left_h = Math.max(left_h, height[left_i - 1]);
                if (left_h > height[left_i]) {
                    totalWater += left_h - height[left_i];
                }
                left_i++;
            } else {
                right_h = Math.max(right_h, height[right_i + 1]);
                if (right_h > height[right_i]) {
                    totalWater += right_h - height[right_i];
                }
                right_i--;
            }
        }
        return totalWater;
    }

    /**
     * 解题思路：利用栈替代指针的理解上的复杂
     * 利用栈的特性和指针保存最高大的洼地，然后回溯洼地中的存水计算
     *
     * @param height
     * @return
     */
    public static int trap5(int[] height) {
        int totalWater = 0;
        Stack<Integer> wall = new Stack<>();
        int current = 0;
        while (current < height.length) {
            //如果栈不为空，只要当前列高比上列低就入栈，直到找到可以形成存水的列，然后每个存水点的存水进行累计
            while (!wall.empty() && height[current] > height[wall.peek()]) {
                //获取栈顶层的指针指向的列高
                int h = height[wall.peek()];
                wall.pop();
                //如果栈已经空了那就结束
                if (wall.empty()) {
                    break;
                }
                //计算栈中列和当前列之间的距离
                int distance = current - wall.peek() - 1;
                //获取最矮的那一列高作为存水线
                int min = Math.min(height[current], height[wall.peek()]);
                totalWater = totalWater + distance * (min - h);
            }
            wall.push(current);
            current++;
        }
        return totalWater;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int result = trap1(height);
        System.out.println(result);

        result = trap2(height);
        System.out.println(result);

        result = trap3(height);
        System.out.println(result);

        result = trap4(height);
        System.out.println(result);

        result = trap5(height);
        System.out.println(result);
    }
}
