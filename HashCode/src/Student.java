import java.util.Locale;

public class Student {
    public int grade;
    public int cls;
    public String firstName;
    public String lastName;

    public Student(int grade, int cls, String firstName, String lastName) {
        this.grade = grade;
        this.cls = cls;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //如果不重写hashCode,java默认用其地址转化成一个hashCode
    @Override
    public int hashCode(){
        int B=31;
        int hash=0;

        hash =hash*B+grade;
        hash =hash*B+cls;
        hash =hash*B+firstName.hashCode();
        hash =hash*B+lastName.hashCode();

        return  hash;
    }



    @Override
    public boolean equals(Object obj) {
        if (this==obj)
            return true;
        if (obj==null)
            return false;
        if (obj.getClass()!=this.getClass())
            return false;

        Student another=(Student) obj;
        return another.grade==this.grade && another.cls==this.cls &&
                another.firstName==this.firstName &&
                another.lastName==this.lastName;
    }
}
