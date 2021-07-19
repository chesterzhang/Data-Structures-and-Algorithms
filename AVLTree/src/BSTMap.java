public class BSTMap<K extends  Comparable<K>, V> implements IMap<K,V> {
    private BST<K,V> bst;

    public BSTMap(){
        bst=new BST<>();
    }

    @Override
    public void add(K key, V value) {
        bst.add(key, value);
    }

    @Override
    public V remove(K key) {
        return bst.remove(key);
    }

    @Override
    public boolean contains(K key) {
        return bst.contains(key);
    }

    @Override
    public V get(K key) {
        return bst.get(key);
    }

    @Override
    public void set(K key, V newValue) {
        bst.set(key,newValue);
    }

    @Override
    public int getSize() {
        return bst.getSize();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}


