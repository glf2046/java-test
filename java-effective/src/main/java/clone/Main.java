package clone;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        CloneTest test = new CloneTest();
        User user = new User();
        System.out.println("user's hashcode: " + user.hashCode());
        test.setUser(user);
        test.setSize(10);
        System.out.println(test.hashCode());

        System.out.println(test.clone().hashCode());
        System.out.println("test clone's user's hashcode： " + ((CloneTest)test.clone()).getUser().hashCode());

        System.out.println(test.clone().toString());

        System.out.println("############");

        CloneTestChild child = new CloneTestChild();
        child.setUser(new User());
        child.setSize(20);
        child.setOther("other string");
        System.out.println(child.hashCode());
        System.out.println("child's user's hashcode: " + child.getUser().hashCode());

        Object copy = child.clone();
        System.out.println(copy.hashCode());
        System.out.println("copy's user's hashcode: " + ((CloneTestChild)copy).getUser().hashCode());
        System.out.println(copy);
    }
}
