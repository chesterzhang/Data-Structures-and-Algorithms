//第一版并查集
//union              O(n)
//isConnected(p,q)   O(1)
public class UnionFind1 implements  IUF{
    private int[] id;

    public UnionFind1(int size){
        id=new int[size];
        for (int i = 0; i < id.length; i++) {
            id[i]=i;
        }
    }

    private int find(int p){
        if (p<0 || p>=id.length){
            System.out.println(p);
            throw  new IllegalArgumentException("Index is out of bound!");
        }
        return id[p];
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p)==find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pID=find(p);
        int qID=find(q);
        if (pID == qID) {
            return;
        }
        for (int i = 0; i < id.length; i++) {
            if (id[i]==pID){
                id[i]=qID;
            }
        }
    }

    @Override
    public int getSize() {
        return id.length;
    }
}
