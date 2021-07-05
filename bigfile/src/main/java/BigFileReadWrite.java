import org.apache.commons.lang3.time.StopWatch;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Scanner;

//https://www.jianshu.com/p/44116065fe36
public class BigFileReadWrite {
    /**
     * 读取大文件
     *
     * @param filePath
     */
    public void readFile(String filePath) {
        FileInputStream inputStream = null;
        Scanner sc = null;
        try {
            inputStream = new FileInputStream(filePath);
            sc = new Scanner(inputStream, "UTF-8");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (sc != null) {
                sc.close();
            }
        }
    }

    public void readFileUsingRamdomAccessFile(String filePath) {
        RandomAccessFile randomAccessFile = null;
        try {
             randomAccessFile = new RandomAccessFile(filePath, "r");
            while(randomAccessFile.readLine()!= null){

            }

            randomAccessFile.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(randomAccessFile != null){
                try {
                    randomAccessFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 读取文件
     *
     * @param filePath
     */
    public void readFile2(String filePath, int bufferSizeInMegaBytes) {
        File file = new File(filePath);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file), bufferSizeInMegaBytes * 1024 * 1024);   //如果是读大文件，设置缓存
            String tempString;
            long i = 0;

            while ((tempString = reader.readLine()) != null) {
                i++;

                if (i > 2884386520L)
                    System.out.println(tempString);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void readFileUsingMappedByteBuffer(String filePath) throws IOException {

        RandomAccessFile rafi = new RandomAccessFile(filePath, "r");

        FileChannel fci = rafi.getChannel();
        long size = fci.size();
        MappedByteBuffer mbbi = fci.map(FileChannel.MapMode.READ_ONLY, 0, size);
        for (int i = 0; i < size; i++) {
            byte b = mbbi.get(i);
        }
        fci.close();
    }

    /**
     * 写文件
     *
     * @param filePath
     * @param fileContent
     */
    public void writeFile(String filePath, String fileContent) {
        File file = new File(filePath);
        // if file doesnt exists, then create it
        FileWriter fw = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(fileContent);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    public static void main(String[] args) {
        BigFileReadWrite file = new BigFileReadWrite();
        //file.readFile("D:\\test.txt");
        // file.readFile2("D:\\test.txt");

//        file.writeFile("D:\\test2.txt", "测试写入");

        String filePath = "/Users/guff/Documents/data/data.sql";

        new Thread(()->{
          StopWatch stopWatch = new StopWatch();
          stopWatch.start();

          file.readFile2(filePath, 5);

          stopWatch.stop();
            System.out.println("time spent of thread with 5MB bufferr read2 : " + stopWatch.getTime());
        }).start();


        new Thread(()->{
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();

            file.readFile2(filePath, 100);

            stopWatch.stop();
            System.out.println("time spent of thread with 50MB bufferr read2 : " + stopWatch.getTime());
        }).start();

        new Thread(()->{
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();

            try {
                file.readFileUsingMappedByteBuffer(filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }

            stopWatch.stop();
            System.out.println("time spent of thread of using mapped byte buffer : " + stopWatch.getTime());
        }).start();

        new Thread(()->{
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();

            file.readFile(filePath);

            stopWatch.stop();
            System.out.println("time spent of thread of using scanner : " + stopWatch.getTime());
        }).start();

        new Thread(()->{
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();

            file.readFileUsingRamdomAccessFile(filePath);

            stopWatch.stop();
            System.out.println("time spent of thread of using random access file : " + stopWatch.getTime());
        }).start();
    }
}
