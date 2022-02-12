import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        int a=42;
        System.out.println(((Integer)a).hashCode());

        int b=-42;
        System.out.println(((Integer)b).hashCode());

        double c=3.1415926;
        System.out.println(((Double)c).hashCode());

        String d="java";
        System.out.println(d.hashCode());

        Student student1 =new Student(3,2,"Tom","Li");
        System.out.println(student1.hashCode());

        HashSet<Student> set=new HashSet<>();
        set.add(student1);

        HashMap<Student,Integer> scores=new HashMap<>();
        scores.put(student1,100);

    }
}
