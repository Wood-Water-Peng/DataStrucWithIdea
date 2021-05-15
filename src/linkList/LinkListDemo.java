package linkList;

public class LinkListDemo {

    public void reverseLinkList(Node header) {
        if (header == null || header.next == null) return;
        //递归方式
//        Node newHeader = _reverseLinkList(header);

        Node cur = header;
        Node newHeader = null;
        Node preNode = null;
        while (cur != null) {
            if (cur.next == null) {
                newHeader = cur;
                newHeader.next = preNode;
                cur = null;
            } else {
                Node tmp = cur.next;
                cur.next = preNode;
                preNode = cur;
                cur = tmp;
            }
        }
        NodeUtil.printLinkList(newHeader);

    }


    public Node _reverseLinkList(Node node) {
        if (node == null) {
            return node;
        }
        Node newHeader = _reverseLinkList(node.next);
        if (node.next != null) {
            node.next.next = node;
        }
        node.next = null;
        if (newHeader == null) return node;
        return newHeader;
    }


    /**
     * 翻转[start,end]之间的节点
     *
     * @param node
     * @param start
     * @param end
     * @return
     */
    public Node reverseLinkList(Node node, Node start, Node end) {
        Node cur = node;
        Node preNode = null;
        Node nodeBeforeStart = null;
        while (cur != null) {
            if (cur.next == start) {
                nodeBeforeStart = cur;
            }
            if (cur == start) {
                preNode = cur;
                cur = cur.next;
                continue;
            }

            if (cur == end) {
                Node tmp = end.next;
                end.next = preNode;
                if (nodeBeforeStart == null) {
                    node = end;
                } else {
                    nodeBeforeStart.next = end;
                }
                start.next = tmp;
                break;
            } else {
                Node tmp = cur.next;
                cur.next = preNode;
                preNode = cur;
                cur = tmp;
            }
        }
        NodeUtil.printLinkList(node);
        return node;
    }
}
