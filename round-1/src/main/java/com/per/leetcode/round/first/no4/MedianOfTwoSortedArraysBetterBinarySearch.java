package com.per.leetcode.round.first.no4;

import sun.jvm.hotspot.gc.shared.Space;

import java.sql.Time;

/**
 * @author Xavier
 * @date 2024/1/23 11:17
 */
public class MedianOfTwoSortedArraysBetterBinarySearch {

    /**
    Approach 3: A Better Binary Search
    Intuition
    Recall the previous approach where we perform a binary search over the 'merged' array consisting of nums1 and nums2, resulting in a time complexity of O(log⁡(m⋅n))O(\log(m \cdot n))O(log(m⋅n)). We could further improve the algorithm by performing the binary search only on the smaller array of nums1 and nums2, thus the time complexity is reduced to O(log⁡(min⁡(m,n)))O(\log(\min(m, n)))O(log(min(m,n))).

    The main idea is similar to approach 2, where we need to find a point of partition in both arrays such that the maximum of the smaller half is less than or equal to the minimum of the larger half.

    However, instead of partitioning over the merged arrays, we can only focus on partitioning the smaller array (let's call this array A). Suppose the partition index is partitionA, we specify that the smaller half contains (m + n + 1) / 2 elements, and we can use this feature to our advantage by directly making partitionB equal to (m + n + 1) / 2 - partitionA, thus the smaller halves of both arrays always contain a total of (m + n + 1) / 2 elements, as shown in the picture below.

            img

            The next step is to compare these edge elements.

            img

            If both maxLeftA <= minRightB and maxLeftB <= minRightA hold, it means that we have partitioned arrays at the correct place.

            The smaller half consists of two sections A_left and B_left
                                                                                                                          THe larger half consists of two sections A_right and B_right
                                                                                                                          We just need to find the maximum value from the smaller half as max(A[maxLeftA], B[maxLeftB]) and the minimum value from the larger half as min(A[minRightA], B[minRightB]). The median value depends on these four boundary values and the total length of the input arrays and we can compute it by situation.

    img

    If maxLeftA > minRightB, it implies that maxLeftA is too large to be in the smaller half and we should look for a smaller partition value of A.

    img

    Otherwise, it denotes that minRightA is too small to be in the larger half and we should look for a larger partition value of A.

    img


            Algorithm
    Assuming nums1 to be the smaller array (If nums2 is smaller, we can swap them). Let m, n represent the size of nums1 and nums2, respectively.

    Define the search space for the partitioning index partitionA by setting boundaries as left = 0 and right = m.

            While left <= right holds, do the following.

    Compute the partition index of nums1 as partitionA = (left + right) / 2. Consequently, the partition index of nums2 is (m + n + 1) / 2 - partitionA.

    Obtain the edge elements:

    Determine the maximum value of the section A_left as maxLeftA = nums1[partitionA - 1]. If partitionA - 1 < 0, set it as maxLeftA = float(-inf).
    Determine the minimum value of the section A_right as minRightA = nums1[partitionA]. If partitionA >= m, set it as minRightA = float(inf).
    Determine the maximum value of the section B_left as maxLeftB = nums2[partitionB - 1]. If partitionB - 1 < 0, set it as maxLeftB = float(-inf).
    Determine the maximum value of the section B_right as minRightB = nums2[partitionB]. If partitionB >= n, set it as minRightB = float(inf).
    Compare and recalculate: Compare maxLeftA with minRightB and maxLeftB with minRightA.

    If maxLeftA > minRightB, it means the maxLeftA is too large to be in the smaller half, so we update right = partitionA - 1 to move to the left half of the search space.
    If maxLeftB > minRightA, it means that we are too far on the left side for partitionA and we need to go to the right half of the search space by updating left = partitionA + 1.
    Repeat step 4.

    When both maxLeftA <= minRightB and maxLeftB <= minRightA are true:

    If (m + n) % 2 = 0, the median value is the average of the maximum value of the smaller half and the minimum value of the larger half, given by answer = (max(maxLeftA, maxLeftB) + min(minRightA, minRightB)) / 2.
    Otherwise, the median value is the maximum value of the smaller half, given by answer = max(maxLeftA, maxLeftB).
    Implementation

    Complexity Analysis
    Let mmm be the size of array nums1 and nnn be the size of array nums2.

    Time complexity: O(log⁡(min⁡(m, n)))O(\log(\min(m, n)))O(log(min(m, n)))

    We perform a binary search over the smaller array of size min⁡(m,n)\min(m, n)min(m,n).
    Space complexity: O(1)O(1)O(1)

    The algorithm only requires a constant amount of additional space to store and update a few parameters during the binary search.

     **/
}
