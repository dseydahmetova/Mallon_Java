package io;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

public class NioChannelBufferRead {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("/files", "Alice.txt");
        FileChannel channel = FileChannel.open(path);

        ByteBuffer charBuffer = ByteBuffer.allocate(256);

        int amount = 0;
        do {
            amount = channel.read(charBuffer);
            String s = new String(charBuffer.array(), StandardCharsets.UTF_8);

            
        }while(amount > 0);



    }
}
