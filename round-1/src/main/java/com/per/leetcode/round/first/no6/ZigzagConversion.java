package com.per.leetcode.round.first.no6;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 *
 * @author Xavier
 * @date 2024/5/6 09:35
 */
public class ZigzagConversion {

    /**
     * 寻找规律的时候，通过归纳、演绎，从已知的出发
     *
     * 如 numRows与第一行第二个字母的间隔的关系为，需要向下到numRows，然后再向上
     *
     * @param args
     */
    public static void main(String[] args) {
        String result = convert("PAYPALISHIRING", 3);
        System.out.println("result=" + result);
    }

    /**
     * 3-2 = 1; 1*2 = 2; 2+1 = 3
     * <p>
     * 4-2 = 2; 2*2 = 4; 4+1 = 5
     *
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        char[] chars = s.toCharArray();

        if (numRows == 1) {
            return s;
        }
        int gap = (numRows - 2) * 2 + 1;
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < chars.length; j += gap) {
                System.out.print(chars[j] + "\t");
                sb.append(chars[j]);
            }
            System.out.print("\n");
        }
        return sb.toString();

    }

}
