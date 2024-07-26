package org.example.ds.arr.pos;
//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array

public class FirstLastPosition {

    public static int[] searchRange(int[] nums, int target) {
        int[] ans = {-1,-1};
        int start = binSearch(nums, target, true);
        int end  = binSearch(nums, target,false);
        ans[0] = start;
        ans[1] = end;
        return ans;
    }
    private static int binSearch( int[] nums, int target, boolean firstItr) {
        int low = 0;
        int high = nums.length - 1 ;
        int ans = -1;

        while( low <= high) {
            int mid = low + (high - low) / 2 ;
            if ( target <  nums[mid]  ) {
                high = mid - 1;
            }
            else if ( target > nums[mid] ) {
                low = mid + 1;
            }
            else if (target == nums[mid]) {
                ans = mid;
                if (firstItr)
                    high = mid -1;
                else
                    low = high +1;
            }
        }
        return ans;
    }
}
