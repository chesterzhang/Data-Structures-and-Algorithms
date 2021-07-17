import com.sun.media.sound.RIFFInvalidDataException;
import com.sun.org.apache.regexp.internal.RE;

//暂时还没有将红黑树功能实现,只完成了构造函数部分
public class  RBTree<K extends Comparable<K>,V> {

    private static final boolean RED=true;
    private static final boolean BLACK=false;

    private class Node{
        public K key;
        public V value;
        public Node left,right;
        public boolean color;

        public Node(K key, V value){
            this.key=key;
            this.value=value;
            left=null;
            right=null;
            color=RED;//2-3树插入一个节点,永远先去和叶子节点去融合
        }

        public Node(){
            this.key=null;
            this.value=null;
            left=null;
            right=null;
        }
    }

    private Node root;
    private  int size;

    public RBTree(){
        root=null;
        size=0;
    }

    private boolean getColor(Node node){
        if (node==null){
            return BLACK;
        }
        return  node.color;
    }


    public void add(K key, V value) {
        root=add(root, key,value);
        root.color=BLACK;
    }

    //向以node为根的二分搜索树中加入e
    //并且返回node
    private Node add(Node node, K key, V value){
        if (node==null){
            size++;
            return new Node(key,value);
        }


        if (key.compareTo(node.key)==0){
            node.value=value;
        }else if (key.compareTo(node.key)<0 ){
            node.left=add(node.left,key,value);
        }else {
            node.right=add(node.right,key,value);
        }

        //node字树改变了,需要维护平衡

        //2节点左侧插入
        if (getColor(node.left)==RED  ){
            return node;
        }

        //2节点右侧 插入
        if (getColor(node)==BLACK && getColor(node.right)==RED){
            node=leftRotate(node);
            node.color=BLACK;
            node.left.color=BLACK;
        }

        //3节点左侧插入
        if (getColor(node.left)==RED  && getColor(node.left.left)==RED  ){
            node=rightRotate(node);
            //改变颜色
            node.color=RED;
            node.left.color=BLACK;
            node.right.color=BLACK;
            return node;
        }

        //3节点中间插入
        if (getColor(node)==BLACK && getColor(node.left)==RED && getColor(node.left.right)==RED){
            node.left=leftRotate(node.left);
            node=rightRotate(node);
            node.left.color=BLACK;
            node.right.color=BLACK;
            node.color= RED;
            return node;
        }

        //3节点右侧插入
        if (getColor(node)==BLACK && getColor(node.left)==RED && getColor(node.right)==RED){
            node.color=RED;
            node.left.color=BLACK;
            node.right.color=BLACK;
            return node;
        }

        //其他情况,说明当前节点的子树没有节点向上融合,直接return
        return  node;
    }


    private Node leftRotate(Node node){
        Node x=node.right;
        Node T1=node.left;
        Node T2=x.left;
        Node T3=x.right;

        x.left=node;
        node.right=T2;

        return x;
    }

    private Node rightRotate(Node node){
        Node x=node.left;
        Node T1=x.right;
        Node T2=node.right;

        x.right=node;
        node.left=T1;

        return x;
    }





    public boolean contains(K key) {
        return contains(root ,key);
    }

    private boolean contains(Node node,K key){
        if (node==null){
            return false;
        }
        if (key.compareTo(node.key)==0){
            return true;
        }else if (key.compareTo(node.key)<0){
            return contains(node.left,key);
        }else {
            return contains(node.right,key);
        }
    }


    public V get(K key) {
        Node retNode=getNode(root,key);
        if (retNode!=null){
            return retNode.value;
        }else {
            return null;
        }
    }

    private Node getNode(Node node,K key) {
        if (node==null){
            return null;
        }
        if (key.compareTo(node.key)==0){
            return node;
        }else if (key.compareTo(node.key)<0){
            return getNode(node.left,key);
        }else {
            return getNode(node.right,key);
        }
    }


    public void set(K key, V newValue) {
        Node setNode=getNode(root,key);
        if (setNode!=null){
            setNode.value=newValue;
        }else{
            throw new IllegalArgumentException(key + "doesn't exist!");
        }
    }


    public int getSize() {
        return size;
    }


    public boolean isEmpty() {
        return size==0;
    }


    //红黑树删除操作过于复杂,不做掌握

}