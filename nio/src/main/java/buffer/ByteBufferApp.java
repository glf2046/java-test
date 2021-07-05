package buffer;

import java.nio.ByteBuffer;

public class ByteBufferApp {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(256);

        System.out.println("buffer, position: " + buffer.position() +
                ", limit: " + buffer.limit() +
                ", capacity: " + buffer.capacity() +
                ", mark: " + buffer.mark());

        buffer.put("hello".getBytes());

        System.out.println("buffer, position: " + buffer.position() +
                ", limit: " + buffer.limit() +
                ", capacity: " + buffer.capacity() +
                ", mark: " + buffer.mark());
        
        buffer.put("-".getBytes());
        buffer.put("world".getBytes());

        System.out.println("buffer, position: " + buffer.position() +
                ", limit: " + buffer.limit() +
                ", capacity: " + buffer.capacity() +
                ", mark: " + buffer.mark());

        System.out.println(new String(buffer.array()).trim());

        buffer.flip();

        System.out.println("buffer, position: " + buffer.position() +
                ", limit: " + buffer.limit() +
                ", capacity: " + buffer.capacity() +
                ", mark: " + buffer.mark());

        byte[] bytes = new byte[buffer.limit()];
        buffer.get(bytes);
        System.out.println(new String(bytes).trim());
    }
}
