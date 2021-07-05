import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerWithObjectInputStream {
    public static void main(String[] args) throws IOException {

        Socket clent = null;
        ServerSocket server = new ServerSocket();
        server.bind(new InetSocketAddress(9250));
        System.out.println("start server");

        while (true) {
            clent = server.accept();
            System.out.println("Accepted request from: " + clent.getInetAddress().getHostAddress());
            ObjectInputStream input = null;
            ObjectOutputStream output = null;
            try {
                input = new ObjectInputStream(clent.getInputStream());
                BufferedInputStream bufferedInputStream = new BufferedInputStream(input);
                byte[] bytes = new byte[1024];
                int num = bufferedInputStream.read(bytes);
                System.out.println("bytes count: " + num);
                System.out.println(new String(bytes));
                output = new ObjectOutputStream(clent.getOutputStream());
                Thread.sleep(2500);
                output.writeObject("test-response");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (output != null) {
                    try {
                        output.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (input != null) {
                    try {
                        input.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (clent != null) {
                    try {
                        clent.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}
