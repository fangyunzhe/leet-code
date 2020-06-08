package linkedlist;

/**
 * @Author fyz
 * @Date 2020/6/8 15:17
 * <p>
 * 反转一个单链表。
 * <p>
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 **/
public class Q206_Reverse_List {

    /**
     * 将链表的后一个节点指向前一个节点，然后将原来的指针删除
     */
    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextTemp = current.next;
            current.next = previous;
            previous = current;
            current = nextTemp;
        }
        return previous;
    }
}
