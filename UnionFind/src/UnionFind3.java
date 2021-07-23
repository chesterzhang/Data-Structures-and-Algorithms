//第三版并查集, union过程基于size优化, 小树指向大树
//union O(n)         O(h),h为树的高度
//isConnected(p,q)   O(h),h为树的高度
public class UnionFind3 implements  IUF{
    private int[] parent;
    private int[] sz;// sz[i]表示以i为根的树的个数

    public UnionFind3(int size){
        parent=new int[size];
        sz=new int[size];
        for (int i=0;i<size;i++){
            parent[i]=i;
            sz[i]=1;
        }
    }

    //查询p的根节点,O(h)复杂度,h为树的高度
    private int find(int p){
        if (p<0 || p>=parent.length){
            throw  new IllegalArgumentException("Index is out of bound!");
        }

        while (p!=parent[p]){
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
        if (sz[pRoot]<sz[qRoot]){
            parent[pRoot]=qRoot;
            sz[qRoot]+=sz[pRoot];
        }else {
            parent[qRoot]=pRoot;
            sz[pRoot]+=sz[qRoot];
        }

    }

    @Override
    public int getSize() {
        return parent.length;
    }
}

