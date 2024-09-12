package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class IoBufferedReader {
    public static void main(String[] args) throws IOException {
        final String path = "C:\\files\\Alice.txt";

        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);
        LocalTime begin = LocalTime.now();
        String line = "";
        do {            
            line = br.readLine();
        } while(line != null); 
        LocalTime end = LocalTime.now();
        br.close();
        fr.close();
        System.out.println(ChronoUnit.MILLIS.between(begin, end));
    }
}
