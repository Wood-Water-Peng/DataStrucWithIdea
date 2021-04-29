package string;

import java.util.HashMap;
import java.util.Map;

public class StringDemo {
    /**
     * 判断两个字符串是否为变形词
     * 即出现的字符类型一样且数量一样
     */
    public boolean isStringDeformation(String str1, String str2) {
        if (str1 == null && str2 != null) return false;
        if (str1 != null && str2 == null) return false;
        if (str1 == null && str2 == null) return true;
        if (str1.length() != str2.length()) return false;

        //记录字符出现的个数
        HashMap<Character, Integer> counts = new HashMap<>();

        for (int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i);
            Integer integer = counts.get(c);
            counts.put(c, integer + 1);
        }

        for (int i = 0; i < str2.length(); i++) {
            char c = str2.charAt(i);
            Integer integer = counts.get(c);
            integer--;
            if (integer < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * AB-1C25      结果是24
     * 1B-34--2AS
     * --连续出现为偶数  则符号为正，否则符号为负
     * 字符串中的数字求和
     * <p>
     * 思路：定义三个变量
     * <p>
     * res 累加和
     * num 当前的数字
     * pos 当前数字的符号
     */
    public int digitSumInString(String str) {
        char[] chars = str.toCharArray();
        int res = 0;
        int num = 0;
        boolean pos = true;
        for (int i = 0; i < chars.length; i++) {
            int cur = chars[i] - '0';
            //'0'-'9'
            if (cur >= 0 && cur <= 9) {
                num = num * 10 + (pos ? cur : -cur);
            } else {
                //其他字符，执行计算操作
                res += num;
                num = 0;
                if (chars[i] == '-') {
                    //根据-之前的字符判断
                    if (i - 1 > -1 && chars[i - 1] == '-') {
                        pos = !pos;
                    } else {
                        pos = false;
                    }

                } else {
                    pos = true;
                }
            }
        }
        res += num;
        System.out.println("digitSumInString ->" + res);
        return res;
    }

    /**
     * 去掉字符串中连续出现k次的子串,返回新的字符串
     * 注意:连续出现k次以上的不能去除
     * <p>
     * A000B00C000D-->AB00CD  去掉连续出现3次的子串
     */
    public String wipeKSubstring(String str, int k) {
        if (str == null) return null;
        if (k > str.length()) return str;
        char[] chars = str.toCharArray();
        Map<Integer,Integer> pairs=new HashMap<>();
        char cur = chars[0];
        int count = 0;
        int startIndex = -1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == cur) {
                count++;
                if (count ==k){
                    if(i+1>=chars.length){
                        //有效

                    }else {

                    }
                }
            } else {
                cur = chars[i];
                count = 1;
                startIndex = i;
            }
        }
        return null;
    }
}
