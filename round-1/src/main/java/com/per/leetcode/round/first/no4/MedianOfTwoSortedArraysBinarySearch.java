package com.per.leetcode.round.first.no4;

/**
 * NO 4
 *
 * @author Xavier
 * @date 2024/1/19 14:17
 */
public class MedianOfTwoSortedArraysBinarySearch {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int na = A.length, nb = B.length;
        int n = na + nb; // n为2个数组的长度的和
        if ((na + nb) % 2 == 1) {
            // k为n/2即中间的位置
            // a的范围为a开始和a结束的位置
            // b的范围为b开始和b结束的位置
            return solve(A, B, n / 2, 0, na - 1, 0, nb - 1);
        } else {
            return (double) (solve(A, B, n / 2, 0, na - 1, 0, nb - 1) + solve(A, B, n / 2 - 1, 0, na - 1, 0, nb - 1)) / 2;
        }
    }

    public int solve(int[] A, int[] B, int k, int aStart, int aEnd, int bStart, int bEnd) {
        // If the segment of on array is empty, it means we have passed all
        // its element, just return the corresponding element in the other array.
        if (aEnd < aStart) {
            //当A超出范围后，说明不在A段，在B数组里，且在k减去a的起点坐标的位置
            return B[k - aStart];
        }
        if (bEnd < bStart) {
            //当B超出范围后
            return A[k - bStart];
        }

        // Get the middle indexes and middle values of A and B.
        // 获取两个数组的中间的索引和值
        int aMidIndex = (aStart + aEnd) / 2, bMidIndex = (bStart + bEnd) / 2;
        int aMidValue = A[aMidIndex], bMidValue = B[bMidIndex];

        //找出两个part的中间元素
        //1、比较当前两个中间下标和与k的大小，如果小于k，说明
        //1、比较当前两个中间下标和与k的大小，如果小于k，说明当前中间元素（也即）

        // If k is in the right half of A + B, remove the smaller left half.
        if (aMidIndex + bMidIndex < k) {
            if (aMidValue > bMidValue) {
                return solve(A, B, k, aStart, aEnd, bMidIndex + 1, bEnd);
            } else {
                return solve(A, B, k, aMidIndex + 1, aEnd, bStart, bEnd);
            }
        }
        // Otherwise, remove the larger right half.
        else {
            if (aMidValue > bMidValue) {
                return solve(A, B, k, aStart, aMidIndex - 1, bStart, bEnd);
            } else {
                return solve(A, B, k, aStart, aEnd, bStart, bMidIndex - 1);
            }
        }
    }
}
