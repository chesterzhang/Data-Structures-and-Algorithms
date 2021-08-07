public class Array<E> {

    private E[] data;
    private int size;//有效的元素个数

    /**
     * 传入数组容量构造Array
     * @param capacity
     */
    public Array(int capacity){
        this.data =(E[]) new Object[capacity];
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

    public E get(int index){
        if (index<0 || index >= this.size){
            throw new IllegalArgumentException("Add failed. Required index>=0 <=arr.size");
        }
        return data[index];
    }

    public E getLast(){
        return  this.get(this.size-1);
    }

    public E getFirst(){
        return  this.get(0);
    }

    public void set(int index, E e){
        if (index<0 || index >= this.size){
            throw new IllegalArgumentException("Add failed. Required index>=0 <=arr.size");
        }
        data[index] =e;
    }

    public boolean contains(E e){
        for (int i = 0; i < this.size; i++) {
            if(data[i].equals(e)){
                return  true;
            }
        }
        return  false;
    }

    public int find(E e){
        for (int i = 0; i < this.size; i++) {
            if(data[i].equals(e)){
                return  i;
            }
        }
        return  -1;
    }

    //数组扩/缩容
    private void resize(int newCapacity){
        E[] newData=(E[]) new Object[newCapacity];
        for (int i = 0; i < this.size; i++) {
            newData[i]=data[i];
        }
        this.data=newData;

    }

    //在index位置插入一个新元素,index后面的元素需要后移
    public void add(int index, E e){

        //若索引<0 或是 大于 size, 抛出异常。
        if (index<0 || index >this.size){
            throw new IllegalArgumentException("Add failed. Required index>=0 <=arr.size");
        }

        //数组已满,需要扩容
        if (this.size==this.data.length){
            //数组扩容
            this.resize(2* data.length);
        }

        //将index后面的元素一个个后移
        for (int i = size-1; i >=index ; i--) {
            data[i+1]=data[i];
        }

        //插入新元素
        this.data[index]=e;

        //更新有效元素个数
        this.size++;
    }

    public void addFirst(E e){
        add(0,e);
    }

    public void addLast(E e){
        this.add(this.size,e);
    }


    //删除index位置的元素,返回删除的元素
    public E remove(int index){
        //索引越界，抛出异常
        if (index<0 || index > this.size){
            throw new IllegalArgumentException("Add failed. Required index>=0 <=arr.size");
        }

        //return的元素
        E ret=data[index];

        //将index之后的元素, 一个个向前移
        for(int i=index+1;i<size;i++){
            data[i-1]=data[i];
        }

        //更新有效元素个数
        size--;

        //减少了一个元素,将原来最后一个设为NULL
        data[size]=null;

        //动态减少空间
        if (size<= data.length/4 && data.length/2!=0 ){
            this.resize(data.length/2);
        }

        return  ret;
    }

    public void removeElement(E e){
        int index=find(e);
        if (index!=-1){
            remove(index);
        }
    }

    public E removeLast(){
        return this.remove(size-1);
    }

    public E removeFirst(){
        return this.remove(0);
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


