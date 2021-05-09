package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class StringDemo2 {

    //滑动窗口问题
    //无重复字符的最长子串https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/

    /**
     * aaabccdefg  -->cdefg
     *
     * @param str
     * @return 时间复杂度为O(N)  虽然有两层嵌套，但是遍历的起始点不重复，可以理解为，外层遍历(0-mid),内层遍历(mid-n)
     */
    public String maxNoDuplicatesSubString(String str) {
        int end = -1;
        HashSet<Character> map = new HashSet<>(str.length());
        String max = null;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            //start右移，end右移
            if (i > 0) {
                map.remove(str.charAt(i - 1));
                builder.deleteCharAt(0);
            }
            while (end + 1 < str.length() && !map.contains(str.charAt(end + 1))) {
                map.add(str.charAt(end + 1));
                builder.append(str.charAt(end + 1));
                end++;
            }
            if (max == null) {
                max = builder.toString();
            } else if (builder.toString().length() > max.length()) {
                max = builder.toString();
            }
        }
        System.out.println("maxNoDuplicatesSubString->" + max);
        return max;
    }


    //最小覆盖子串https://leetcode-cn.com/problems/minimum-window-substring/

    /**
     * 最小覆盖子串
     * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串""
     * s-->ABBANC  t-->ABC
     *
     * @param s AODEBANC
     * @param t ABC
     * @return BANC
     * <p>
     * cabwefgewcwaefgcf
     * 注意窗口起始点和长度的更新
     */
    public String minCoverSubString(String s, String t) {
        HashMap<Character, Integer> origin = new HashMap<>();
        HashMap<Character, Integer> appeared = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            origin.put(c, origin.getOrDefault(c, 0) + 1);
        }
        //嗅探指针起点
        int start = 0;
        //嗅探指针终点
        int end = -1;
        //窗口起点
        int ansL = -1;
        //窗口终点
        int ansR = end;
        //窗口的长度
        int len = Integer.MAX_VALUE;
        //当嗅探指针的终点移动到字符串终点时，循环结束
        while (end < s.length()) {
            //注意扩大窗口的时机
            ++end;
            if (end < s.length()) {
                char charAt = s.charAt(end);
                appeared.put(charAt, appeared.getOrDefault(charAt, 0) + 1);
            }
            while (check(origin, appeared)) {
                //缩小窗口
                //注意ansR的更新时机，当前的窗口宽度必须要上一个
                if (end - start + 1 < len) {
                    len = end - start + 1;
                    ansL = start;
                    ansR = len + start;
                }
                char startChar = s.charAt(start);
                Integer integer = appeared.get(startChar);
                if (integer > 0) {
                    appeared.put(startChar, integer - 1);
                }
                //当start增加之后导致check()不满足条件，那么ansL不需要更新
                ++start;
            }


        }
        //假如窗口扩大到最后，还是不能满足全覆盖
        if (ansL == -1) {
            return "";
        }

        String substring = s.substring(ansL, ansR);
        System.out.println("minCoverSubString->" + substring);
        return substring;
    }

    //已经出现的字符是否完全覆盖了原字符集
    private boolean check(Map<Character, Integer> origin, Map<Character, Integer> appeared) {
        Iterator<Character> iterator = origin.keySet().iterator();
        while (iterator.hasNext()) {
            Character key = iterator.next();
            Integer originCount = origin.get(key);
            Integer appearedCount = appeared.get(key);
            if (appearedCount == null || appearedCount < originCount) {
                return false;
            }
        }
        return true;
    }
    //长度最小的子数组https://leetcode-cn.com/problems/minimum-size-subarray-sum/

    /**
     * target = 7, nums = [2,3,1,2,4,3]
     *
     * @param arr    必须都为正数，否则无法用滑动窗口实现
     * @param target
     * @return [4, 3]
     * 注意的点：
     * 1.窗口左边界扩大的时机
     * 2.窗口右边界扩大的时机
     */
    public int minSubArrayLen(int[] arr, int target) {
        //嗅探指针起点
        int start = 0;
        //嗅探指针终点
        int end = 0;
        //窗口的长度
        int len = Integer.MAX_VALUE;
        int sum = 0;
        while (end < arr.length) {
            //如果累加值《
            sum += arr[end];
            while (sum > target) {
                //
                sum -= arr[start];
                start++;
            }
            if (sum == target) {
                len = Math.min(len, (end - start + 1));
            }
            end++;
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }

    //最小区间 https://leetcode-cn.com/problems/smallest-range/
    //最小窗口子序列 https://leetcode-cn.com/problems/minimum-window-subsequence/
    //至多包含两个不同字符的最长子串 https://leetcode-cn.com/problems/longest-substring-with-at-most-two-distinct-characters/

}
