//第五版并查集, union过程基于rank优化+路径压缩优化
//union O(n)         O(h),h为树的高度
//isConnected(p,q)   O(h),h为树的高度
public class UnionFind5 implements  IUF{
    private int[] parent;
    private int[] rank;// sz[i]表示以i为根的集合中元素个数

    public UnionFind5(int size){
        parent=new int[size];
        rank=new int[size];
        for (int i=0;i<size;i++){
            parent[i]=i;
            rank[i]=1;
        }
    }

    //查询p的根节点,O(h)复杂度,h为树的高度
    private int find(int p){
        if (p<0 || p>=parent.length){
            throw  new IllegalArgumentException("Index is out of bound!");
        }

        while (p!=parent[p]){
            parent[p]=parent[parent[p]];
            p=parent[p];
        }
        return p;
    }


    @Override
    public boolean isConnected(int p, int q) {
        return  find(p)==find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot=find(p);
        int qRoot=find(q);

        if ( pRoot==qRoot ){
            return;
        }
        if (rank[pRoot]<rank[qRoot]){
            parent[pRoot]=qRoot;

        }else  if (rank[pRoot]>rank[qRoot]){
            parent[qRoot]=pRoot;
        } else {
            parent[qRoot]=pRoot;
            rank[pRoot]+=1;
        }

    }

    @Override
    public int getSize() {
        return parent.length;
    }
}



