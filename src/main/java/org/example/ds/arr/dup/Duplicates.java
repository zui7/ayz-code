package org.example.ds.arr.dup;

//https://leetcode.com/problems/find-the-duplicate-number/description/

public class Duplicates {
    public int findDuplicateBySwap(int[] nums) {
        int temp = 0, tu=0, count = 0;
        do{
            if (nums[nums[0]] != nums[0]){
                temp = nums[0];
                tu = nums[nums[0]];
                nums[nums[0]] = temp;
                nums[0] = tu;
                count++;
            }
            else {
                return nums[0];
            }
        } while(count < nums.length-1);
        return nums[0];
    }

    public static int findDuplicateByFastSlow(int[] nums) {
        int fast = 0 , slow = 0;

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow=0;
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }

        return slow;
    }

}
