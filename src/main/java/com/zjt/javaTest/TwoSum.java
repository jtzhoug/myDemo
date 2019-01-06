package com.zjt.javaTest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhou.jingtao
 * @date created in 13:24 2018/10/28
 * @Description:
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = i;
                result[1] = map.get(target - nums[i]);
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return result;

    }

    public int[] twoSum2(int[] nums, int target) throws IllegalAccessException {

        int[] result = new int[2];
        for (int i=0 ; i<nums.length;i++){
            for (int j=i+1 ; j<nums.length ;j++){
                if (nums[i] + nums [j] == target){
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
    return result;
    }

    public int[] twoSum1(int[] nums, int target) throws IllegalAccessException {

        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        for (int i=0 ; i<nums.length;i++){
            if (map.containsKey(target - nums[i])){
                result[0] = i;
                result[1] = map.get(target - nums[i]);
            }
            map.put(nums[i],i);
        }
        return result;
    }

    public static void main(String[] args) throws IllegalAccessException {
//        int nums[] = {3, 2, 4};
//        int target = 6;
//        int[] result = new int[2];
//
//        TwoSum twoSum = new TwoSum();
//        result = twoSum.twoSum2(nums, target);
//        System.out.println(result);

        int count = 0;
        int num = 0;
        for (int i=0;i<=100;i++){
            num = num + i;
            count = count++;
        }
        System.out.println(num*count);

    }


}
