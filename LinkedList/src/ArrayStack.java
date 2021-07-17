public class ArrayIStack<T> implements IStack<T> {
    Array<T> array;

    public ArrayIStack(int capacity) {
        this.array = new Array<T>(capacity);
    }

    public ArrayIStack() {
        this.array = new Array<T>();
    }

    @Override
    public int getSize() {
        return this.array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return this.array.isEmpty();
    }

    @Override
    public void push(T e) {
        this.array.addLast(e);
    }

    @Override
    public T pop() {
        return this.array.removeLast();
    }

    @Override
    public T peek() {
        return this.array.getLast();
    }

    public int getCapacity(){
        return this.array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder res=new StringBuilder();
        res.append("Stack : ");
        res.append(" [ ");
        for (int i = 0; i < this.array.getSize(); i++) {
            res.append(this.array.get(i));
            if (i!=array.getSize()-1){
                res.append(", ");
            }
        }
        res.append(" ] top");
        return res.toString();
    }
}
