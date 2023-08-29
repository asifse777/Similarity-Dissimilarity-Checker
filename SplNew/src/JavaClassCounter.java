import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JavaClassCounter {

    public static int countClasses(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            int classCount = 0;
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.trim().startsWith("public class") || line.trim().startsWith("class")) {
                    classCount++;
                }
            }

            reader.close();
            return classCount;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
