import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JavaMethodCounter {

    public static int countMethods(String filePath) {
        int methodCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean insideMethod = false;

            while ((line = reader.readLine()) != null) {
                line = line.trim();

                if (line.startsWith("public") || line.startsWith("private") || line.startsWith("protected")) {
                    insideMethod = true;
                }

                if (insideMethod && line.endsWith("}") && !line.contains("{")) {
                    methodCount++;
                    insideMethod = false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return methodCount;
    }
}
