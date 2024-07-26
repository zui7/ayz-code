package org.example.ds.arr.TwoPtr;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        if(nums.length > 1 ) {
            int len = nums.length;
            if( k > len ) k = k %len;
            reverse(nums, 0, len-k-1);
            reverse(nums, len-k, len-1);
            reverse(nums, 0, len-1);
        }
    }

    public void reverse(int[] nums, int i, int j){
        int temp=0;
        for(; i<j ; i++,j--){
            //swap
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

    }
}
