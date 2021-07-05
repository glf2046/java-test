package com.lefeng.socket;

import java.io.*;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.net.Socket;

public class SocketClient {
    public static void main(String[] args) {
        try {

            RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
            System.out.println(runtimeMXBean.getName());
            int id = Integer.valueOf(runtimeMXBean.getName().split("@")[0]);
            System.out.println(id);

            
            Socket socket  = new Socket("192.168.59.3", 8090);
            InputStream inputStream = socket.getInputStream();
            OutputStream stream = socket.getOutputStream();
            String s = id + " hello world 200";
            stream.write(s.getBytes());
            stream.flush();
            socket.shutdownOutput();

            System.out.println(new BufferedReader(new InputStreamReader(inputStream)).readLine());
            socket.close();

            Thread.sleep(30000);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
