import java.net.InetSocketAddress;

public class RPCTest {
    public static void main(String[] args) {

        HelloService service = RpcClient.getRemoteProxyObj(HelloService.class, new InetSocketAddress("localhost", 8089));
        System.out.println("done get server delegate object");
        System.out.println(service.sayHi("test"));
    }
}
