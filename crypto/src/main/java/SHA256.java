import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256 {
    public static void main(String[] args) throws NoSuchAlgorithmException, DigestException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        System.out.println(md.getAlgorithm());
        System.out.println(md.getProvider());
        System.out.println(md.getDigestLength());
        
        String msg = "hello world";
        System.out.println(byte2hex(md.digest(msg.getBytes())));

        sha256();
        sha512();
    }

    private static void sha256() throws NoSuchAlgorithmException {

        String toChapter1 = "hello world";

        MessageDigest md = MessageDigest.getInstance("SHA-256");

        md.update(toChapter1.getBytes());
        System.out.println(byte2hex(md.digest()));

    }

    private static void sha512() throws NoSuchAlgorithmException {

        String toChapter1 = "hello world";

        MessageDigest md = MessageDigest.getInstance("SHA-512");

        md.update(toChapter1.getBytes());
        System.out.println(byte2hex(md.digest()));

    }

    private static void sha1() throws NoSuchAlgorithmException {

        String toChapter1 = "hello world";

        MessageDigest md = MessageDigest.getInstance("SHA-1");

        md.update(toChapter1.getBytes());
        System.out.println(byte2hex(md.digest()));

    }

    private static void md5() throws NoSuchAlgorithmException {

        String toChapter1 = "hello world";

        MessageDigest md = MessageDigest.getInstance("MD5");

        md.update(toChapter1.getBytes());
        System.out.println(byte2hex(md.digest()));

    }

    private static String byte2hex(byte[] b) {
        StringBuilder hs = new StringBuilder();
        String temp;
        for (int n = 0; b != null && n < b.length; n++) {
            temp = Integer.toHexString(b[n] & 0XFF);
            if (temp.length() == 1)
                hs.append('0');
            hs.append(temp);
        }
        return hs.toString().toUpperCase();
    }
}
