package string;

import java.util.*;

public class StringDemo3 {

    //滑动窗口问题
    //无重复字符的最长子串https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/

    /**
     * aaabccdefg  -->cdefg
     *
     * @param str
     * @return 时间复杂度为O(N)
     * <p>
     * 思路分析：
     * <p>
     * 使用滑动窗口，右边的窗口负责扩大区域
     */

    public String maxSubSting(String str) {
        String result = null;

        int left = 0;
        int right = 0;
        char[] chars = str.toCharArray();
        HashSet<Character> map = new HashSet<>(str.length());
        while (right < str.length()) {
            if (!map.contains(chars[right])) {
                map.add(chars[right]);

                if (result == null || result.length() < right - left) {
                    result = str.substring(left, right);
                }
            } else {
                if (result == null || result.length() < right - left) {
                    result = str.substring(left, right);
                }
                //左窗口向右移动
                while (left < right) {
                    char aChar = chars[left];
                    map.remove(aChar);
                    left++;
                    //可以确定是char[right]这个字符重复了
                    if (!map.contains(chars[right])) {
                        map.add(chars[right]);
                        break;
                    }
                }
            }
            right++;

        }
        if (result == null || result.length() < right - left) {
            result = str.substring(left, right);
        }
        return result;
    }


    /**
     * 最小覆盖子串
     * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串""
     * s-->ABBANC  t-->ABC
     *
     * @param str ODEBANCBA
     * @param sub ABC
     * @return BANC
     * <p>
     * cabwefgewcwaefgcf
     * 注意窗口起始点和长度的更新
     * <p>
     * 思路：
     * 顺序不是关键因素  ABC在str中的出现顺序不影响
     * 需要一个map来统计sub中每一个字符的出现次数
     */
    public String minSubStringCoverage(String str, String sub) {
        Map<Character, Integer> subCounts = new HashMap<>();
        Map<Character, Integer> strCounts = new HashMap<>();
        char[] subArray = sub.toCharArray();
        for (int i = 0; i < subArray.length; i++) {
            char c = subArray[i];
            int count = subCounts.get(c) == null ? 0 : 1;
            subCounts.put(c, count + 1);
        }

        //先定义  left是包含，right也是包含
        int left = -1;
        int right = -1;
        int finalLeft = left;
        int finalRight = right;
        char[] strChars = str.toCharArray();
        while (++right < str.length()) {
            //右边增加
            Integer integer = strCounts.get(strChars[right]);
            int count = 0;
            if (integer == null || integer == 0) {
                count = 0;
            } else {
                count = integer;
            }
            strCounts.put(strChars[right], count + 1);

            //注意的问题：left指针先右移动之后可能导致原先的结果不满足，所以要试探一下
            while (check(strCounts, subCounts)) {
                left++;
                if ((finalRight - finalLeft) == 0 || (right - left) < (finalRight - finalLeft)) {
                    finalLeft = left;
                    finalRight = right;
                }
                //左边收缩
                int count2 = strCounts.get(strChars[left]);
                if (count2 == 0) {
                    strCounts.put(strChars[left], 0);
                } else {
                    strCounts.put(strChars[left], count2 - 1);
                }
            }
        }
        if (finalRight == -1) {
            return null;
        }
        String result = str.substring(finalLeft, finalRight + 1);
        return result;
    }

    //已经出现的字符是否完全覆盖sub字符串
    private boolean check(Map<Character, Integer> strCounts, Map<Character, Integer> subCounts) {
        Iterator<Character> iterator = subCounts.keySet().iterator();
        while (iterator.hasNext()) {
            Character key = iterator.next();
            if (strCounts.get(key) == null || strCounts.get(key) < subCounts.get(key)) {
                return false;
            }
        }
        return true;
    }
}
