package com.oyoungy;

public class Solution {
    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println(ans.findKthLargest(new int[]{3,2,1,5,6,4}, 2));
        System.out.println(ans.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},4));
    }
    public int findKthLargest(int[] nums, int k) {
        if(nums==null || nums.length==0 || k<=0) throw new RuntimeException();
        return findKthLargestByQuickSort(nums, k, 0, nums.length-1);
    }

    int findKthLargestByQuickSort(int[] nums, int k, int low, int high){
        int t = partion(nums, low, high);
       if(k<nums.length-t){
            return findKthLargestByQuickSort(nums, k, t+1, high);
        }else if(k>nums.length-t){
            return findKthLargestByQuickSort(nums, k, low, t-1);
        } else {
            return nums[t];
        }
    }

    int partion(int[] nums, int low, int high){
        if(low>=high){
            return low;
        }
        int t_low = low, pivot = nums[low];
        while (low<high){
            while (nums[high]>pivot && low<high){
                high--;
            }

            while (nums[low]<=pivot && low<high){
                low++;
            }

            switchNum(nums, low, high);
        }
        switchNum(nums, t_low, low);

        return low;
    }

    private void switchNum(int[] nums, int i1, int i2){
        //switch
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }
}