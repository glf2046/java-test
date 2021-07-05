package alg.back_trace;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serial {


    static class Wheel{
        private String value;

        public Wheel(String value) {
            this.value = value;
        }
    }

    static class Vehicle {}

    static class Car extends Vehicle implements Serializable{

    }

    static class Ford extends Vehicle implements Serializable{

    }

    static class Dorge extends Vehicle implements Serializable{
        Wheel w = new Wheel("w1");
    }


    public static void main(String[] args) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("a.txt"));
        objectOutputStream.writeObject(new Car());
        objectOutputStream.writeObject(new Ford());
        objectOutputStream.writeObject(new Dorge());
        objectOutputStream.flush();
        objectOutputStream.close();
    }
}
