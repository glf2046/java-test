import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * @author guff
 * @since 2020-04-28 21:08
 */
public class InetAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        System.out.println("##################");
        System.out.println(InetAddress.getAllByName("faceid.tencentcloudapi.com")[0].getCanonicalHostName());
        System.out.println(InetAddress.getAllByName("faceid.tencentcloudapi.com")[0].getHostName());
        System.out.println(InetAddress.getAllByName("faceid.tencentcloudapi.com")[0].getHostAddress());
        System.out.println(Arrays.toString(InetAddress.getAllByName("faceid.tencentcloudapi.com")[0].getAddress()));

        InetSocketAddress inetSocketAddress = new InetSocketAddress(1234);
        System.out.println(inetSocketAddress.getHostName());
    }
}
