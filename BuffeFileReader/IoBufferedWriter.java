package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class IoBufferedWriter {

    public static void main(String[] args) throws IOException {
        final String readPath = "C:\\files\\Alice.txt";
        final String writePath = "C:\\files\\Alex.txt";

        FileReader fr = new FileReader(readPath);
        FileWriter fw = new FileWriter(writePath);
        BufferedReader br = new BufferedReader(fr);
        BufferedWriter bw = new BufferedWriter(fw);
        char[] data = new char[128];
        int amountRead = 0;
        LocalTime begin = LocalTime.now();
        do {
            amountRead = br.read(data, 0, 128);
            bw.write(data);
        } while(amountRead > 0); 
        LocalTime end = LocalTime.now();
        fr.close();
        fw.close();
        System.out.println(ChronoUnit.MILLIS.between(begin, end));

    }
    
}
