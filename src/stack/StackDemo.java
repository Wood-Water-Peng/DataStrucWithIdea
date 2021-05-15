package stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 栈相关  --字符串相关的运算符操作
 */
public class StackDemo {
    /**
     * 基本计算器
     * https://leetcode-cn.com/problems/basic-calculator/
     * <p>
     * 由数字、'+'、'-'、'('、')'、和 ' ' 组成
     * 输入：s = "(10-(4-5+2)-3)+(6+8)"
     * 输出：32
     * <p>
     * 栈里面只保存操作符
     * 思路：
     * 1.什么时候计算？  数字结束的时候进行计算
     * 2.什么时候压栈？
     * <p>
     * 计算时的操作符由栈顶的操作符和上一个操作符决定
     */

    public int baseCalc2(String str) {
        int sum = 0;
        Stack<Integer> ops = new Stack<>();
        int preSign = 1;
        ops.push(preSign);
        int index = 0;
        int cur = 0;
        while (index < str.length()) {
            char c = str.charAt(index);
            if (isDigit(c)) {
                while (index < str.length() && isDigit(str.charAt(index))) {
                    cur = cur * 10 + str.charAt(index) - '0';
                    index++;
                }
            } else {
                //计算
                sum += cur * preSign;
                //非数字
                switch (c) {
                    case '(':
                        ops.push(preSign);
                        break;
                    case ')':
                        ops.pop();
                        break;
                    case '+':
                        preSign = ops.peek();
                        break;
                    case '-':
                        preSign = -ops.peek();
                        break;
                }
                cur = 0;
                index++;
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

    public int baseCalc3(String str) {
        int index = 0;
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        char preOps = '+';
        int cur = 0;
        while (index < str.length()) {
            char charAt = str.charAt(index);
            if (charAt == ' ' && index < str.length()) {
                index++;
                continue;
            }
            if (isDigit(charAt)) {
                while (index < str.length() && isDigit(str.charAt(index))) {
                    cur = cur * 10 + str.charAt(index) - '0';
                    index++;
                }
            }
            //执行计算
            switch (preOps) {
                case '+':
                    stack.push(cur);
                    break;
                case '-':
                    stack.push(-cur);
                    break;
                case '*':
                    stack.push(stack.pop() * cur);
                    break;
                case '/':
                    stack.push(stack.pop() / cur);
                    break;
            }

            if (index < str.length()&&str.charAt(index)!=' ') {
                preOps = str.charAt(index);
                index++;
                cur = 0;
            }
        }
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }

    /**
     * 只有加减和' '的计算器
     *
     * @param str
     * @return 2+321-10
     * <p>
     * 不需要栈，直接根据运算符计算
     */
    public int baseCalc(String str) {
        int sum = 0;
        int index = 0;
        int preSign = 1;
        int cur = 0;
        while (index < str.length()) {
            char charAt = str.charAt(index);
            if (charAt == ' ' && index < str.length()) {
                index++;
                continue;
            }
            if (isDigit(charAt)) {
                //找出数字
                while (index < str.length() && isDigit(str.charAt(index))) {
                    cur = cur * 10 + str.charAt(index) - '0';
                    index++;
                }
            }
            sum += preSign * cur;
            if (index == str.length()) {

            } else {
                charAt = str.charAt(index);
                if (charAt == '+') {
                    preSign = 1;
                } else if (charAt == '-') {
                    preSign = -1;
                }
                cur = 0;
            }

            index++;
        }
        return sum;
    }

    private boolean isDigit(char c) {
        return (c - '0' >= 0 && c - '0' <= 9);
    }
}
