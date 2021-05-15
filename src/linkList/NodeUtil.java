package linkList;

public class NodeUtil {


    public static Node createLinkList(int[] arr) {
        if (arr == null || arr.length == 0) return null;

        Node header = new Node(arr[0]);
        Node cur = header;
        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i]);
            cur.next = newNode;
            cur = newNode;
        }
        return header;
    }

    public static void printLinkList(Node header) {
        Node cur = header;
        StringBuilder sb = new StringBuilder();
        while (cur != null) {
            sb.append(cur.val);
            sb.append("-");
            cur = cur.next;
        }
        System.out.println(sb
                .toString());
    }


    public static Node getNode(Node header, int val) {
        Node cur = header;
        while (cur != null) {
            if (cur.val == val) {
                break;
            }
            cur = cur.next;
        }
        return cur;
    }
}
