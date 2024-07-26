package org.example.ds.arr.TwoPtr;

//https://leetcode.com/problems/container-with-most-water

public class MaxArea {
    public int maxAreaBucket(int[] height) {
        int left = 0, right = height.length -1;
        int maxArea = 0, area = 0;

        while(left < right) {
            int xDist = right - left;

            if(height[left] < height[right]){
                area = xDist * height[left++];
            } else{
                area = xDist * height[right--];
            }

            if(area > maxArea)
                maxArea = area;
        }

        return maxArea;

    }
}
