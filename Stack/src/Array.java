public class Array<T> {

    private T[] data;
    private int size;//有效的元素个数

    /**
     * 传入数组容量构造Array
     * @param capacity
     */
    public Array(int capacity){
        this.data =(T[]) new Object[capacity];
        this.size=0;
    }

    public Array(){
        this(10);
    }

    public  int getSize(){
        return this.size;
    }

    public int getCapacity(){
        return this.data.length;
    }

    public boolean isEmpty(){
        return  size==0;
    }

    public void addLast(T e){
        this.add(this.size,e);
    }

    public void addFirst(T e){
        add(0,e);
    }

    //在index位置插入一个新元素,index后面的元素需要后移
    public void add(int index, T e){

        if (index<0 || index >this.size){
            throw new IllegalArgumentException("Add failed. Required index>=0 <=arr.size");
        }

        if (this.size==this.data.length){
            //数组扩容
            this.resize(2* data.length);
        }

        for (int i = size-1; i >=index ; i--) {
            data[i+1]=data[i];
        }
        this.data[index]=e;
        this.size++;
    }

    //数组扩容
    private void resize(int newCapacity){
        T[] newData=(T[]) new Object[newCapacity];
        for (int i = 0; i < this.size; i++) {
            newData[i]=data[i];
        }
        this.data=newData;

    }

    //删除index位置的元素,返回删除的元素
    public T remove(int index){
        if (index<0 || index > this.size){
            throw new IllegalArgumentException("Add failed. Required index>=0 <=arr.size");
        }
        T ret=data[index];
        for(int i=index+1;i<size;i++){
            data[i-1]=data[i];
        }
        size--;
        data[size]=null;
        //动态减少空间
        if (size<= data.length/4 && data.length/2!=0 ){
            this.resize(data.length/2);
        }
        return  ret;
    }

    public T removeLast(){
         return this.remove(size-1);
    }

    public T removeFirst(){
        return this.remove(0);
    }

    public void removeElement(T e){
        int index=find(e);
        if (index!=-1){
            remove(index);
        }
    }

    public T get(int index){
        if (index<0 || index >= this.size){
            throw new IllegalArgumentException("Add failed. Required index>=0 <=arr.size");
        }
        return data[index];
    }

    public T getLast(){
        return  this.get(this.size-1);
    }

    public T getFirst(){
        return  this.get(0);
    }

    
    public void set(int index, T e){
        if (index<0 || index >= this.size){
            throw new IllegalArgumentException("Add failed. Required index>=0 <=arr.size");
        }
        data[index] =e;
    }

    public boolean contain(T e){
        for (int i = 0; i < this.size; i++) {
            if(data[i].equals(e)){
                return  true;
            }
        }
        return  false;
    }

    public int find(T e){
        for (int i = 0; i < this.size; i++) {
            if(data[i].equals(e)){
                return  i;
            }
        }
        return  -1;
    }

    @Override
    public String toString() {
        StringBuilder res =new StringBuilder();
        res.append("Array: size="+ this.size+ " capacity="+this.data.length);
        res.append(" [");
        for (int i = 0; i < this.size; i++) {
            res.append(data[i]);
            if(i!=size-1){
                res.append(", ");
            }
        }
        res.append("]");
        return  res.toString();

    }
}
