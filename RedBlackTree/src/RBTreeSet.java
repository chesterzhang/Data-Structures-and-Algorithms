public class  RBTreeSet <E extends Comparable<E>> implements Set<E>  {


    private  RBTree<E,Object> rbTree;

    public RBTreeSet(){
        rbTree=new RBTree<>();
    }

    @Override
    public void add(E e) {
        rbTree.add(e,null);
    }

    @Override
    public void remove(E e) {
        //rbTree.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return rbTree.contains(e);
    }

    @Override
    public boolean isEmpty() {
        return rbTree.isEmpty();
    }

    @Override
    public int getSize() {
        return rbTree.getSize();
    }
}
