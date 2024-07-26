package org.example.ds.arr.sliding;

// binary array nums and an integer k, return the maximum number of consecutive 1's in the
// array if you can flip at most k 0's. nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2, ans = 6.

public class MaxConsOnes {
    public int longestOnes(int[] nums, int k) {
        int start=0, end = 0, zero = 0;

        while(end < nums.length) {
            if (nums[end] == 0) {
                zero++;
            }
            end++;
            if (zero > k){
                if(nums[start] == 0){
                    zero--;
                }
                start++;
            }
        }

        return end-start;

    }
}
