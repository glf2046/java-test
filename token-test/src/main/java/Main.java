
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;


public class Main {
    public static void main(String[] args) {
        System.out.println(String.valueOf(generalKey().getEncoded()));
    }

    private static SecretKey generalKey(){
        String stringKey = "gulf@tpl.cntaiping.com";
        byte[] encodedKey = Base64.decodeBase64(stringKey);
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }

}
