import java.util.TreeMap;

public class HashTable <K,V>{

    private TreeMap<K,V>[] hashTable;
    private  int size;//哈希表元素的个数
    private int M;//哈希表数组的容量
    private  static  final  int upperTol=10;//>10触发扩容
    private  static  final  int lowerTol=2;//<2触发缩容
    private  static  final  int[] capacity={53,97,193,389,769,1543,3079,6151,12289,
    24593,49157,98317,196613,393241,786433,1572869,3145739,6291469,12582917};
    private  int capacityIdx=0;

    public  HashTable(int M){
        this.M=capacity[capacityIdx];
        size=0;
        hashTable=new TreeMap[M];
        for (int i = 0; i < M ; i++) {
            hashTable[i]=new TreeMap<>();
        }
    }



    private int hash(K key){
        //和 & 0x7fffffff 按位与,相当于消除符号位
        //再 % M, 对数组容量取模,近似地可以看作是求索引
        return (key.hashCode() & 0x7fffffff)%M;
    }

    public  int getSize(){
        return  size;
    }

    public void add(K key, V value) {
        int idx=hash(key);
        if (hashTable[idx].containsKey(key)){
            hashTable[idx].put(key, value);
        }else {
            hashTable[idx].put(key, value);
            size++;
            if (size/M>=upperTol && (capacityIdx+1)<=(capacity.length-1)){
                capacityIdx++;
                resize(capacityIdx);
            }
        }
    }

    private void resize(int newM){
        TreeMap<K,V>[] newHashTable=new TreeMap[newM];
        for (int i = 0; i < newM; i++) {
            newHashTable[i]=new TreeMap<>();
        }
        //更新M
        this.M=newM;
        for (int i = 0; i < M; i++) {
            TreeMap<K,V> map =hashTable[i];
            for (K key: map.keySet()){
                int newIdx=hash(key);
                newHashTable[newIdx].put(key,map.get(key));
            }
        }
    }

    public V remove(K key){
        int idx=hash(key);
        V ret=null;
        if (hashTable[idx].containsKey(key)){
            ret=hashTable[idx].remove(key);
            size--;
            if (size/M<=lowerTol && capacityIdx-1>=0){
                capacityIdx--;
                resize(capacityIdx);
            }
        }
        return  ret;
    }

    public  void set(K key, V value){
        int idx=hash(key);
        if (!hashTable[idx].containsKey(key)){
            throw new IllegalArgumentException(key+" dosen't exist!");
        }
        hashTable[idx].put(key, value);
    }

    public  boolean contains(K key ){
        int idx=hash(key);
        return hashTable[idx].containsKey(key);

    }

    public  V get(K key ){
        int idx=hash(key);
        return hashTable[idx].get(key);
    }

}

