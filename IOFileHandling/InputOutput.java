package IOFileHandling;

import Collections.Order;

import java.io.*;
import java.net.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;


public class InputOutput {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("Alice.txt");
        Path myFile = path.toAbsolutePath();
        System.out.println(myFile);
        int wordCount = countWords(String.valueOf(myFile));
        int countHalf = 0;
        Map<String, Integer> frequesncyOfWord = wordFrequency(String.valueOf(myFile));
        for (Map.Entry entry : frequesncyOfWord.entrySet()) {
            if (entry.getKey().equals("half")) {
                countHalf = (int) entry.getValue();
            }
        }
        System.out.println("Total number of words in 'Alice in Wonderland': " + wordCount);
        System.out.println("Total number of the word 'half' is present 21 times: " + countHalf);

    }

    private static int countWords(String myFile) throws IOException {
        int count = 0;

        try (FileReader fr = new FileReader(myFile);
             BufferedReader br = new BufferedReader(fr)) {
            String line = br.readLine();
            while (line != null) {
                String[] words = line.split(" ");
                count++;
                line = br.readLine();
            }
        } catch (IOException e) {
            System.err.println("error reading the file" + e.getMessage());
            return 0;
        }
        return count;
    }

    private static Map<String, Integer> wordFrequency(String myFile) throws IOException {
        Map<String, Integer> wordCountMap = new HashMap<>();
        int count = 0;
//        String allPunctuation = "~!@#$%^*()_+|}{\":?><`=;/.,][-'\\";
        try (FileReader fr = new FileReader(myFile);
             BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    //"\W" Metacharacter in JavaScript is used to find the nonword character i.e.
                    // characters which are not from a to z, A to Z, 0 to 9. It is the same as [^a-zA-Z0-9].
                    word = word.replaceAll("\\W", "").trim().toLowerCase();
                    wordCountMap.put(word, wordCountMap.getOrDefault(word, count) + 1);
                }
            }
        } catch (IOException e) {
            System.err.println("error reading the file" + e.getMessage());
        }
        return wordCountMap;
    }
}

