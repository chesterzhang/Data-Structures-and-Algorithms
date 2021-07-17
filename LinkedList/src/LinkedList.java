public class LinkedList<E> {

    private  class  Node{
        public E e;
        public Node next;

        public Node(E e, Node next){
            this.e=e;
            this.next=next;
        }

        public Node(E e){
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

    public  void addFirst(E e){
        add(0,e);
    }

    //插入一个节点到索引index处
    public void add(int index,E e){
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

    public void addLast(E e){
        add(size,e);
    }

    public E get(int index){
        if (index<0 || index>=size){
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }
        Node cur=dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur=cur.next;
        }
        return cur.e;

    }

    public E getFirst(){
        return  get(0);
    }

    public  void set(int index, E e){
        if (index<0 || index>=size){
            throw new IllegalArgumentException("Set failed. Illegal index.");
        }
        Node cur=dummyHead.next;
        for (int i = 0; i < index ; i++) {
            cur=cur.next;
        }
        cur.e=e;
    }

    public  boolean contains(E e){
        Node cur=dummyHead.next;
        while (cur!=null){
            if (cur.e==e){
                return true;
            }
            cur=cur.next;
        }
        return  false;
    }

    public E remove(int index){
        if(index<0 || index >=size){
            throw  new IllegalArgumentException("Delete failed, index shoud be >=0 and < size");
        }
        Node prev= dummyHead;
        for (int i = 0; i < index; i++) {
            prev=prev.next;
        }
        Node delNode=prev.next;
        prev.next=delNode.next;
        E ret=delNode.e;
        delNode=null;
        size--;
        return  ret;
    }

    public void removeElement(E e){

        Node prev= dummyHead;
        Node cur=dummyHead.next;
        Node delNode=null;
        for (int i = 0; i < size ; i++) {
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

    public  E removeFirst(){
        return remove(0);
    }

    public  E removeLast(){
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