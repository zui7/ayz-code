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

    public static void main(String[] args) {
     int[] nums = new int[]{1 ,2 ,4 ,5, 3, -1, 8 ,7};
     int target = 6; int len = nums.length;
     Set<List<Integer>> st = new HashSet<>();

     Arrays.sort(nums);

     for(int i=0; i <= len-2; i++){
         int left = i+1;
         int right = len-1;

         while(left < right) {
             int sum = nums[i] + nums[left] + nums[right];
             if (sum == target) {
                 st.add(Arrays.asList(nums[i], nums[left++], nums[right++]));
             } else {
                 if (sum < target) left++;
                 else right--;
             }
         }
     }

     st.forEach(System.out::println);

    }

}
