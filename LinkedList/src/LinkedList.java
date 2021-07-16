public class LinkedList<T> {

    private  class  Node{
        public T e;
        public Node next;

        public Node(T e, Node next){
            this.e=e;
            this.next=next;
        }

        public Node(T e){
            this(e,null);
        }

        public Node(){
            this(null,null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    int size;

    public LinkedList(){
        dummyHead=new Node(null,null);
        size=0;
    }

    public int getSize(){
        return  size;
    }

    public  boolean isEmpty(){
        return  size==0;
    }

    public  void addFirst(T e){
        add(0,e);
    }

    //插入一个节点到索引index处
    public void add(int index,T e){
        if (index<0 || index>size){
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        Node prev=dummyHead;
        for (int i = 0; i < index; i++) {
            prev=prev.next;
        }

        Node newNode= new Node(e);
        newNode.next=prev.next;
        prev.next=newNode;
        size++;

    }

    public void addLast(T e){
        add(size,e);
    }

    public T get(int index){
        if (index<0 || index>=size){
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }
        Node cur=dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur=cur.next;
        }
        return cur.e;

    }

    public T getFirst(){
        return  get(0);
    }

    public  void set(int index, T e){
        if (index<0 || index>=size){
            throw new IllegalArgumentException("Set failed. Illegal index.");
        }
        Node cur=dummyHead.next;
        for (int i = 0; i < index ; i++) {
            cur=cur.next;
        }
        cur.e=e;
    }

    public  boolean contains(T e){
        Node cur=dummyHead.next;
        while (cur!=null){
            if (cur.e==e){
                return true;
            }
            cur=cur.next;
        }
        return  false;
    }

    public T remove(int index){
        if(index<0 || index >=size){
            throw  new IllegalArgumentException("Delete failed, index shoud be >=0 and < size");
        }
        Node prev= dummyHead;
        for (int i = 0; i < index; i++) {
            prev=prev.next;
        }
        Node delNode=prev.next;
        prev.next=delNode.next;
        T ret=delNode.e;
        delNode=null;
        size--;
        return  ret;
    }

    public void removeElement(T e){


        Node prev= dummyHead;
        Node cur=dummyHead.next;
        Node delNode=null;
        for (int i = 0; i < size -1; i++) {
            if (cur.e==e){
                delNode=cur;
                prev.next=delNode.next;
                cur=null;
                break;
            }else {
                cur=cur.next;
                prev=prev.next;
            }

        }
        if (delNode==null){
            throw  new IllegalArgumentException("Doesn't contain e !!!");
        }

    }

    public  T removeFirst(){
        return remove(0);
    }

    public  T removeLast(){
        return remove(size-1);
    }

    @Override
    public String toString() {
        StringBuilder res= new StringBuilder();
        Node cur=dummyHead.next;
        while (cur!=null){
            res.append(cur+"->");
            cur=cur.next;
        }
        res.append("Null");
        return  res.toString();
    }
}