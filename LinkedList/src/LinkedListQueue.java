//用链表实现一个队列,链表头为队首,链表尾为队尾,使用两个指针head,tail
//由于不需要在队首插入元素,故根本不需要链表的dummyhead

public class LinkedListIQueue<T> implements IQueue<T> {

    class Node{
        private T e;
        private Node next;

        public Node(T e,Node next){
            this.e=e;
            this.next=next;
        }

        public Node(){
            this(null,null);
        }

        @Override
        public String toString() {
            return this.e.toString();
        }

    }



    private Node head;
    private Node tail;
    int size;

    public LinkedListIQueue(){
        head=new Node();
        tail=new Node();
        size=0;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void enqueue(T e) {
        if(this.isEmpty()){
            Node newNode=new Node(e,null);
            head=newNode;
            tail=newNode;
            size++;
        }else {
            Node newNode=new Node(e,null);
            tail.next=newNode;
            tail=newNode;
            size++;
        }
    }

    @Override
    public T dequeue() {
        if (this.isEmpty()){
            throw new IllegalArgumentException("The Queue is empty, cannot dequeue!");
        }
        T ret= head.e;
        head=head.next;
        size--;
        if (isEmpty()){
            tail=null;
        }
        return ret;
    }

    @Override
    public T getFront() {
        if (this.isEmpty()){
            throw new IllegalArgumentException("The Queue is empty!");
        }
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder res= new StringBuilder();
        res.append("Queue front:");
        Node cur=head;
        while (cur!=null){
            res.append(cur+"->");
            cur=cur.next;
        }
        res.append(" NULL tail");
        return  res.toString();
    }


}




