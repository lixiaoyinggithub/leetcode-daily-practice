package com.per.xavier;

/**
 * @author Xavier
 * @date 2025/1/15 11:15
 */
public class BinarySearch {

    public static int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            System.out.println("mid=" + mid + ",left=" + left + ",right=" + right);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
            // mid+1或者mid
        }
        System.out.println(",left=" + left + ",right=" + right);
        return -1;
    }

    /**
     * 如果无法找到目标值，目标值在数组的不同方向，终结条件不同
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int idx = search(arr, 4);
        System.out.println(idx);
    }


}
