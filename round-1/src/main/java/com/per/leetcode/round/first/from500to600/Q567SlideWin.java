package com.per.leetcode.round.first.from500to600;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xavier
 * @date 2025/1/15 09:48
 */
public class Q567SlideWin {

    /**
     * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的
     * 排列
     * 。如果是，返回 true ；否则，返回 false 。
     * <p>
     * 换句话说，s1 的排列之一是 s2 的 子串 。 (这句话是关键点，说明其中一种排列可能就行)
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：s1 = "ab" s2 = "eidbaooo"
     * 输出：true
     * 解释：s2 包含 s1 的排列之一 ("ba").
     * 示例 2：
     * <p>
     * 输入：s1= "ab" s2 = "eidboaoo"
     * 输出：false
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean checkInclusion(String s1, String s2) {
        int left = 0, right = 0;

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int s1Len = s1.length();
        int s2Len = s2.length();

        int valid = 0;
        while (right < s2Len) {
            char c = s2.charAt(right);

            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            right++;
            while (right - left + 1 > s1Len) {
                if (valid == need.size()) {
                    return true;
                }
                char d = s2.charAt(left);
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
                left++;

            }
        }
        return false;
    }


    /**
     * 在对窗口操作前，可以先判断是否属于s1的字符，如果不是，不需要放入窗口
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidboaoo"));
//        System.out.println(checkInclusion("ab", "asdhajskhdab"));
    }
}
