package org.example.ds.arr.sum;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ls = new ArrayList<>();
        Set<List<Integer>> hs = new HashSet<>();
        int x=0, left=0, right=0;

        Arrays.sort(nums);

        for(int i = 0 ; i <= nums.length-2; i ++){
            left = i+1; right = nums.length-1;
            while(left<right) {
                x=nums[left]+nums[right];
                if(x==-nums[i]){
                    hs.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;right--;
                }
                else if (x < -nums[i]) left++;
                else right--;
            }

        }
        ls.addAll(hs);
        return ls;
    }


}
