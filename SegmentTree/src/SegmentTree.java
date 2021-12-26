public class SegmentTree<E> {

    private E[] data;
    private E[] tree;
    private IMerger<E> merger;

    public SegmentTree(E[] arr, IMerger<E> merger){
        this.merger=merger;
        data =(E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i]=arr[i];
        }
        tree=(E[]) new Object[4*arr.length];
        buildSegmentTree(0,0, data.length-1);
    }

    private int leftChild(int idx){
        return 2*idx+1;
    }

    private int rightChild(int idx){
        return 2*idx+2;
    }

    private void buildSegmentTree(int treeIdx,int l, int r){
        if (l>=r){
            tree[treeIdx]=data[l];
            return;
        }
        int leftIdx=leftChild(treeIdx);
        int rightIdx=rightChild(treeIdx);

        int mid=l+(r-l)/2;
        buildSegmentTree(leftIdx,l,mid);
        buildSegmentTree(rightIdx,mid+1,r);

         tree[treeIdx]= merger.merge(tree[leftIdx],tree[rightIdx]);
    }

    public E get(int idx){
        if (idx<0 || idx>= data.length){
            throw new IllegalArgumentException(" Illegal index !");
        }
        return  data[idx];
    }

    public int getSize(){
        return data.length;
    }

    //queryL, queryR 分别表示查询的左右区间
    public E query(int queryL, int queryR){
        if (queryL<0 || queryL>= data.length || queryR<0 || queryR>= data.length ){
            throw new IllegalArgumentException(" Illegal index !");
        }

        return query(0,0, data.length-1,queryL,queryR);
    }

    //treeIdx 表示当前节点的索引
    //l 表示当前节点所表示原数组的左索引,  r 表示当前节点所表示的原数组右索引
    private E query(int treeIdx,int l, int r,int queryL, int queryR){
        if (l==queryL && r==queryR){
            return tree[treeIdx];
        }

        int mid=l+(r-l)/2;
        int leftTreeIdx=leftChild(treeIdx);
        int rightTreeIdx=rightChild(treeIdx);

        if (queryL>=mid+1 ){
            return query(rightTreeIdx,mid+1 ,r,queryL,queryR);
        }else if(queryR<=mid){
            return query(leftTreeIdx,l,mid ,queryL,queryR);
        }else {
            E leftResult=query(leftTreeIdx,l,mid,queryL,mid);
            E rightResult=query(rightTreeIdx,mid+1 ,r,mid+1,queryR);
            return merger.merge(leftResult,rightResult);
        }
    }

    public void set(int idx,E e){
        if (idx<0 || idx>= data.length  ){
            throw new IllegalArgumentException(" Illegal index !");
        }
        data[idx]=e;
        set(0,0,data.length-1,idx,e);
    }

    private void set(int treeIdx, int l, int r, int idx, E e){

        if (l>=r){
            tree[treeIdx]=e;
            return;
        }
        int mid=l+(r-l)/2;
        int leftTreeIdx=leftChild(treeIdx);
        int rightTreeIdx=rightChild(treeIdx);

        if (idx>=mid+1){
            set(rightTreeIdx,mid+1,r,idx,e);
        }else {
            set(leftTreeIdx,l,mid,idx,e);
        }
        tree[treeIdx]= merger.merge(tree[leftTreeIdx],tree[rightTreeIdx]);
    }


    @Override
    public String toString() {
        StringBuilder res=new StringBuilder();
        res.append('[');
        for (int i = 0; i < tree.length; i++) {
            if (tree[i]!=null){
                res.append(tree[i]);
            }
            else{
                res.append("null");
            }
            if (i!= tree.length-1){
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }
}


