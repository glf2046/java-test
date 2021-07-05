import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author guff
 * @since 2020-04-13 04:34
 */
public class TcpTimeClientMultipleThread3 {
    public static void main(String[] args) throws IOException, InterruptedException {
//        String hostname = "time.nist.gov";
        final String hostname = "172.20.10.7";
//        final String hostname = "localhost";
//        String hostname = "172.20.10.7";

        final int port = 8913;
//        int port = readPort();
        int requestSend = 0;
        for (int i = 0; i < 656; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    getTime();
                }
            });

            thread.start();
            requestSend++;
            System.out.println("sent request count: " + requestSend);
//            thread.join();
        }

//        Thread.currentThread().join();

    }

    private static int responseCount = 0;

    private static void getTime() {
        for (int i = 0; i < 10; i++) {
            try (Socket socket = new Socket("172.20.10.7", 8913)) {

                InputStream input = socket.getInputStream();
                InputStreamReader reader = new InputStreamReader(input);
                BufferedReader bufferedReader = new BufferedReader(reader);

                StringBuilder response = new StringBuilder();
                String data;
//                while((data = bufferedReader.readLine()) != null){
//                    response.append(data);
//                    System.out.println(response);
//                    responseCount++;
//                    System.out.println("response count: " + responseCount);
//                }

                data = bufferedReader.readLine();
                System.out.println(data);
                responseCount++;
                System.out.println("response count: " + responseCount);

//            Thread.sleep(10000);

            } catch (Exception ex) {
                System.out.println("Server not found: " + ex.getMessage());
            }
        }
    }
}
