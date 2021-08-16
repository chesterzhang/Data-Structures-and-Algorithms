public class ArrayStack<E> implements Stack<E> {
    Array<E> array;

    public ArrayStack(int capacity) {
        this.array = new Array<E>(capacity);
    }

    public ArrayStack() {
        this.array = new Array<E>();
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
    public void push(E e) {
        this.array.addLast(e);
    }

    @Override
    public E pop() {
        return this.array.removeLast();
    }

    @Override
    public E peek() {
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

    public static void main(String[] args) {
        ArrayStack<Integer> stack=new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        stack.pop();
        System.out.println(stack);
    }
}
