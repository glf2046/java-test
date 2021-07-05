package clone;

public class CloneTestChild extends CloneTest {

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    private String other;

    @Override
    public final Object clone() throws CloneNotSupportedException {

       return super.clone();
    }

    @Override
    public String toString() {
        return "CloneTestChild{" +
                "other='" + other + "\'" +
                "} " + super.toString();
    }
}
