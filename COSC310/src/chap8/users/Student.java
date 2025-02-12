package chap8.users;

public class Student extends User {
    public Student(String name, String id, String userName, String password) {
        super(name, id, userName, password);
    }

    //@Override
    //public String toString() {
    //    return "STUDENT - " + super.toString();
    //}

    @Override
    public String getType() {
        return "Student";
    }
}