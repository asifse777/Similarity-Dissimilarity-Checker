import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JavaLineCounter {

    public static int countLines(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            int lineCount = 0;

            while (reader.readLine() != null) {
                lineCount++;
            }

            reader.close();
            return lineCount;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
