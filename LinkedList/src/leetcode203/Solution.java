package leetcode203;

//leetcode 203
public class Solution {

      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) {
              this.val = val;
          }
          ListNode(int val, ListNode next) {
              this.val = val; this.next = next;
          }
      }

    public ListNode removeElements(ListNode head, int val) {

          ListNode dummyHead= new ListNode(-1);
          dummyHead.next=head;
          ListNode cur=dummyHead;
          while (cur!=null ){
              if ( cur.next!=null && cur.next.val==val){
                  ListNode delNode=cur.next;
                  cur.next=delNode.next;
                  delNode=null;
              }else {
                  cur=cur.next;
              }
          }
          return  dummyHead.next;
    }

    //用递归的方法,暂时看不懂
//    public ListNode removeElements(ListNode head, int val) {
//
//        if (head==null)
//            return null;
//
//        ListNode res=removeElements(head.next,val);
//        if (head.val==val){
//            return res;
//        }else {
//            head.next=res;
//            return head;
//        }
//
//    }

}
