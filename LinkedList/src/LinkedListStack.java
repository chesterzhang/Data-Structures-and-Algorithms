//用链表实现一个栈,链表头是栈顶,push,pop,peek都是O(1)时间复杂度
//相比于底层用数组实现的栈,用链表实现的栈避免了频繁的resize操作,但是要频繁的new操作

public class LinkedListIStack<T> implements IStack<T> {
    private LinkedList<T> list;

    public LinkedListIStack(){
        list = new LinkedList<T>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(T e) {
        list.addFirst(e);
    }

    @Override
    public T pop() {
        return list.removeFirst();
    }

    @Override
    public T peek() {
        return list.getFirst();
    }

    @Override
    public String toString() {
         StringBuilder res =new StringBuilder();
         res.append("Stack: top ");
         res.append(list);
         return res.toString();
    }
}

