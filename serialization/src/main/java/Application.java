import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.alibaba.fastjson.JSON;

public class Application {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Entity entity = new Entity();

        entity.setField1("f1");
        entity.setField2("f2");
        entity.setField3(10L);

        //1. serialization using json
        FileWriter writer = new FileWriter(new File("test.txt"));

        writer.write(JSON.toJSONString(entity));
        writer.flush();
        writer.close();

        FileReader fileReader = new FileReader(new File("test.txt"));
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println("line: " + line);
            stringBuilder.append(line);
        }

        System.out.println("json string read from file: " + stringBuilder.toString());

        System.out.println(JSON.parseObject(stringBuilder.toString(), Entity.class));
        System.out.println(JSON.parseObject(stringBuilder.toString(), Entity.class).equals(JSON.parseObject(stringBuilder.toString(), Entity.class)));
        System.out.println(JSON.parseObject(stringBuilder.toString(), Entity.class) == (JSON.parseObject(stringBuilder.toString(), Entity.class)));

        //2. serialization using java sdk
        FileOutputStream fileOutputStream = new FileOutputStream("entity.tmp");
        ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
        out.writeObject(entity);
        out.flush();
        out.close();

        FileInputStream fileInputStream = new FileInputStream("entity.tmp");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Entity entity1= (Entity)objectInputStream.readObject();
        System.out.println(entity1);

        FileInputStream fileInputStream2 = new FileInputStream("entity.tmp");
        ObjectInputStream objectInputStream2 = new ObjectInputStream(fileInputStream2);
        Entity entity2= (Entity)objectInputStream2.readObject();
        System.out.println(entity1 == entity2);

    }
}
