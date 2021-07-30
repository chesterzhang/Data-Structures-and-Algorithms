public class Student implements Comparable<Student> {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score=score;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return  true;
        }
        if (obj ==null) {
            return  false;
        }
        if (this.getClass()!=obj.getClass()){
            return false;
        }
        Student another=(Student) obj;
        return this.name.equals(another.name);
    }

    @Override
    public int compareTo(Student o) {
//        if (this.score<o.score){
//            return -1;
//        }else  if (this.score==o.score){
//            return 0;
//        }else {
//            return 1;
//        }
        return  this.score - o.score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}

