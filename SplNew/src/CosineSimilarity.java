import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CosineSimilarity {

    public double calculateSimilarity(String filePath1, String filePath2) {
        try {
            Map<String, Integer> termFrequency1 = calculateTermFrequency(filePath1);
            Map<String, Integer> termFrequency2 = calculateTermFrequency(filePath2);

            double dotProduct = calculateDotProduct(termFrequency1, termFrequency2);
            double magnitude1 = calculateMagnitude(termFrequency1);
            double magnitude2 = calculateMagnitude(termFrequency2);

            return dotProduct / (magnitude1 * magnitude2);
        } catch (IOException e) {
            e.printStackTrace();
            return 0.0; // Return 0 in case of an error
        }
    }

    private Map<String, Integer> calculateTermFrequency(String filePath) throws IOException {
        String content = Files.readString(Path.of(filePath));
        String[] words = content.split("\\s+");

        Map<String, Integer> termFrequency = new HashMap<>();
        for (String word : words) {
            termFrequency.put(word, termFrequency.getOrDefault(word, 0) + 1);
        }

        return termFrequency;
    }

    private double calculateDotProduct(Map<String, Integer> vector1, Map<String, Integer> vector2) {
        double dotProduct = 0.0;

        Set<String> commonWords = vector1.keySet();
        commonWords.retainAll(vector2.keySet());

        for (String word : commonWords) {
            dotProduct += vector1.get(word) * vector2.get(word);
        }

        return dotProduct;
    }

    private double calculateMagnitude(Map<String, Integer> vector) {
        double magnitudeSquared = 0.0;

        for (int frequency : vector.values()) {
            magnitudeSquared += Math.pow(frequency, 2);
        }

        return Math.sqrt(magnitudeSquared);
    }
}
