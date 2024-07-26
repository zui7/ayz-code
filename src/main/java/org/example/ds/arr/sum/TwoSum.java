package org.example.ds.arr.sum;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/two-sum/

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> sumTarget = new HashMap<>();
        for (int i = 0 ; i< nums.length ; i++){
            int diff = target - nums[i];
            if (sumTarget.containsKey(diff)){
                return new int[] {sumTarget.get(diff),i};
            }
            else{
                sumTarget.put(nums[i],i);

            }
        }
        return  new int [] {0,0};
    }

    public int[] twoSumP(int[] nums, int target) {
        int left = 0 , right = nums.length-1;
        int[] ans = new int[2];
        int[][] sort = new int[nums.length][2];

        for(int i=0; i<nums.length; i++){
            sort[i][0]=nums[i];
            sort[i][1]=i;
        }

        Arrays.sort(sort, Comparator.comparingDouble(o -> o[0]));

        int sum=0;
        while(left < right) {
            sum = sort[left][0] + sort[right][0];
            if(sum == target) {
                ans[0] = sort[left][1];
                ans[1] = sort[right][1];
                return ans;
            }
            else if(sum < target) left++;
            else right--;
        }
        return ans;
    }
}
