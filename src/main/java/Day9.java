/**
 * 题目：合并两个有序链表
 * 题目描述：
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class Day9 {
    static class Node{
        int val;
        Node next;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }
    }

    public static Node mergeTwoSortedList(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return null;
        }
        if (node1 == null) {
            return node2;   // node2 肯定不为空
        }
        if (node2 == null) {
            return node1;   // node1 肯定不为空
        }

        // 初始化，合并后链表的第一个节点。
        Node resNode = new Node();
        if (node1.val <= node2.val) {
            resNode.val = node1.val;
            node1 = node1.next;
        } else {
            resNode.val = node2.val;
            node2 = node2.next;
        }

        // tempNode 节点，进行遍历操作
//        Node tempNode = new Node();
//        resNode.next = tempNode;
//        while (node1 != null && node2 != null) {
//            if (node1.val <= node2.val) {
//                tempNode.val = node1.val;
//                tempNode.next = new Node();
//                tempNode = tempNode.next;
//                node1 = node1.next;
//            } else {
//                tempNode.val = node2.val;
//                tempNode.next = new Node();
//                tempNode = tempNode.next;
//                node2 = node2.next;
//            }
//        }
        Node preNode = resNode; //前一Node
        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                Node tempNode = new Node(node1.val);
                preNode.next = tempNode;
                preNode = tempNode;
                node1 = node1.next;
            } else {
                Node tempNode = new Node(node2.val);
                preNode.next = tempNode;
                preNode = tempNode;
                node2 = node2.next;
            }
        }

        // node1 链表遍历完了，把 node2 链表剩余的元素加上去就好
        if (node2 != null) {
            preNode.next = node2;
        }
        // node2 链表遍历完了，把 node1 链表剩余的元素加上去就好
        if (node1 != null) {
            preNode.next = node1;
        }
//        // 最后将 tempNode.next 节点由 new Node() 改为 null，否则还是有这个节点的，int属性默认值为0。
//        tempNode.next = null;

        return resNode;
    }


    public static void main(String[] args) {
        Node node1 = new Node(1);
        node1.next = new Node(2);
        node1.next.next = new Node(4);
        Node tempNode1 = node1;
        while (tempNode1 != null) {
            System.out.print(tempNode1.val + " --> ");
            tempNode1 = tempNode1.next;
        }
        System.out.println();

        Node node2 = new Node(1);
        node2.next = new Node(3);
        node2.next.next = new Node(4);
        Node tempNode2 = node2;
        while (tempNode2 != null) {
            System.out.print(tempNode2.val + " --> ");
            tempNode2 = tempNode2.next;
        }
        System.out.println();

        Node node = mergeTwoSortedList(node1, node2);
        while (node != null) {
            System.out.print(node.val + " --> ");
            node = node.next;
        }
    }

}
