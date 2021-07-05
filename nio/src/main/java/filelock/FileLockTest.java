package filelock;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class FileLockTest {
    public static void main(String[] args) throws InterruptedException, IOException, URISyntaxException {
        File file = new File(FileLockTest.class.getResource("/write.txt").toURI());
        FileInputStream fis = new FileInputStream(file);
        FileChannel channel = fis.getChannel();
        FileLock fileLock = channel.tryLock(0, 10, false);  // true表示是共享锁，false则是独享锁定
        if (fileLock != null) {
            System.out.println("locked");
        }

        Thread.sleep(100000);
    }
}
