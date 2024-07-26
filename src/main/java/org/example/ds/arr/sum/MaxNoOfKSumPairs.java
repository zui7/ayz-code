package org.example.ds.arr.sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxNoOfKSumPairs {
    //hash map
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        int op=0;

        for (int num : nums) {
            int diff = k - num;
            if (hm.containsKey(diff)) {
                op++;
                int freq = hm.get(diff);
                if (freq == 1)
                    hm.remove(diff);
                else
                    hm.put(diff, freq - 1);
            } else
                hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        return op;
    }

    //---- Two pointer
    public int maxOp(int[] nums, int k) {
        int i = 0, j = nums.length - 1; int op = 0;

        Arrays.sort(nums);

        while( i < j) {
            int sum = nums[i] + nums[j];
            if (sum == k ){
                op++; i++; j--;
            }
            else if ( sum < k )
                i++;
            else
                j--;
        }
        return op;
    }
}
