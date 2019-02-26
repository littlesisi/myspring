package hellospringboot.demo.entity;

public class S1
{
    public void setUser_name(String user_name) {
        User_name = user_name;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUser_name() {
        return User_name;
    }

    public String getID() {
        return ID;
    }

    private String User_name;
    private String ID;
}
