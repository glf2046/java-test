package clone;

public class CloneTest implements Cloneable{

    private int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private User user;

    @Override
    public Object clone() throws CloneNotSupportedException {
       return super.clone();
    }

    @Override
    public String toString() {
        return "CloneTest{" +
                "size=" + size +
                ", user=" + user +
                '}';
    }
}
