package linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author fyz
 * @Date 2020/6/8 15:16
 * <p>
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 * <p>
 * 要求返回这个链表的 深拷贝。 
 * <p>
 * 我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 * <p>
 * val：一个表示 Node.val 的整数。
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/copy-list-with-random-pointer
 **/
public class Q138_Copy_Random_List {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node node = head;
        // map保存原节点与拷贝节点的映射关系
        Map<Node, Node> map = new HashMap<>();
        while (node != null) {
            Node clone = new Node(node.val);
            map.put(node, clone);
            node = node.next;
        }
        node = head;
        // 通过映射关系连接拷贝节点
        while (node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }
        return map.get(head);
    }
}
