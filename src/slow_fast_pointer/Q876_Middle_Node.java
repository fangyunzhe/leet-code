package slow_fast_pointer;

import linkedlist.ListNode;

/**
 * @Author fyz
 * @Date 2020/6/10 10:06
 * <p>
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 * <p>
 * 示例 1：
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
 * <p>
 * 示例 2：
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 * <p>
 * 链接：https://leetcode-cn.com/problems/middle-of-the-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Q876_Middle_Node {

    /**
     * 第一次遍历计算出链表的长度，计算出链表的中间节点
     * 第二次遍历，遍历到中间节点并返回
     */
    public ListNode middleNode(ListNode head) {
        int length = 0;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode current = dummyHead;
        while (current.next != null) {
            length++;
            current = current.next;
        }
        int middle = length / 2 + 1;
        int first = 0;
        // first = 1->2->3->4
        // dummyHead = 1->2
        while (dummyHead.next != null) {
            first++;
            if (first == middle) {
                return dummyHead.next;
            }
            dummyHead = dummyHead.next;
        }
        return null;
    }

    /**
     * 快慢指针，遍历链表的时候慢指针一次走一步，快指针一次走两步
     * 当快指针走到链表尾部的时候，慢指针正好走到链表的中间节点
     */
    public ListNode middleNode2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode first = head;
        ListNode second = head;
        while (second != null && second.next != null) {
            first = first.next;
            second = second.next.next;
        }
        return first;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode current = head;
        for (int i = 2; i < 7; i++) {
            current.next = new ListNode(i);
            current = current.next;
        }
        ListNode listNode = new Q876_Middle_Node().middleNode2(head);
        while (listNode != null) {
            System.out.print(listNode.val + "->");
            listNode = listNode.next;
        }
    }
}
