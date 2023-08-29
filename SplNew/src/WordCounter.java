import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordCounter {
    public static Map<String, Integer> countWords(String filePath) {
        Map<String, Integer> wordCountMap = new HashMap<>();
        int totalWords = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");

                for (String word : words) {
                    word = word.replaceAll("[^a-zA-Z]", ""); // Remove non-letter characters
                    word = word.toLowerCase(); // Convert to lowercase for case-insensitive counting

                    if (word.length() > 1) { // Exclude single-character words
                        totalWords++; // Increment total words counter

                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Total number of words in the file: " + totalWords);
        return wordCountMap;
    }
}
