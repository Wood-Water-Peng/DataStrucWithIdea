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
     * 当字符变化时他连续出现的次数
     */
    public String wipeKSubstring(String str, int k) {
        if (str == null) return null;
        if (k > str.length()) return str;
        char[] chars = str.toCharArray();
        char cur = chars[0];
        int count = 0;
        int startIndex = -1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == cur) {
                count++;
                if (i == chars.length - 1 && count == k) {
                    //处理最后一个字符
                    for (int j = startIndex; j < chars.length; j++) {
                        chars[j] = 0;
                    }
                }
            } else {
                //获取count
                if (count == k) {
                    //[startIndex...i-1]
                    for (int j = startIndex; j < i; j++) {
                        chars[j] = 0;
                    }
                }

                cur = chars[i];
                count = 1;
                startIndex = i;
            }
        }
        String result = String.copyValueOf(chars);
        System.out.println("string ->" + result);
        return result;
    }

    /**
     * 替换字符串中出现的特定字符，如果该字符连续出现，那么仅替换一次
     * from=abc to=456
     * 123abc-->123456
     * 123abcabc-->123456
     * <p>
     * 关键变量：startIndex
     *
     * @return
     */
    public String replaceSubstring(String str, String from, String to) {
        char[] chars = str.toCharArray();
        char[] fromArray = from.toCharArray();
        int matchIndex = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == fromArray[matchIndex]) {
                if (matchIndex == fromArray.length - 1) {
                    //已经到达了最后一个char
                    for (int j = i; j >= i - matchIndex; j--) {
                        chars[j] = 0;
                    }
                    matchIndex = 0;
                } else {
                    matchIndex++;
                }
            } else {
                matchIndex = 0;
            }
        }
        //将char=0的字符替换成to
        String result = "";
        matchIndex = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 0) {
                if (matchIndex < to.length()) {
                    result += to.charAt(matchIndex);
                }
                matchIndex++;
            } else {
                matchIndex = 0;
                result += chars[i];
            }
        }
        System.out.println("replaceSubstring ->" + result);
        return result;
    }


    /**
     * 返回字符串的统计字符串
     *
     * @param str aaabbbdfaa
     * @return a_3_b_3_1_1_2_1_3_1
     */
    public String statisticsString(String str) {
        char[] chars = str.toCharArray();
        char startChar = chars[0];
        int count = 0;
        String res = "";
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == startChar) {
                count++;
            } else {
                //开始统计
                res += startChar + "_" + count + "_";
                startChar = chars[i];
                count = 1;
            }
            //处理结尾
            if (i == chars.length - 1) {
                res += startChar + "_" + count;
            }
        }
        System.out.println("statisticsString->" + res);
        return res;
    }

    /**
     * list中的字符串按字典顺序从小到大排列，可能会有null
     *
     * @param list   {"1",null,null,null,"3","3","3",null,"4","4","5",}
     * @param target
     * @return target在list中最左的位置
     * <p>
     * 二分查找
     */
    public int getIndexOfLeftMost(String[] list, String target) {
        int start = 0;
        int end = list.length - 1;
        int index = -1;
        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (list[middle] == null) {
                //此时我并不知道target在左半球或者右半区，此时的场景其实是将原数组分成了两截，需要分别对左边和右边的数组进行查找
                //[middle-1...start]遍历查找
                boolean isLeftEmpty = true;
                for (int i = middle - 1; i >= start; i++) {
                    if (list[i] != null) {
                        if (list[i].compareTo(target) > 0) {
                            //左半区找
                            end = i - 1;
                        } else if (list[i].compareTo(target) < 0) {
                            //右半区找
                            isLeftEmpty = true;
                            break;
                        } else {
                            index = i;
                            end = i - 1;
                        }
                        isLeftEmpty = false;
                        break;
                    }
                }
                if (isLeftEmpty) {
                    //采用二分法去右边找
                    start = middle + 1;
                }
            } else {
                if (list[middle].equals(target)) {
                    //使用二分继续向左找
                    index = middle;
                    end = middle - 1;
                } else {
                    //比较list[middle]和target的大小
                    if (list[middle].compareTo(target) > 0) {
                        //左半区找
                        end = middle - 1;
                    } else {
                        //右半区找
                        start = middle + 1;
                    }
                }
            }
        }
        System.out.println("getIndexOfLeftMost->" + index);
        return index;
    }

    /**
     * 将字符串逆序，做到单词间逆序
     *
     * @param str pig loves dog
     * @return dog loves pig
     * 思路:
     * <p>
     * 1.先将整个字符串逆序，然后将具体的单词逆序
     */
    public String reverseString(String str) {
        char[] chars = str.toCharArray();
        _reverseCharList(chars, 0, chars.length);
        int startIndex = -1;
        //对具体的单词逆序
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                if (startIndex == -1)
                    startIndex = i;
            } else {
                //将[startIndex...i-1]这个单词翻转
                if (startIndex != -1) {
                    _reverseCharList(chars, startIndex, i);
                }
                startIndex = -1;
            }
        }
        if (startIndex != -1) {
            _reverseCharList(chars, startIndex, chars.length);
        }
        String result = String.copyValueOf(chars);
        System.out.println("reverseString->" + result);
        return result;
    }

    private void _reverseCharList(char[] chars, int start, int end) {
        int middle = start + (end - start) / 2;
        for (int i = start; i < middle; i++) {
            char tmp = chars[i];
            chars[i] = chars[end - 1 - i + start];
            chars[end - 1 - i + start] = tmp;
        }
    }

    /**
     * 将size大小的左半区整体移动到右半区
     *
     * @param list [a,b,c,d,e]  size=3
     * @return [d, e, a, b, c]
     * 要求时间复杂度为O(n)   空间复杂度为O(1)
     * <p>
     * 套路方法：
     * 1.先将[0,size-1]逆序
     * 2.再将[size...]逆序
     * 3.最后将整体逆序
     */
    public char[] reverseCharList(char[] list, int size) {
        _reverseCharList(list, 0, size);
        _reverseCharList(list, size, list.length);
        _reverseCharList(list, 0, list.length);
        String result = String.copyValueOf(list);
        System.out.println("reverseCharList->" + result);
        return list;
    }

    /**
     * @param strings
     * @param str1
     * @param str2
     * @return str1和str2在数组中的最短距离
     */
    public int minDistanceInArray(String[] strings, String str1, String str2) {
        int lastStr1 = -1;
        int lastStr2 = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < strings.length; i++) {
            if (strings[i] == null) continue;
            if (strings[i].equals(str1)) {
                lastStr1 = i;
                if (lastStr2 != -1) {
                    min = Math.min(min, lastStr1 - lastStr2);
                }
            } else if (strings[i].equals(str2)) {
                lastStr2 = i;
                if (lastStr1 != -1) {
                    min = Math.min(min, lastStr2 - lastStr1);
                }
            }
        }
        System.out.println("minDistanceInArray->" + min);
        return min;
    }

    /**
     * (())
     * ())
     * (()
     * ()()
     *
     * @param str
     * @return 最长的有效括号子串, 子串必须是连续的
     * <p>
     * 暴力递归
     * <p>
     * 先定义一个递归函数，并确定他的含义
     */
    public String maxValidateBrackets(String str) {
        return null;
    }

    /**
     * @param chars
     * @param index
     * @return [0...index-1]中有效括号的长度
     */
    public int _maxValidateBrackets(char[] chars, int index) {
        int count = 0;
        if (chars[index] == ')') {
            if (chars[index - 1] == '(') {
                count = 1;
                return count + _maxValidateBrackets(chars, index - 2);
            }
        }
        return 0;
    }
}
