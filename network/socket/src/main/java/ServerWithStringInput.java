import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerWithStringInput {
    public static void main(String[] args) throws IOException {

        Socket clent = null;
        ServerSocket server = new ServerSocket();
        server.bind(new InetSocketAddress(9250));
        System.out.println("start server");

        while (true) {
            clent = server.accept();
            System.out.println("Accepted request from: " + clent.getInetAddress().getHostAddress());
            Scanner input = null;
            ObjectOutputStream output = null;
            try {
                //服务端用的是Scanner,客户端输入可用字符串，比如输入quit
                //所以直接可以用telnet loalhost 9250，然后输入各种字符的换，直到输入quit
                input = new Scanner(clent.getInputStream());
                while (true) {
                    String line = input.nextLine();
                    if (line.equalsIgnoreCase("quit")) {
                        break;
                    }

                    System.out.println("got input: " + line);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (input != null) {
                    input.close();
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
