package chap8.users;

public class Faculty extends Employee {

    public Faculty(String name, String id, String userName, String password) {
        super(name, id, userName, password);
    }

    @Override
    public String getType() {
        return "Faculty";
    }
}