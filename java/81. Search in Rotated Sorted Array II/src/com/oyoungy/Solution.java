package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println(ans.search(new int[]{2,5,6,0,0,1,2}, 2));
        System.out.println(ans.search(new int[]{1}, 2));
        System.out.println(ans.search(new int[]{3,5,1}, 3));
        System.out.println(ans.search(new int[]{1,1,1,3,1}, 3));
        System.out.println(ans.search(new int[]{1,3,1,1}, 3));
        System.out.println(ans.search(new int[]{1,1,1,0,1}, 0));
        System.out.println(ans.search(new int[]{1,0,1,1}, 0));
        System.out.println(ans.search(new int[]{1,2,0,1,1,1}, 0));
    }
    //TODO modify
    public boolean search(int[] nums, int target) {
        if(nums==null || nums.length==0) return false;
        int low = 0, high = nums.length;
        while (low<high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target){
                low = mid;
                break;
            }
            while(low<high-1 && nums[mid]==nums[low]&&nums[mid]==nums[high-1]){ //将两端与mid值相同的值排除
                low++;
                high--;
            }
            if(nums[mid]<target){
                if(nums[low]<target || target<=nums[high-1]){
                    low = mid+1;
                }else{
                    high = mid;
                }
            }else {
                if(nums[high-1]>target || nums[low]<=target){
                    high = mid;
                }else {
                    low = mid+1;
                }
            }
        }
        return low<nums.length?nums[low]==target:false;
    }
    public boolean search1(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid]==target) return true;
            while (nums[mid]==nums[left]&&nums[mid]==nums[right]&&left<right) {
                left++;
                right--;
            }
            if (nums[mid] >= nums[left]) {
                if (target >= nums[left] && target <= nums[mid]) right = mid;
                else left = mid + 1;
            } else {
                if (target <= nums[right] && target >= nums[mid]) left = mid;
                else right = mid - 1;
            }
        }
        return false;
    }
}