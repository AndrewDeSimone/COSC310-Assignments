package chap8.users;

public class Staff extends Employee {
    public Staff(String name, String id, String userName, String password) {
        super(name, id, userName, password);
    }

    @Override
    public String getType() {
        return "Staff";
    }
}