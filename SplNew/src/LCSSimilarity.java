import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class LCSSimilarity {
    public double calculateSimilarity(String project1Path, String project2Path) {
        String text1 = readFile(project1Path);
        String text2 = readFile(project2Path);

        int lcsLength = calculateLCSLength(text1, text2);

        int maxLength = Math.max(text1.length(), text2.length());

        if (maxLength == 0) {
            return 0.0; // Avoid division by zero
        }

        return (double) lcsLength / maxLength;
    }

    private String readFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    private int calculateLCSLength(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[text1.length()][text2.length()];
    }
}
