package io;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class IoFileReader {
    public static void main(String[] args) throws IOException {
        final String path = "C:\\files\\Alice.txt";

        char[] data = new char[128];
        FileReader fr = new FileReader(path);
        int amountRead = 0;
        LocalTime begin = LocalTime.now();
        do {
            amountRead = fr.read(data, 0, 128);
            String s = new String(data);
            System.out.println(s);
        } while(amountRead > 0); 
        LocalTime end = LocalTime.now();
        fr.close();
        System.out.println(ChronoUnit.MILLIS.between(begin, end));
    }
}
