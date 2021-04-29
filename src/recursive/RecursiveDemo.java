package recursive;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//这个类专门处理字符串的问题
//暴力递归方式
//注意：字符串的几个概念  abc
//1.子串： 有序且连续 ab，a,abc,bc
//2.子序列： 有序不一定连续 a,ac,
//3.全排列： 必须用到所有的字符,顺序可以不同   bac,cba
public class RecursiveDemo {
    /**
     * 获取字符串的所有子串
     *
     * @param str
     * @return
     */
    public String[] allSubStrings(String str) {
        List<String> path = new ArrayList<>();
        _processSubString(str, 0, new LinkedList<>(), path);
        return null;
    }

    /**
     * 获取字符串的所有子序列
     * 子序列可以不连续
     *
     * @param str
     * @return
     */
    public String[] allSubSequence(String str) {
        List<String> path = new ArrayList<>();
        _processSubSequence(str, 0, new LinkedList<>(), path);
        return null;
    }

    public int _processSubSequence(String str, int index, LinkedList<String> subStr, List<String> path) {


        if (index == str.length() - 1) {
            return 1;
        }

        int total = 0;
        return total;
    }

    /**
     * 先定义一个递归，他的意义是：
     * 以节点index为起点的子串个数
     * <p>
     * 当我走到index时，会有一个选择，要这个char或者直接返回
     *
     * @param str
     * @param index
     */
    public int _processSubString(String str, int index, LinkedList<String> subStr, List<String> path) {


        if (index == str.length() - 1) {
            return 1;
        }

        int total = 0;
//        total += _processSubString(str, index + 1);
        return total;
    }

    /**
     * @param n
     * @return 斐波那契数列的第n项
     */
    public int fibonacci(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }


    /**
     * 有一个n级的台阶
     * 每次可以走1步或者2步
     *
     * @param n
     * @return 一共有多少种走法
     * <p>
     * 分析：
     * 在当前的台阶这里进行分叉，f(i)=f(i+1)+f(i+2)
     * <p>
     * 3级台阶
     * 1->1->1
     * 1->2
     * 2->1
     */
    public int stepProblem(int n) {
//        int result = _stepProblem3(n);
//        System.out.println("stepProblem ->" + result);
//        return result;

        List<String> path = new ArrayList<>();
        int result = _stepProblem2(n, 0, path, new LinkedList<>());
        for (int j = 0; j < path.size(); j++) {
            System.out.println(path.get(j));
        }
        return result;
    }

    /**
     * @param n
     * @param index 当前的步数
     * @return n
     * /  \
     * n+1    n+2
     * n的可能性=(n+1)的可能性+(n+2)的可能性
     */
    public int _stepProblem(int n, int index) {
        if (index == n) {
            return 1;
        } else if (index > n) {
            return 0;
        }
        return _stepProblem(n, index + 1) + _stepProblem(n, index + 2);
    }

    /**
     * 定义一个递归函数，理解这个递归函数返回值的含义
     * <p>
     * 一维入参的递归，变的只有index
     *
     * @param n     所有的台阶数(不变)
     * @param index 当前的台阶数
     * @param path  跳转index时的路径
     * @param list  跳转到终点时所有的路径集合
     * @return 跳转到index点时所有的可能性
     */
    public int _stepProblem2(int n, int index, List<String> path, LinkedList<String> list) {
        if (index == n) {
            list.add(index + "");
        } else {
            list.add(index + "-");
        }
        if (index == n) {
//            list.add(index + "");
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                builder.append(list.get(i));
            }
            path.add(builder.toString());
            return 1;
        } else if (index > n) {
            //超过了终点，此次跳跃无效
            return 0;
        }
        //跳跃1步
        int one = _stepProblem2(n, index + 1, path, list);
        if (!list.isEmpty())
            list.removeLast();
        //跳跃2步
        int two = _stepProblem2(n, index + 2, path, list);
        if (!list.isEmpty())
            list.removeLast();

        //跳跃3步
        int three = _stepProblem2(n, index + 3, path, list);
        if (!list.isEmpty())
            list.removeLast();
        return one + two + three;
    }

    public int _stepProblem3(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        return _stepProblem3(n - 1) + _stepProblem3(n - 2);
    }


    /**
     * 机器人走路问题
     * 规则如下:
     * 假设在了index=1位置，那么机器人只能向右走一步
     * 假设在了index=n位置，那么机器人只能向左走一步
     * 当index在中间位置,机器人可以左走一步或者右走一步
     * <p>
     * 问：机器人使用count步数走到dest位置的不同路径数
     *
     * @param n     总的台阶数
     * @param count 可以使用的总步数
     * @param dest  目标台阶
     */
    public int robotWalkProblem(int n, int count, int dest, int start) {
        List<String> path = new ArrayList<>();
        long startTime = System.currentTimeMillis();
        int walkProblem = _robotWalkProblem(n, dest, start, count, path, new LinkedList<>());
        for (int j = 0; j < path.size(); j++) {
            System.out.println(path.get(j));
        }
        System.out.println("robotWalkProblem->" + walkProblem + "--耗时:" + (System.currentTimeMillis() - startTime));
        return walkProblem;
    }

    public int robotWalkProblemWithCache(int n, int count, int dest, int start) {
        long startTime = System.currentTimeMillis();
        List<String> path = new ArrayList<>();
        int[][] dp = new int[n + 1][count + 1];
        int walkProblem = _robotWalkProblemCache(n, dest, start, count, path, new LinkedList<>(), dp);
        for (int j = 0; j < path.size(); j++) {
            System.out.println(path.get(j));
        }
        System.out.println("robotWalkProblemWithCache->" + walkProblem + "--耗时:" + (System.currentTimeMillis() - startTime));
        return walkProblem;
    }

    /**
     * 定义一个递归函数，他的返回值表示机器人在index位置时，还剩下rest步数，走到dest位置的可能性
     *
     * @param dest
     * @param index
     * @param rest
     * @return
     */
    public int _robotWalkProblem(int n, int dest, int index, int rest, List<String> path, LinkedList<String> list) {
        if (rest == 0) {
            list.add(index + "");
            if (index == dest) {
                //添加有效路径
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < list.size(); i++) {
                    builder.append(list.get(i));
                }
                path.add(builder.toString());
                return 1;
            } else {
                return 0;
            }
        } else {
            list.add(index + "-");
            if (index == 1) {
                int right = _robotWalkProblem(n, dest, index + 1, rest - 1, path, list);
                if (!list.isEmpty())
                    list.removeLast();
                return right;
            } else if (index == n) {
                int left = _robotWalkProblem(n, dest, index - 1, rest - 1, path, list);
                if (!list.isEmpty())
                    list.removeLast();
                return left;
            } else {
                int right = _robotWalkProblem(n, dest, index + 1, rest - 1, path, list);
                if (!list.isEmpty())
                    list.removeLast();
                int left = _robotWalkProblem(n, dest, index - 1, rest - 1, path, list);
                if (!list.isEmpty())
                    list.removeLast();
                return left + right;
            }
        }
    }

    /**
     * 进阶版，处理重复问题
     * dp[index][rest]  其他的参数不变，只有index和rest在变化，我们将dp[index][rest]的值缓存
     *
     * @param n
     * @param dest
     * @param index
     * @param rest
     * @param path
     * @param list
     * @return
     */
    public int _robotWalkProblemCache(int n, int dest, int index, int rest, List<String> path, LinkedList<String> list, int[][] dp) {
        if (rest == 0) {
            list.add(index + "");
            if (index == dest) {
                //添加有效路径
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < list.size(); i++) {
                    builder.append(list.get(i));
                }
                path.add(builder.toString());
                dp[index][rest] = 1;
                return 1;
            } else {
                return 0;
            }
        } else {
            list.add(index + "-");
            if (index == 1) {
                int right = _robotWalkProblem(n, dest, index + 1, rest - 1, path, list);
                if (!list.isEmpty())
                    list.removeLast();
                dp[index][rest] = right;
                return right;
            } else if (index == n) {
                int left = _robotWalkProblem(n, dest, index - 1, rest - 1, path, list);
                if (!list.isEmpty())
                    list.removeLast();
                dp[index][rest] = left;
                return left;
            } else {
                int right;
                if (dp[index][rest] > 0) {
                    right = dp[index][rest];
                } else {
                    right = _robotWalkProblem(n, dest, index + 1, rest - 1, path, list);
                }
                if (!list.isEmpty())
                    list.removeLast();
                int left;
                if (dp[index][rest] > 0) {
                    left = dp[index][rest];
                } else {
                    left = _robotWalkProblem(n, dest, index - 1, rest - 1, path, list);
                }
                if (!list.isEmpty())
                    list.removeLast();
                return left + right;
            }
        }
    }

    /**
     * N皇后问题
     * 1.横向、纵向、对角线没有冲突的
     *
     * @param n
     * @return
     */
    public int QueueProblemN(int n) {
        boolean[][] queues = new boolean[n][n];
        int result = _QueueProblemN(n, 0, queues);
        System.out.println("QueueProblemN->" + result);
        return result;
    }


    /**
     * 递归的含义：
     * <p>
     * 将皇后放在row行的所有可能性
     *
     * @param row    当前的行数
     * @param n      总行数
     * @param queues 从0...n-1已经摆放的皇后
     * @return
     */
    public int _QueueProblemN(int n, int row, boolean[][] queues) {
        if (row == n) {
            //row 0...n-1，如果row到了n位置，说明之前的0...n-1行已经摆好了皇后
            //说明已经全部摆放好了，此时算作一种成功的方式
            return 1;
        }
        //row行摆放皇后满足条件的总和，这个总和=每一列摆放皇后且满足条件的总和
        int res = 0;
        for (int i = 0; i < n; i++) {
            //从第一列开始尝试
            if (_isSafe(row, i, queues)) {
                queues[row][i] = true;
                res += _QueueProblemN(n, row + 1, queues);
                queues[row][i] = false;
            }
        }
        return res;

    }

    /**
     * @param row    当前行 0...n-1
     * @param column
     * @param queues 棋盘
     * @return
     */
    public boolean _isSafe(int row, int column, boolean[][] queues) {
        //判断当前的位置是否满足摆放条件
        for (int i = 0; i < row; i++) {
            if (queues[i][column])  //列冲突
                return false;
        }
        //左上角对角线
        for (int i = row, j = column; i >= 0 && j >= 0; j--, i--) {
            if (queues[i][j]) {
                return false;
            }
        }
        //右上角对角线
        for (int i = row, j = column; i >= 0 && j < queues.length; j++, i--) {
            if (queues[i][j]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 假设有一个n乘n的棋盘，机器人从起点开始，只能向下走或者向右走，问走到(row,col)位置的可能性
     */
    public int robotWalk(int n, int row, int col) {
        if (row > n || col >= n) return 0;

        LinkedList<String> path = new LinkedList<>();
        List<String> total = new ArrayList<>();
        int result = _robotWalk(n, 0, 0, row, col, path, total);
        System.out.println("robotWalk->" + result);
        for (int j = 0; j < total.size(); j++) {
            System.out.println(total.get(j));
        }
        return result;
    }


    /**
     * 先定义一个递归函数，确定返回值得含义
     * <p>
     * 在int[][] cur的时候，到达目标的可能性
     *
     * @param n
     * @return
     */
    public int _robotWalk(int n, int curX, int curY, int destX, int destY, LinkedList<String> path, List<String> total) {
        path.add(String.format("(%s,%s)-", curX, curY));
        if (curX == destX && curY == destY) {
            //到达目标
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < path.size(); i++) {
                builder.append(path.get(i));
            }
            total.add(builder.toString());
            return 1;
        }
        if (curX > destY || curY > destY) {
            if (!path.isEmpty()) {
                path.removeLast();
            }
            return 0;
        }
        if (curX == destX) {
            int i = _robotWalk(n, curX, curY + 1, destX, destY, path, total);
            if (!path.isEmpty()) {
                path.removeLast();
            }
            return i;
        } else if (curY == destY) {
            int i = _robotWalk(n, curX + 1, curY, destX, destY, path, total);
            if (!path.isEmpty()) {
                path.removeLast();
            }
            return i;
        }
        int left = _robotWalk(n, curX + 1, curY, destX, destY, path, total);
        if (!path.isEmpty()) {
            path.removeLast();
        }
        int top = _robotWalk(n, curX, curY + 1, destX, destY, path, total);
        if (!path.isEmpty()) {
            path.removeLast();
        }
        return left + top;
    }


    /**
     * 假设有一个n乘n的棋盘，机器人从某点开始，可以走m步，每次可以走一步，问走到(row,col)位置的可能性
     *
     * @param count 可以走的总步数
     */
    public int robotWalk2(int n, int startX, int startY, int destX, int destY, int count) {
        if (startX > n || startX >= n || destX > n || destY > n) return 0;

        LinkedList<String> path = new LinkedList<>();
        List<String> total = new ArrayList<>();
        int result = _robotWalk2(n, startY, startY, destX, destY, path, total, count);
        System.out.println("robotWalk->" + result);
        for (int j = 0; j < total.size(); j++) {
            System.out.println(total.get(j));
        }
        return result;
    }

    /**
     * @param n
     * @param curX
     * @param curY
     * @param destX
     * @param destY
     * @param path
     * @param total
     * @param rest  剩下可以走的步数
     * @return 进阶--增加缓存
     * 当curX,curY和rest都相同时，可以使用缓存
     */
    public int _robotWalk2(int n, int curX, int curY, int destX, int destY, LinkedList<String> path, List<String> total, int rest) {
        path.add(String.format("(%s,%s)-", curX, curY));

        if (rest == 0) {
            if (curX == destX && curY == destY) {
                //到达目标
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < path.size(); i++) {
                    builder.append(path.get(i));
                }
                total.add(builder.toString());
                return 1;
            }
            return 0;
        } else {
            //还可以继续走
            if (curX < 0 || curY < 0 || curY == n || curX == n) {
                return 0;
            }

            int left = _robotWalk2(n, curX, curY - 1, destX, destY, path, total, rest - 1);
            if (!path.isEmpty()) {
                path.removeLast();
            }
            int right = _robotWalk2(n, curX, curY + 1, destX, destY, path, total, rest - 1);
            if (!path.isEmpty()) {
                path.removeLast();
            }
            int top = _robotWalk2(n, curX + 1, curY, destX, destY, path, total, rest - 1);
            if (!path.isEmpty()) {
                path.removeLast();
            }
            int bottom = _robotWalk2(n, curX - 1, curY, destX, destY, path, total, rest - 1);
            if (!path.isEmpty()) {
                path.removeLast();
            }
            return left + right + top + bottom;
        }

    }
}
