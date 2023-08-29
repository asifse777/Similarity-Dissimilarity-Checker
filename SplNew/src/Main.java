import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        String filePath1 = null;
        String filePath2 = null;
        String textFilePath1 = null;
        String textFilePath2 = null;

        while (running) {
            System.out.println("Choose an option:");
            System.out.println("1. Work with text files");
            System.out.println("2. Work with java files");
            System.out.println("3. Stop the program");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    //    if (textFilePath1 == null || textFilePath2 == null) {
                    System.out.println("Enter the path to the first text file:");
                    textFilePath1 = scanner.nextLine();

                    System.out.println("Enter the path to the second text file:");
                    textFilePath2 = scanner.nextLine();
                    //     }
                    if (!textFilePath1.endsWith(".txt") || !textFilePath2.endsWith(".txt"))
                    {
                        System.out.println("Invalid file format....");
                        break;
                    }

                    while (true) {
                        System.out.println("Choose an option:");
                        System.out.println("1. Check similarities and dissimilarities");
                        System.out.println("2. Count words in both files");
                        System.out.println("3. Back to main menu");
                        int textOption = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline

                        switch (textOption) {
                            case 1:
                                System.out.println("Choose the comparison algorithm:");
                                System.out.println("1. Cosine Similarity");
                                System.out.println("2. LCS Similarity");
                                System.out.println("3. Levenshtein Similarity");
                                System.out.println("4. Cancel and go back to the main menu");
                                int algoChoice = scanner.nextInt();
                                scanner.nextLine(); // Consume the newline

                                if (algoChoice == 5) {
                                    break;
                                }

                                double similarity = 0.0;

                                switch (algoChoice) {
                                    case 1:
                                        CosineSimilarity cosineSimilarity = new CosineSimilarity();
                                        similarity = cosineSimilarity.calculateSimilarity(textFilePath1, textFilePath2);
                                        break;

                                    case 2:
                                        LCSSimilarity lcsSimilarity = new LCSSimilarity();
                                        similarity = lcsSimilarity.calculateSimilarity(textFilePath1, textFilePath2);
                                        break;
                                    case 3:
                                        LevenshteinDistance levenshteinDistance = new LevenshteinDistance();
                                        similarity = levenshteinDistance.calculateSimilarity(textFilePath1,textFilePath2);
                                        break;
                                    default:
                                        System.out.println("Invalid algorithm choice");
                                        continue;
                                }

                                double dissimilarity = 1 - similarity;
                                double sim=similarity*100;
                                double dis=dissimilarity*100;
                                System.out.println("Chosen Similarity: " +String.format("%.2f",sim) +"%");
                                System.out.println("Chosen Similarity: " +String.format("%.2f",dis) +"%");
                                break;

                            case 2:
                                Map<String, Integer> wordCountMap1 = WordCounter.countWords(textFilePath1);
                                Map<String, Integer> wordCountMap2 = WordCounter.countWords(textFilePath2);

                                System.out.println("Word counts in the first file:");
                                for (Map.Entry<String, Integer> entry : wordCountMap1.entrySet()) {
                                    System.out.println(entry.getKey() + ": " + entry.getValue());
                                }

                                System.out.println("Word counts in the second file:");
                                for (Map.Entry<String, Integer> entry : wordCountMap2.entrySet()) {
                                    System.out.println(entry.getKey() + ": " + entry.getValue());
                                }
                                break;

                            case 3:
                                break;

                            default:
                                System.out.println("Invalid choice");
                                break;
                        }

                        System.out.println("Do you want to continue working with text files? (yes/no):");
                        String continueChoice = scanner.nextLine();
                        if (!continueChoice.equalsIgnoreCase("yes")) {
                            break;
                        }
                    }
                    break;


                case 2:
                    //    if (filePath1 == null || filePath2 == null) {
                    System.out.println("Enter the path to the first Java file:");
                    filePath1 = scanner.nextLine();

                    System.out.println("Enter the path to the second Java file:");
                    filePath2 = scanner.nextLine();
                    //     }
                    if (!filePath1.endsWith(".java") || !filePath2.endsWith(".java"))
                    {
                        System.out.println("Invalid file format.....");
                        break;
                    }

                    while (true) {
                        System.out.println("Choose an option:");
                        System.out.println("1. Compare class count");
                        System.out.println("2. Compare method count");
                        System.out.println("3. Compare line count");
                        System.out.println("4. Similarity and Dissimilarity checking");
                        System.out.println("5. Back to main menu");
                        int javaOption = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline

                        switch (javaOption) {
                            case 1:
                                int classCount1 = JavaClassCounter.countClasses(filePath1);
                                int classCount2 = JavaClassCounter.countClasses(filePath2);

                                System.out.println("Class count in the first Java file: " + classCount1);
                                System.out.println("Class count in the second Java file: " + classCount2);
                                break;
                            case 2:
                                int methodCount1 = JavaMethodCounter.countMethods(filePath1);
                                int methodCount2 = JavaMethodCounter.countMethods(filePath2);

                                System.out.println("Method count in the first Java file: " + methodCount1);
                                System.out.println("Method count in the second Java file: " + methodCount2);
                                break;
                            case 3:
                                int lineCount1 = JavaLineCounter.countLines(filePath1);
                                int lineCount2 = JavaLineCounter.countLines(filePath2);

                                System.out.println("Line count in the first Java file: " + lineCount1);
                                System.out.println("Line count in the second Java file: " + lineCount2);
                                break;
                            case 4:
                                System.out.println("Choose the comparison algorithm:");
                                System.out.println("1. Cosine Similarity");
                                System.out.println("2. LCS Similarity");
                                System.out.println("3. Levenshtein Similarity");
                                System.out.println("4. Cancel and go back to the main menu");
                                int algoChoice = scanner.nextInt();
                                scanner.nextLine();

                                if (algoChoice == 5) {
                                    break;
                                }

                                double similarity = 0.0;

                                switch (algoChoice) {
                                    case 1:
                                        CosineSimilarity cosineSimilarity = new CosineSimilarity();
                                        similarity = cosineSimilarity.calculateSimilarity(filePath1, filePath2);
                                        break;

                                    case 2:
                                        LCSSimilarity lcsSimilarity = new LCSSimilarity();
                                        similarity = lcsSimilarity.calculateSimilarity(filePath1, filePath2);
                                        break;
                                    case 3:
                                        LevenshteinDistance levenshteinDistance = new LevenshteinDistance();
                                        similarity = levenshteinDistance.calculateSimilarity(filePath1, filePath2);
                                        break;
                                    default:
                                        System.out.println("Invalid algorithm choice");
                                        continue;
                                }

                                double dissimilarity = 1 - similarity;
                                double sim=similarity*100;
                                double dis=dissimilarity*100;

                                System.out.println("Chosen Similarity: "+ String.format("%.2f",sim)+"%");
                                //System.out.print("%.2f",sim);
                                System.out.println("Chosen Similarity: "+ String.format("%.2f",sim)+"%");
                                break;
                            case 5:
                                break;
                            default:
                                System.out.println("Invalid choice");
                                break;
                        }

                        System.out.println("Do you want to continue working with Java files? (yes/no):");
                        String continueChoice = scanner.nextLine();
                        if (!continueChoice.equalsIgnoreCase("yes")) {
                            break;
                        }
                    }
                    break;
                case 3:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }

        System.out.println("Program stopped.");
        scanner.close();
    }
}
