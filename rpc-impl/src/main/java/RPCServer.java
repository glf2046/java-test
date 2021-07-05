import java.io.IOException;

public class RPCServer {

    public static void main(String[] args) {
        try {
            Server serviceServer = new ServiceCenter(8089);
            serviceServer.register(HelloService.class, HelloServiceImpl.class);
            serviceServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
