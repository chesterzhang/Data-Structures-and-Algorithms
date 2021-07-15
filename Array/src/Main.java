public class Main {

    public static void main(String[] args) {
        //泛型中只能放类
        Array<Integer> arr= new Array();
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);

        //测试扩容功能
        arr.add(10,10);
        System.out.println(arr);

        arr.add(1,100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);

        arr.remove(2);
        System.out.println(arr);

        arr.removeElement(10);
        System.out.println(arr);

        //测试动态减小空间功能
        arr.removeElement(9);
        arr.removeElement(8);
        arr.removeElement(7);
        arr.removeElement(6);
        arr.removeElement(5);
        arr.removeElement(4);
        System.out.println(arr);
    }
}

