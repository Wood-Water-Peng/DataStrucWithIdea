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
     * 输入：s = "(10+(4+5+2)-3)+(6+8)"
     * 输出：32
     */


    public int baseCalc(String arr) {
        int sign = 1;
        int sum = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(sign);
        int i = 0;
        while (i < arr.length()) {
            if (arr.charAt(i) == ' ') {
                i++;
            } else if (arr.charAt(i) == '+') {
                sign = stack.peek();
                i++;
            } else if (arr.charAt(i) == '-') {
                sign = -stack.peek();
                i++;
            } else if (arr.charAt(i) - '0' >= 0 && arr.charAt(i) - '0' <= 9) {
                //数字
                long tmp = 0;
                while (i < arr.length() && Character.isDigit(arr.charAt(i))) {
                    tmp = tmp * 10 + (arr.charAt(i) - '0');
                    i++;
                }
                sum += tmp * sign;
            } else if (arr.charAt(i) == '(') {
                stack.push(sign);
                i++;
            } else if (arr.charAt(i) == ')') {
                stack.pop();
                i++;
            }
        }
        System.out.println("baseCalc result->" + sum);
        return sum;
    }

    /**
     * https://leetcode-cn.com/problems/basic-calculator-ii/
     *
     * @param arr
     * @return 减加乘除和数字
     * <p>
     * 输入：s = " 3+5 / 2 "
     * 输出：5
     * <p>
     * 思路:
     * 1.先做乘除计算，将结果压栈，然后将栈中所有的元素求和
     */
    public int baseCalc2(String arr) {
        char preSign = '+';
        int i = 0;
        int num = 0;
        Stack<Integer> stack = new Stack<>();
        while (i < arr.length()) {
            char charAt = arr.charAt(i);
            if (charAt - '0' >= 0 && charAt - '0' <= 9) {
                num = num * 10 + charAt - '0';
            }

            if (charAt - '0' < 0 || charAt - '0' > 9) {
                {
                    switch (preSign) {
                        case '+':
                            stack.push(num);
                            break;
                        case '-':
                            stack.push(-num);
                            break;
                        case '*':
                            stack.push(stack.pop() * num);
                            break;
                        case '/':
                            stack.push(stack.pop() / num);
                            break;
                    }
                    preSign = charAt;
                    num = 0;
                }
            }
            i++;
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        System.out.println("baseCalc2 result->" + sum);
        return sum;
    }
}
