package io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class IoFileWriter {
    public static void main(String[] args) throws IOException {
        final String readPath = "C:\\files\\Alice.txt";
        final String writePath = "C:\\files\\Alex.txt";

        FileReader fr = new FileReader(readPath);
        FileWriter fw = new FileWriter(writePath);

        char[] data = new char[128];
        int amountRead = 0;
        LocalTime begin = LocalTime.now();
        do {
            amountRead = fr.read(data, 0, 128);
            fw.write(data);
        } while(amountRead > 0); 
        LocalTime end = LocalTime.now();
        fr.close();
        fw.close();
        System.out.println(ChronoUnit.MILLIS.between(begin, end));

    }
}
