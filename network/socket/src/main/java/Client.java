import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        InetSocketAddress addr = new InetSocketAddress("localhost", 9250);
        Socket socket = null;
        ObjectOutputStream output = null;

        //服务端使用ObjectInputStream获得输入，客户端必须用ObjectOutputStream来交互
        ObjectInputStream input = null;
        try {
            // 2.创建Socket客户端，根据指定地址连接远程服务提供者
            socket = new Socket();
            socket.connect(addr);
//            socket.setSoTimeout(2000);

            // 3.将远程服务调用所需的接口类、方法名、参数列表等编码后发送给服务提供者
            output = new ObjectOutputStream(socket.getOutputStream());

            output.write("test-request".getBytes());
            output.flush();                                                                                                    

            // 4.同步阻塞等待服务器返回应答，获取应答后返回
            input = new ObjectInputStream(socket.getInputStream());
            System.out.println("returned object: " + input.readObject());
            System.out.println();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            if (socket != null) socket.close();
            if (output != null) output.close();
            if (input != null) input.close();
        }
    }
}
