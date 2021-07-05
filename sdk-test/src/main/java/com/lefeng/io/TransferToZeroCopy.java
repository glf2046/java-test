package com.lefeng.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author guff
 * @since 2020-01-24 04:46
 */
//https://www.ibm.com/developerworks/cn/java/j-zerocopy/
public class TransferToZeroCopy {
    public static void main(String[] args) throws IOException {
        File source = File.createTempFile("source", null);
        source.deleteOnExit();

        FileChannel sourceChannel = new RandomAccessFile(source, "rw").getChannel();
        sourceChannel.position(32000L).write(ByteBuffer.wrap("The End".getBytes()));

        // The sink is a non-blocking socket channel
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.socket().bind(new InetSocketAddress(9250));
        InetSocketAddress sa = new InetSocketAddress(
                InetAddress.getLocalHost(), ssc.socket().getLocalPort());
        SocketChannel sink = SocketChannel.open(sa);

        sink.configureBlocking(false);
        SocketChannel other = ssc.accept();
        System.out.println("server started");
        System.out.println("Accepted request from: " + other.getLocalAddress());

        long size = sourceChannel.size();

        // keep sending until congested
        long n;
        do {
            n = sourceChannel.transferTo(0, size, sink);
        } while (n > 0);

        byte[] bytes = new byte[1024];
        sink.socket().getInputStream().read(bytes);
        System.out.println(String.valueOf(bytes));

        sourceChannel.close();
        sink.close();
        other.close();
        ssc.close();
        source.delete();

    }
}
