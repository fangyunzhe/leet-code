package linkedlist;

/**
 * @Author fyz
 * @Date 2020/6/8 11:55
 * <p>
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * <p>
 * 示例 2:
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-list
 **/
public class Q61_Rotate_Right {

    /**
     * 先将链表闭合，形成环形链表
     * 进行k次旋转
     * 找到新第链表的头节点和尾节点
     * 将环断开
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        // 将链表闭合
        return null;
    }

    /**
     * 将链表倒数第 k+1 个节点作为新链表的头节点
     * 如果 k > length，则 k = k % length + 1
     */
    public ListNode rotateRight2(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int length = 0;
        ListNode first = head;
        while (first != null) {
            length++;
            first = first.next;
        }
        int n = k % length; // 倒数第 n+1 个为头节点
        if (n == 0) {
            return head;
        }
        int m = length - n; // 正数第m个为头节点

        // 找到链表第m个节点的前置节点
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        // length = 5, k = 2, m = 3
        // m = 2 -> 1
        // dummyHead = 1 -> 2
        while (m > 0) {
            m--;
            dummyHead = dummyHead.next;
        }
        ListNode newHead = dummyHead.next;
        dummyHead.next = null;
        ListNode current = newHead;
        while (current.next != null) {
            current = current.next;
        }
        current.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode dummyHead = new ListNode(0);
        ListNode head = new ListNode(1);
        dummyHead.next = head;
        for (int i = 2; i < 3; i++) {
            head.next = new ListNode(i);
            head = head.next;
        }
        ListNode listNode = new Q61_Rotate_Right().rotateRight2(dummyHead.next, 2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
