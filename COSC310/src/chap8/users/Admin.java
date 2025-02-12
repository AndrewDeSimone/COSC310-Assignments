package chap8.users;

public class Admin extends User {
    
    public Admin(String name, String id, String userName, String password) {
        super(name, id, userName, password);
    }

    @Override
    public String getType() {
        return "Admin";
    }
}