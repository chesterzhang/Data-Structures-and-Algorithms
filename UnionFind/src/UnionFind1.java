//第一版并查集
//union              O(n)
//isConnected(p,q)   O(1)
public class UnionFind1 implements  IUF{
    private int[] group;

    public UnionFind1(int size){
        group=new int[size];
        for (int i = 0; i < group.length; i++) {
            group[i]=i;
        }
    }

    private int find(int p){
        if (p<0 || p>=group.length){
            System.out.println(p);
            throw  new IllegalArgumentException("Index is out of bound!");
        }
        return group[p];
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
        for (int i = 0; i < group.length; i++) {
            if (group[i]==pID){
                group[i]=qID;
            }
        }
    }

    @Override
    public int getSize() {
        return group.length;
    }
}
