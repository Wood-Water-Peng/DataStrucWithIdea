import arr.ArrDemo;
import linkList.LinkListDemo;
import linkList.Node;
import linkList.NodeUtil;
import recursive.RecursiveDemo;
import sort.SortDemo;
import sort.SortDemo2;
import sort.SortDemo3;
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
        int[] arr = {3,5,2,1,4,6,7};
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
        linkListDemo.reverseLinkList(header,node_3,node_6);
//        linkListDemo.reverseLinkList(header);
    }

}
