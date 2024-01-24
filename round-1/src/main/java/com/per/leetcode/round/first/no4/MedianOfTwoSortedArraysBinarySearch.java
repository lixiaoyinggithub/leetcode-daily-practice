package com.per.leetcode.round.first.no4;

/**
 * NO 4
 * <p>
 * <p>
 * 通过不断对比两个数组的中间元素的大小，以及当前中间元素的下标和与k的大小，决定丢弃哪四分之一；二分查找，但是在这种情况下，也可以说是四分查找
 * 以k为中心，决定丢弃左边还是右边
 * 以2个mid值大小，决定丢弃a的还是b的左边还是右边
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
            // 假如n=7,n/2=3
            return solve(A, B, n / 2, 0, na - 1, 0, nb - 1);
        } else {
            return (double) (solve(A, B, n / 2, 0, na - 1, 0, nb - 1) + solve(A, B, n / 2 - 1, 0, na - 1, 0, nb - 1)) / 2;
        }
    }

    public int solve(int[] A, int[] B, int k, int aStart, int aEnd, int bStart, int bEnd) {

        System.out.println("-------------------");
        System.out.println("初始值：k=" + k + ",aStart=" + aStart + ",aEnd=" + aEnd + ",bStart=" + bStart + ",bEnd=" + bEnd);

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

        // 根据k属于与中间坐标的和的比较，决定需要丢弃哪个方向
        // 如果k大，说明当前范围集中在，要丢弃左边
        // 如果k小，说明

        System.out.println("索引的比较：midIndexSum = " + (aMidIndex + bMidIndex) + ",aMidIndex=" + aMidIndex + ",bMidIndex=" + bMidIndex);
        System.out.println("中间元素的大小：" + "aMidValue=" + aMidValue + "；bMidValue=" + bMidValue);
        // If k is in the right half of A + B, remove the smaller left half.
        if (aMidIndex + bMidIndex < k) {
            if (aMidValue > bMidValue) {
                // 丢弃b的左半段
                return solve(A, B, k, aStart, aEnd, bMidIndex + 1, bEnd);
            } else {
                // 丢弃a的左半段
                return solve(A, B, k, aMidIndex + 1, aEnd, bStart, bEnd);
            }
        }
        // Otherwise, remove the larger right half.
        else {
            if (aMidValue > bMidValue) {
                // 丢弃a的右半段
                return solve(A, B, k, aStart, aMidIndex - 1, bStart, bEnd);
            } else {
                return solve(A, B, k, aStart, aEnd, bStart, bMidIndex - 1);
            }
        }
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArraysBinarySearch binarySearch = new MedianOfTwoSortedArraysBinarySearch();

        int[] a = new int[3];
        a[0] = 1;
        a[1] = 2;
        a[2] = 3;

        int[] b = new int[4];
        b[0] = 2;
        b[1] = 3;
        b[2] = 4;
        b[3] = 5;

        binarySearch.findMedianSortedArrays(a, b);

//        System.out.println(7 / 2);
    }
}
