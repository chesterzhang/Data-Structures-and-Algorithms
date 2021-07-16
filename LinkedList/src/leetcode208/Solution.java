package leetcode208;

import com.sun.org.apache.xerces.internal.impl.xs.models.XSCMUniOp;

public class Solution {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode reverseList(ListNode head) {
        ListNode prev=null;//一定要设为null,否则反转后会多出一个0
        ListNode cur=head;

        while (cur!=null){
            //如果放在while循环前面,则需要判断cur是否为空
            // 那么while循环内需要 用到next.next会提示没有初始化
            ListNode next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        return  prev;

    }
}
