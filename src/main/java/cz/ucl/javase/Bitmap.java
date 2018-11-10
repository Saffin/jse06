package cz.ucl.javase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bitmap {

    public static void main(String[] args) {
        File bitmapFile = new File("D:/UCL/image.bmp");
        File outputFile = new File("D:/UCL/image2.bmp");
        try {
            byte[] bitmap = Files.readAllBytes(bitmapFile.toPath());
            int index = 54;
            while (index + 2 < bitmap.length) {
                byte red = bitmap[index];
                byte green = bitmap[index + 1];
                byte blue = bitmap[index + 2];
                bitmap[index] = 0;
                bitmap[index + 1] = (byte) 0x77;
                index += 3;
            }
            Files.write(outputFile.toPath(), bitmap);
        } catch (IOException e) {
            e.printStackTrace();
        }

        countWords();
    }

    public static void countWords() {

        File textFile = new File("D:/UCL/text.txt");

        try {
            List<String> lines = Files.readAllLines(textFile.toPath());
            Map<String, Integer> wordCountMap = new HashMap<>();

            for (String line : lines) {
                line = line.replaceAll("[^a-zA-Z]", " ");
                String [] words = line.split(" ");

                for (String word : words) {
                    if (word.length() == 0) {
                        continue;
                    }
                    if (wordCountMap.containsKey(word.toLowerCase())) {
                        int numberOfOccurences = wordCountMap.get(word.toLowerCase());
                        wordCountMap.put(word.toLowerCase(), numberOfOccurences+1);
                    } else {
                        wordCountMap.put(word.toLowerCase(), 1);
                    }
                }
            }
            for (String word : wordCountMap.keySet()) {
                System.out.println(word + ":" + wordCountMap.get(word));
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
