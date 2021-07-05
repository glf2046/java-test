import com.alibaba.fastjson.JSON;

import java.io.*;
import java.util.Map;

public class FastJson {
    public static void main(String[] args) {

        StringBuilder jsonBuilder = new StringBuilder();

        try {
            System.out.println(System.getProperty("user.dir"));
            FileReader reader = new FileReader("target\\classes\\node.json");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while((line=bufferedReader.readLine())!= null){
                jsonBuilder.append(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String json = jsonBuilder.toString();
        System.out.println(json);

        Map<String, Object> map = (Map<String, Object>) JSON.parse(json);
        String applicationName = (String) map.get("applicationName");
        String missionName = (String)map.get("missionName");
        System.out.println(applicationName);
        System.out.println(missionName);

    }
}
