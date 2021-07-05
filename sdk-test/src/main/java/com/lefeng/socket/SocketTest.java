package com.lefeng.socket;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

import static com.sun.org.apache.xml.internal.serialize.OutputFormat.Defaults.Encoding;

public class SocketTest {
    public static void main(String[] args) {

        Socket socket;
        String line;

        try (ServerSocket serverSocket = new ServerSocket()) {
            serverSocket.setReceiveBufferSize(1024);
            serverSocket.bind(new InetSocketAddress(8080));
            while(true){
                socket = serverSocket.accept();
                socket.setTcpNoDelay(true);
                StringBuilder sb = new StringBuilder();

                BufferedInputStream stream = new BufferedInputStream(socket.getInputStream());
                InputStreamReader reader = new InputStreamReader(socket.getInputStream(), Encoding);
                BufferedReader  bufferedReader = new BufferedReader(reader);
                while((line = bufferedReader.readLine()) != null){
                    sb.append(line);
                    System.out.println(line);
                }

                OutputStream outputStream = socket.getOutputStream();
                String ack = "ack " + sb;
                outputStream.write(ack.getBytes());
                outputStream.flush();
                outputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
