package com.epoch.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : Z
 * @version : 1.0
 * @Date : 2020/8/20
 */
public class Test01 {

    public static void main(String[] args) {

        int[] nums={1,2,3,5,6,8};
        int target = 7;
        int[] ints = twoSum(nums, target);
        int[] ints1 = twoSum2(nums, target);
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(ints1));
    }

    /**
     * 双重for循环遍历数组
     * @param nums 数组
     * @param target 目标数字
     * @return 符合条件数字的数组索引
     */
    private static int[] twoSum(int[] nums,int target){
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[j] == target - nums[i]){
                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException("no two num sum solution");
    }

    private static int[] twoSum2(int[] nums,int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            //判断是否存在非自身满足条件的加数
            if(map.containsKey(num) && map.get(num) != i){
                return new int[]{map.get(num),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("no two sum solution");
    }
}
