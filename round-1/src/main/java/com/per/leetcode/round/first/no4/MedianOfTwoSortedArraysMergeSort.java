package com.per.leetcode.round.first.no4;

import java.util.concurrent.*;

/**
 * NO 4
 *
 * @author Xavier
 * @date 2024/1/19 14:17
 */
public class MedianOfTwoSortedArraysMergeSort {
    private int p1 = 0, p2 = 0;

    // Get the smaller value between nums1[p1] and nums2[p2] and move the pointer forwards.

    private int getMin(int[] nums1, int[] nums2) {
        if (p1 < nums1.length && p2 < nums2.length) {
            return nums1[p1] < nums2[p2] ? nums1[p1++] : nums2[p2++];
        } else if (p1 < nums1.length) {
            return nums1[p1++];
        } else if (p2 < nums2.length) {
            return nums2[p2++];
        }
        return -1;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        // even
        if ((m + n) % 2 == 0) {
            for (int i = 0; i < (m + n) / 2 - 1; ++i) {
                //traverse to the middle of the arrays,but the middle decided by two arrays.
                // which one is smaller,than out. It means that the final sort get the newest smallest element.
                int tmp = getMin(nums1, nums2);
            }
            return (double) (getMin(nums1, nums2) + getMin(nums1, nums2)) / 2;
        } else { // odd
            for (int i = 0; i < (m + n) / 2; ++i) {
                int tmp = getMin(nums1, nums2);
            }
            return getMin(nums1, nums2);
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor(r -> new Thread("clearRecordTask"));

        System.out.println("start");
        Future<?> future = executorService.submit(() -> {
//            System.out.println("haha");
            return "";
        });
        Object o = future.get();
        System.out.println("end");

        executorService.shutdown();

        Thread.sleep(3000);
    }
}


