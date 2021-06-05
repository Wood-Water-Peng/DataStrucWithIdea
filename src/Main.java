import arr.ArrDemo;
import arr.ArrDemo2;
import linkList.LinkListDemo;
import linkList.Node;
import linkList.NodeUtil;
import recursive.RecursiveDemo;
import sort.SortDemo;
import sort.SortDemo2;
import sort.SortDemo3;
import sort.SortDemo4;
import stack.StackDemo;
import stack.StackDemo2;
import string.StringDemo;
import string.StringDemo2;
import string.StringDemo3;

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
        int[] arr = {3, 5, 2, 1, 4, 6, 7};
//        SortDemo sortDemo = new SortDemo();
//        sortDemo.quickSort(arr);
//        sortDemo.binarySearch(arr,21);

        SortDemo3 sortDemo3 = new SortDemo3();
//        sortDemo2.mergeSort(arr);
//        sortDemo3.mergeSort(arr);
//        sortDemo2.binarySearch(arr,21);
        sortDemo3.quickSort(arr);
//        sortDemo3.binarySearch(arr, 21);

        StackDemo stackDemo = new StackDemo();
//        stackDemo.baseCalc2("(10-(4-5-2)-3)+(6+8)");
//        stackDemo.baseCalc3(" 2+3 *2/ 2-1 ");
//        stackDemo.baseCalc(" 3 +5 -2+ 1 ");

        ArrDemo arrDemo = new ArrDemo();
//        arrDemo.sortColors2(new int[]{2,0,2,2,2,2,0,1});

        LinkListDemo linkListDemo = new LinkListDemo();
        Node header = NodeUtil.createLinkList(arr);
        NodeUtil.printLinkList(header);

        Node node_3 = NodeUtil.getNode(header, 2);
        Node node_6 = NodeUtil.getNode(header, 7);
        linkListDemo.reverseLinkList(header, node_3, node_6);
//        linkListDemo.reverseLinkList(header);

//        sort();
//        stackDemo();
//        arrDemo();
        stringDemo();
    }

    private static void stringDemo() {
        StringDemo3 stringDemo3 = new StringDemo3();
//        String maxSubSting = stringDemo3.maxSubSting("dbaefgaabccdefg");
//        System.out.println("maxSubSting->" + maxSubSting);
        String result = stringDemo3.minSubStringCoverage("ODE", "ABC");
        System.out.println("result->" + result);
    }

    private static void arrDemo() {
        ArrDemo2 arrDemo2 = new ArrDemo2();
        arrDemo2.sortColors(new int[]{2, 1, 1, 0, 2, 2, 2, 2, 0, 1});
    }

    private static void stackDemo() {
        StackDemo2 stackDemo2 = new StackDemo2();
//        String s = " 3+ 2-4+1 ";
//        int calc = stackDemo2.calc(s);
//        System.out.println("stackDemo2 s:" + s + "---calc->" + calc);
//
//        String s2 = "-(10-(4-5+2)-3)+(6+8)";
//        int calc2 = stackDemo2.calc2(s2);
//
//        System.out.println("stackDemo2 s:" + s2 + "---calc2->" + calc2);

        String s3 = " 3+5 /2/ 5+1";
        int calc3 = stackDemo2.calc3(s3);

        System.out.println("stackDemo2 s:" + s3 + "---calc3->" + calc3);
    }

    private static void sort() {
        int[] arr = {3, 3, 3, 3, 3, 5, 2, 1, 4, 6, 7, 5, 2};
        SortDemo4 sortDemo4 = new SortDemo4();
        sortDemo4.quickSort(arr);

        int right = sortDemo4.binarySearchRight(arr, 3);
        System.out.println("binarySearchRight right->" + right);
    }

}
