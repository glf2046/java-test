import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * @author guff
 * @since 2020-04-07 00:12
 */
public class TcpTimeServer {
    public static void main(String[] args) throws InterruptedException {
//        if (args.length < 1) {
//            return;
//        }

//        int port = Integer.parseInt(args[0]);
        int port = 8913;

        try (ServerSocket serverSocket = new ServerSocket(port)) {

            System.out.println("Server is listening on port " + port);

//            Thread.sleep(20000);
            while (true) {
                Socket socket = serverSocket.accept();

                System.out.println("New client connected, socket: " + socket.hashCode());

                System.out.println("socket keepalive: " + socket.getKeepAlive());

                OutputStream output = socket.getOutputStream();

                PrintWriter writer = new PrintWriter(output, true);

                writer.println("a啊 " + new Date().toString());
                Thread.sleep(10000);
                writer.println("b啊 " + new Date().toString());
//                writer.flush();
//                writer.close();

//                socket.shutdownOutput();
//                socket.close();

                System.out.println("socket closed: " + socket.hashCode());

            }

        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
