package com.wj.filetranfor;

/**
 * 给定一个非降序数组，给一个目标值target
 * 数组存在则返回这个值的起始下标和结束下标
 * 不存在则返回[-1,-1]
 * 如，[5,7,7,8,8,10] target = 8
 * 则返回[3,4]
 * 要求时间复杂度为O(log n)
 * */
public class BinarySearchMid {
    public static int[] searchRange(int[] a, int target){
        int left = left(a,target);
        if (left == -1){
            return new int[]{-1,-1};
        }else return new int[]{left,right(a,target)};
    }
    public static int left(int[] a, int target){
        int l = 0,r = a.length - 1;
        int leftValue = -1;
        while (l <= r){
            int mid = (l + r) >>> 1;
            if (target < a[mid]){
                r = mid - 1;
            }else if(target > a[mid]){
                l = mid + 1;
            }else {
                leftValue = mid;
                r = mid -1;
            }
        }
        return leftValue;
    }
    public static int right(int[] a, int target){
        int l = 0,r = a.length - 1;
        int rightValue = -1;
        while (l <= r){
            int mid = (l + r) >>> 1;
            if (target < a[mid]){
                r = mid - 1;
            }else if(target > a[mid]){
                l = mid + 1;
            }else {
                rightValue = mid;
                l = mid + 1;
            }
        }
        return rightValue;
    }
    public static void main(String[] args){
        int[] arr = {5,7,7,8,8,8,10};
        int[] res = searchRange(arr,8);
        for(int i = 0; i < res.length; i++) {
           System.out.println(res[i]);
        }
    }
}
