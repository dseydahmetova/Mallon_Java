package io;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

public class NioChannelBufferWrite {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("/files", "Alice.txt");
        FileChannel channel = FileChannel.open(path);
        ByteBuffer charBuffer = ByteBuffer.allocate(256);
        int amount = 0;
        do {
            amount = channel.read(charBuffer);
            charBuffer.flip();
            while(charBuffer.hasRemaining()){
                System.out.print((char)charBuffer.get());
            }
            charBuffer.clear();
        }while(amount > 0);
    }
}
