public class BST<K extends Comparable<K>,V> {

    private class Node{
        public K key;
        public V value;
        public Node left,right;

        public Node(K key, V value){
            this.key=key;
            this.value=value;
            left=null;
            right=null;
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

    public BST(){
        root=null;
        size=0;
    }


    public void add(K key, V value) {
        root=add(root, key,value);
    }

    //向以node为根的二分搜索树中加入e
    //并且返回node
    private Node add(Node node, K key, V value){
        if (node==null){
            size++;
            return new Node(key,value);
        }

        //Map中不能存在相同的key
        if (key.compareTo(node.key)==0){
            return node;
        }else if (key.compareTo(node.key)<0 ){
            node.left=add(node.left,key,value);
        }else {
            node.right=add(node.right,key,value);
        }
        return  node;
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


    public V remove(K key) {
        Node delNode=getNode(root,key);
        if (delNode!=null){
            root=remove(root,key);
            return delNode.value;
        }else {
            return null;
        }
    }

    //从以node为根节点的子树中删除,并返回node
    private  Node remove(Node node, K key){
        if (node==null){
            return null;
        }

        if (key.compareTo(node.key)<0){
            node.left=remove(node.left,key);
            return node;
        }else if (key.compareTo(node.key)>0){
            node.right=remove(node.right,key);
            return node;
        }else {//e==node.e
            if (node.left==null){
               Node rightNode=node.right;
                node=null;
                size--;
                return rightNode;
            }else if (node.right==null){
                Node leftNode=node.left;
                node=null;
                size--;
                return leftNode;
            }else {
                Node successor=minimum(node.right);
                successor.right=removeMin(node.right);//已经size--了
                successor.left=node.left;
                node=null;
                return successor;
            }

        }

    }
    //寻找二分搜索树中最小的元素的节点,并返回
    private  Node minimum( Node node){
        if (node.left!=null){
            return minimum(node.left);
        }else {
            return node;
        }
    }

    //删除以node为根节点的树的最小节点,并且返回node
    private  Node removeMin( Node node){
        if (node.left==null){
             Node rightNode=node.right;
            node=null;
            size--;
            return rightNode;
        }
        node.left=removeMin(node.left);
        return node;
    }

}


