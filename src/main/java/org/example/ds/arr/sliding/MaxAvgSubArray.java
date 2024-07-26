package org.example.ds.arr.sliding;

public class MaxAvgSubArray {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length, sum = 0;

        if(n==1) return nums[0];

        for(int i=0; i<k ; i++) {
            sum += nums[i];
        }

        int maxSum = sum;
        int start = 0, end = k;

        while (end < n){
            sum = sum - nums[start++];
            sum = sum + nums[end++];

            maxSum = Math.max(maxSum,sum);
        }

        return (double) maxSum /k;
    }
}
