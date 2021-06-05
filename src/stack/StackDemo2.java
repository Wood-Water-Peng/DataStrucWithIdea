package stack;

import java.util.Stack;

public class StackDemo2 {
    /**
     * 只有加减和' '的计算器
     *
     * @param str
     * @return 2+321 -10
     * <p>
     * 不需要栈，直接根据运算符计算
     */
    public int calc(String str) {
        int sum = 0;
        int opt = 1;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - '0';
            if (index >= 0 && index <= 9) {
                //是数字
                int cur = 0;
                while (i < chars.length && chars[i] - '0' >= 0 && chars[i] - '0' <= 9) {
                    cur += 10 * cur + (chars[i] - '0');
                    i++;
                }
                sum += opt * cur;
            }
            if (i < chars.length) {
                if (chars[i] == '-') {
                    opt = -1;
                } else if (chars[i] == '+') {
                    opt = 1;
                }
            }
        }
        return sum;
    }

    /**
     * 基本计算器
     * https://leetcode-cn.com/problems/basic-calculator/
     * <p>
     * 由数字、'+'、'-'、'('、')'、和 ' ' 组成
     * 输入：s = "-(10-(4-5+2)-3)+(6+8)"
     * 输出：32
     * <p>
     * 栈里面只保存操作符
     * 思路：
     * 1.什么时候计算？  数字结束的时候进行计算
     * 2.什么时候压栈？
     * <p>
     * 计算时的操作符由栈顶的操作符和上一个操作符决定
     * 有了括号之后，括号外层的操作符需要被保存，括号中计算出来的结果需要加上操作符
     */
    public int calc2(String str) {
        Stack<Integer> opts = new Stack<>();
        char[] chars = str.toCharArray();
        int sum = 0;
        //上一个操作符
        int lastOpt = 1;
        opts.push(lastOpt);
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] - '0' >= 0 && chars[i] - '0' <= 9) {
                int cur = 0;
                while (i < chars.length && chars[i] - '0' >= 0 && chars[i] - '0' <= 9) {
                    cur = cur * 10 + chars[i] - '0';
                    i++;
                }
                //此时数字结束，需要计算
                sum += cur * lastOpt;
            }

            if (i >= chars.length) {
                break;
            }

            switch (chars[i]) {
                case '(':
                    opts.push(lastOpt);
                    break;
                case ')':
                    opts.pop();
                    break;
                case '+':
                    lastOpt = opts.peek();
                    break;
                case '-':
                    lastOpt = -opts.peek();
                    break;
            }

        }

        return sum;
    }

    /**
     * https://leetcode-cn.com/problems/basic-calculator-ii/
     *
     * @param str
     * @return 减加乘除和数字
     * <p>
     * 输入：s = " 3+5 *2/ 2+1"
     * 输出：5
     * <p>
     * 思路:
     * 1.如果是数字，直接压栈(带上操作符)
     * 2.在数字结束的时候，判断上一个操作符，如果是乘除计算，将结果压栈，然后将栈中所有的元素求和
     */
    public int calc3(String str) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        char[] chars = str.toCharArray();
        char lastOpt = '+';
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] - '0' >= 0 && chars[i] - '0' <= 9) {
                int cur = 0;
                while (i < chars.length && chars[i] - '0' >= 0 && chars[i] - '0' <= 9) {
                    cur = cur * 10 + chars[i] - '0';
                    i++;
                }
                //此时数字结束，需要计算
                if (lastOpt == '*') {
                    stack.push(stack.pop() * cur);
                } else if (lastOpt == '/') {
                    stack.push(stack.pop() / cur);
                } else if (lastOpt == '+') {
                    stack.push(cur);
                } else if (lastOpt == '-') {
                    stack.push(-cur);
                }

            }
            if (i == chars.length) {
                //进行计算
                while (!stack.isEmpty()) {
                    sum += stack.pop();
                }
            } else {
                if (chars[i] == ' ') {
                    continue;
                } else {
                    lastOpt = chars[i];
                }
            }
        }
        return sum;
    }
}
