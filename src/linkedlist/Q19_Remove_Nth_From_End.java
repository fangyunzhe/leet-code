package linkedlist;

/**
 * @Author fyz
 * @Date 2020/6/8 10:57
 * <p>
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * 你能尝试使用一趟扫描实现吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 **/
public class Q19_Remove_Nth_From_End {

    /**
     * 两次遍历
     * 第一次遍历计算链表的长度，计算出要删除节点的前置节点的位置，delIndex = length - n + 1
     * 第二次遍历到要删除节点的前置节点进行删除操作
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode current = head;
        int length = 0;
        while (current != null) {
            length++;
            current = current.next;
        }
        // 删除节点的前置节点的位置，遍历到该节点进行删除
        int delNodePreIndex = length - n;
        ListNode first = dummyHead;
        // length = 5, n = 2, delNodePreIndex = 3
        // 第一次循环：delNodePreIndex = 2，first = 第1个节点
        // 第二次循环：delNodePreIndex = 1, first = 第2个节点
        // 第三次循环：delNodePreIndex = 0，first = 第3个节点
        while (delNodePreIndex > 0) {
            delNodePreIndex--;
            first = first.next;
        }
        first.next = first.next.next;
        return dummyHead.next;
    }

    /**
     * 一次遍历，两个节点
     * 第一个节点从第n个节点开始遍历，第二个节点从头开始，
     * 同时移动，当第一个节点到达尾部时，第一个节点到达要删除节点当前置节点
     * 在要删除节点当前置节点进行删除操作
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode first = dummyHead;
        ListNode second = dummyHead;
        // 共5个节点，n = 2
        // 第一次循环，i = 0, first = 第1个节点
        // 第二次循环，i = 1, first = 第2个节点
        for (int i = 0; i < n; i++) {
            first = first.next;
        }

        // 第1次循环，first = 第3个节点，second = 第1个节点
        // 第2次循环，first = 第4个节点，second = 第2个节点
        // 第3次循环，first = 第5个节点，second = 第3个节点
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        // 在第三个节点处删除第四个节点
        second.next = second.next.next;
        return dummyHead.next;
    }


    public static void main(String[] args) {
        ListNode dummyHead = new ListNode(0);
        ListNode head = new ListNode(1);
        dummyHead.next = head;
        for (int i = 1; i < 5; i++) {
            head.next = new ListNode(i + 1);
            head = head.next;
        }
        ListNode current = dummyHead.next;
        while (current != null) {
            System.out.print(current.val + "->");
            if (current.next == null) {
                System.out.print("NULL");
            }
            current = current.next;
        }
        System.out.println();
        ListNode listNode = new Q19_Remove_Nth_From_End().removeNthFromEnd2(dummyHead.next, 2);
        while (listNode != null) {
            System.out.print(listNode.val + "->");
            if (listNode.next == null) {
                System.out.print("NULL");
            }
            listNode = listNode.next;
        }
    }
}
