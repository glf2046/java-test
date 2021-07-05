package filelock;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class EchoClient {
    private static SocketChannel client;
    private static ByteBuffer buffer;
    private static EchoClient instance;

    public static EchoClient start() {
        if (instance == null)
            instance = new EchoClient();

        return instance;
    }

    public static void stop() throws IOException {
        client.close();
        buffer = null;
    }

    private EchoClient() {
        try {
            client = SocketChannel.open(new InetSocketAddress("localhost", 5454));
            buffer = ByteBuffer.allocate(256);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String sendMessage(String msg) {
        ByteBuffer receiveBuffer = ByteBuffer.allocate(100);
        buffer = ByteBuffer.wrap(msg.getBytes());
        System.out.println(new String(buffer.array()).trim());
        String response = null;
        try {
            client.write(buffer);
            buffer.clear();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            client.read(receiveBuffer);
            response = new String(receiveBuffer.array()).trim();
            System.out.println("response=" + response);
            receiveBuffer.clear();
            buffer.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;

    }

    public static void main(String[] args) throws IOException {
        EchoClient client = new EchoClient();
        client.sendMessage("hello");
        client.sendMessage("world");
        stop();
    }
}
