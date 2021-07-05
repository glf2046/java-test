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
public class TcpTimeServerMultipleThread {
    public static void main(String[] args) throws InterruptedException {
        int port = 8913;

        try (ServerSocket serverSocket = new ServerSocket(port)) {

            System.out.println("Server is listening on port " + port);

            while (true) {
                final Socket socket = serverSocket.accept();
                 Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            handleRequest(socket);
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
                 
                 thread.start();
            }

        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private static void handleRequest(Socket socket) throws IOException, InterruptedException {

        System.out.println("New client connected, socket: " + socket.hashCode());

        OutputStream output = socket.getOutputStream();
        PrintWriter writer = new PrintWriter(output, true);

        writer.println(new Date().toString());
        writer.flush();
        writer.close();

        Thread.sleep(5000);
        System.out.println("socket closed: " + socket.hashCode());
    }
}
