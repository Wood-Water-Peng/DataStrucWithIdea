import recursive.RecursiveDemo;
import sort.SortDemo;
import sort.SortDemo2;
import stack.StackDemo;
import string.StringDemo;
import string.StringDemo2;

public class Main {
    public static void main(String[] args) {
        RecursiveDemo recursiveDemo = new RecursiveDemo();
//        recursiveDemo.stepProblem(5);

        //机器人走路问题
//        recursiveDemo.robotWalkProblem(15, 10, 4, 2);
//        recursiveDemo.robotWalkProblemWithCache(15, 10, 4, 2);
//        recursiveDemo.QueueProblemN(8);
//        recursiveDemo.robotWalk2(4, 1, 1, 2, 2, 4);

        StringDemo stringDemo = new StringDemo();
//        stringDemo.digitSumInString("A-1B34--2AS1");
//        stringDemo.digitSumInString("A-1B-34--2AS");
//        stringDemo.digitSumInString("1B-34--2AS");
//        stringDemo.digitSumInString("-B-34--2AS-");
//        stringDemo.wipeKSubstring("abbb333aaaa113222",3);
//        stringDemo.replaceSubstring("abbb1233aaaa1231234","123","abc");
//        stringDemo.statisticsString("aaabbbdfaa");
//        stringDemo.getIndexOfLeftMost(new String[]  {"1",null,null,null,"3","3","3",null,"4","4","5",},"3");
//        stringDemo.reverseString("i pig l oves dog   ");
//        stringDemo.minDistanceInArray(new String[]{"1", null, null, null, "3", "3", "3", null, "4", "4", "5",}, "1", "3");
//        StringDemo2 stringDemo2 = new StringDemo2();
//        stringDemo2.maxNoDuplicatesSubString("aabaa");
//        stringDemo2.minCoverSubString("abca", "abc");
//        stringDemo2.minSubArrayLen(new int[]{2, 3, 1, 2}, 3);
        int[] arr = {20,13,6, 21,21,9,10, 5,21};
//        SortDemo sortDemo = new SortDemo();
//        sortDemo.quickSort(arr);
//        sortDemo.binarySearch(arr,21);

        SortDemo2 sortDemo2 = new SortDemo2();
//        sortDemo2.mergeSort(arr);
        sortDemo2.quickSort(arr);
        sortDemo2.binarySearch(arr,21);

        StackDemo stackDemo = new StackDemo();
//        stackDemo.baseCalc("(10+(4+5+2)-3)+(6+8)");
        stackDemo.baseCalc2("3+2*2/2");
    }

}
