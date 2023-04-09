package cn.datawisher.cyder.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCodeTest {

    public static void main(String[] args) {

        int[] nums = new int[]{2, 5, 5, 11};
        int target = 10;
        int[] ints = twoSum(nums, target);
        System.out.println("result = " + Arrays.toString(ints));

    }

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> hashtable = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
}
