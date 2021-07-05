import com.alibaba.fastjson.JSON;

import java.io.*;

public class FastJsonBasic {
    public static void main(String[] args) throws IOException {

        MyObject myObject = new MyObject();
        myObject.setAge(20);
        myObject.setName("name1");


        String json = JSON.toJSONString(myObject);
        System.out.println(json);

        FileWriter writer = null;
        BufferedWriter bufferedWriter = null;
        try {
            writer = new FileWriter("myobject.json");
            bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(json);
            bufferedWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            assert bufferedWriter != null;
            bufferedWriter.close();

            writer.close();
        }

        FileReader reader = null;
        BufferedReader bufferedReader = null;

        try {
            reader = new FileReader("myobject.json");
            bufferedReader = new BufferedReader(reader);
            StringBuilder builder = new StringBuilder();
            String line = null;
            while((line = bufferedReader.readLine()) != null){
                builder.append(line);
            }

            System.out.println(builder.toString());

            bufferedReader.close();
            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally{
            bufferedReader.close();
            reader.close();
        }

    }

    static class MyObject {
        private int age;
        private String name;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
