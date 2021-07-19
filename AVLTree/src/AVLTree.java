import java.util.ArrayList;

public class AVLTree<K extends Comparable<K>,V>  {

    private class Node{
        public K key;
        public V value;
        public Node left,right;
        public int height;//以当前node为根的树的高度

        public Node(K key, V value){
            this.key=key;
            this.value=value;
            left=null;
            right=null;
            height=1;
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

    public AVLTree(){
        root=null;
        size=0;
    }

    //获取以node为根的树的高度
    private int   getHeight(Node node){
        if (node==null)
            return 0;
        return node.height;
    }

    //计算平衡因子,定义:左子树高度-右子树高度
    private int getBalanceFactor(Node node){
        if (node==null)
            return 0;
        return getHeight(node.left)-getHeight(node.right);
    }

    //辅助函数,用于调试,判断AVL是不是一棵BST
    //利用中序遍历
    public boolean isBST(){
        ArrayList<K> keys= new ArrayList<>();
        inOrder(root,keys);
        for (int i = 0; i < keys.size()-1; i++) {
            if (keys.get(i).compareTo(keys.get(i+1))>0)
                return false;
        }
        return true;
    }

    //中序遍历,将BST内的key按从小到大顺序取出
    private void inOrder(Node node, ArrayList<K> keys){
        if (node==null)
            return ;
        inOrder(node.left,keys);
        keys.add(node.key);
        inOrder(node.right,keys);
    }

    //辅助函数,用于调试AVL,判断是否平衡
    public  boolean isBalanced(){
        return isBalanced(root);
    }

    //辅助函数,用于调试AVL,判断是否平衡
    //从根节点开始向下递归
    private boolean isBalanced(Node node){
        if (node==null)
            return true;
        int balanceFactor=getBalanceFactor(node);
        if (Math.abs(balanceFactor)>1)
            return false;
        return isBalanced(node.left) && isBalanced(node.right);
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

        if (key.compareTo(node.key)==0){
            node.value=value;
        }else if (key.compareTo(node.key)<0 ){
            node.left=add(node.left,key,value);
        }else {
            node.right=add(node.right,key,value);
        }

        //维护平衡
        return maintainBalance(node);

    }

    private  Node maintainBalance(Node node){

        //更新height
        node.height=1+Math.max(getHeight(node.left),getHeight(node.right ));

        //计算平衡因子
        int balanceFactor=getBalanceFactor(node);


        //若当前节点的平衡因子绝对值超过1,则需要平衡维护
        //LL
        if (balanceFactor>1 && getBalanceFactor(node.left)>=0 ){
            return rightRotate(node);
        }

        //LR
        if (balanceFactor>1 && getBalanceFactor(node.left)<0 ){
            node.left=leftRotate(node.left);
            return rightRotate(node);
        }

        //RR·
        if (balanceFactor<-1 && getBalanceFactor(node.right)<=0 ){
            return leftRotate(node);
        }

        //RL
        if (balanceFactor<-1 && getBalanceFactor(node.right)>0 ){
            node.right=rightRotate(node.right);
            return leftRotate(node);
        }

        //已经平衡,无需维护
        return node;

    }

    //对y节点进行右旋转,返回旋转后的新根节点x, z为新加入的节点,导致y不平衡
    //         y                               x
    //       /  \          右旋转             /  \
    //      x   T3       -------->          T1    y
    //     /  \                                  /  \
    //    T1   T2                              T2   T3
    private Node rightRotate(Node y){
        Node x=y.left;
        Node T1=x.left;
        Node T2=x.right;
        Node T3=y.right;

        //右旋转
        x.right=y;
        y.left=T2;

        //更新height
        //因为x随y改变而改变,所以要先更新y
        y.height=1+Math.max(getHeight(T2),getHeight(T3));
        x.height=1+Math.max(getHeight(T1),getHeight(y));

        return x;
    }

    //对y节点进行左旋转,返回旋转后的新根节点x
    //      y                                   x
    //    /  \            左旋转               /  \
    //  T3     x         -------->           y     T1
    //        /  \                         /  \
    //      T2    T1                     T3    T2
    private Node leftRotate(Node y) {
        Node x=y.right;
        Node T1=x.right;
        Node T2=x.left;
        Node T3=y.left;

        //左旋转
        x.left=y;
        y.right=T2;

        //更新height
        //因为x随y改变而改变,所以要先更新y
        y.height=1+Math.max(getHeight(T3),getHeight(T2));
        x.height=1+Math.max(getHeight(y),getHeight(T1));

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
            //node的左子树平衡可能被破坏了
            return maintainBalance(node);

        }else if (key.compareTo(node.key)>0){
            node.right=remove(node.right,key);
            //node的右子树平衡可能被破坏了
            return maintainBalance(node);

        }else {//key==node.key 找到了被删除的节点

            if (node.left==null){
                Node rightNode=node.right;
                node=null;
                size--;
                return rightNode;
            }else if (node.right==null){
                Node leftNode=node.left;
                node=null;
                size--;
                return  leftNode;
            }else {
                //找到待删除节点右子树中最小的节点,替代待删除节点的位置
                Node successor=minimum(node.right);
                successor.right=removeMin(node.right);//已经size--了
                successor.left=node.left;
                node=null;
                //successor在removeMin中删掉的时候已经维护了平衡
                //successor替换被删去的node的位置,就不用再维护平衡了,
                return  successor;
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

    public void  removeMin(){
        root=removeMin(root);
    }

    //删除以node为根节点的树的最小节点,并且返回node
    private Node removeMin( Node node){
        if (node.left==null){
            Node rightNode=node.right;
            node=null;
            size--;
            return rightNode;
        }
        node.left=removeMin(node.left);

        //node的左子树被改变了,需要维护node的平衡
        return maintainBalance(node);
    }

}



