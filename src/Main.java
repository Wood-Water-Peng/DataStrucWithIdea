import recursive.RecursiveDemo;
import string.StringDemo;

public class Main {
    public static void main(String[] args) {
        RecursiveDemo recursiveDemo = new RecursiveDemo();
//        recursiveDemo.stepProblem(5);

        //机器人走路问题
//        recursiveDemo.robotWalkProblem(15, 10, 4, 2);
//        recursiveDemo.robotWalkProblemWithCache(15, 10, 4, 2);
//        recursiveDemo.QueueProblemN(8);
        recursiveDemo.robotWalk2(4, 1, 1, 2, 2, 4);

        StringDemo stringDemo = new StringDemo();
        stringDemo.digitSumInString("A-1B34--2AS1");
        stringDemo.digitSumInString("A-1B-34--2AS");
        stringDemo.digitSumInString("1B-34--2AS");
        stringDemo.digitSumInString("-B-34--2AS-");
    }
}
