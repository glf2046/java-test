import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @author guff
 * @since 2020-04-07 00:13
 */
public class TcpTimeClient {

    private static Socket[] clients = new Socket[30];

    private final static String hostname = "172.20.10.7";
    private final static int port = 8913;

    public static void main(String[] args) throws Exception {
        for (int i = 1; i <= 30; i++) {
            clients[i-1] = new Socket(hostname, port);
            System.out.println("client connection:" + i);
        }
    }

    private static void connectToServerWithoutTimeout(String hostname, int port) {
        try {
            Socket socket = new Socket(hostname, port);
//            InputStream input = socket.getInputStream();
//            InputStreamReader reader = new InputStreamReader(input);
//            BufferedReader bufferedReader = new BufferedReader(reader);
//
//            StringBuilder response = new StringBuilder();
//            String data;
//            while ((data = bufferedReader.readLine()) != null) {
//                System.out.println(data);
//                response.append(data);
//            }
//
//            System.out.println(response);

//            Thread.sleep(100000);

        } catch (Exception ex) {
            System.out.println("Server not found: " + ex.getMessage());
        }
    }

    private static void connectToServer(String hostname, int connection_time_out, int port) {
        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(hostname, port), connection_time_out);
            InputStream input = socket.getInputStream();
            InputStreamReader reader = new InputStreamReader(input);
            BufferedReader bufferedReader = new BufferedReader(reader);

            StringBuilder response = new StringBuilder();
            String data;
            while ((data = bufferedReader.readLine()) != null) {
                System.out.println(data);
                response.append(data);
            }

            System.out.println(response);

//            Thread.sleep(100000);

        } catch (Exception ex) {
            System.out.println("Server not found: " + ex.getMessage());
        }
    }

//    private static int readPort() throws IOException {
//        FileReader reader = new FileReader("/Users/guff/Dev/java-test/network/src/main/resources/port.txt");
//        BufferedReader bufferedReader = new BufferedReader(reader);
//        String value = bufferedReader.readLine();
//        System.out.println(value);
//        return Integer.valueOf(value);
//    }
}
