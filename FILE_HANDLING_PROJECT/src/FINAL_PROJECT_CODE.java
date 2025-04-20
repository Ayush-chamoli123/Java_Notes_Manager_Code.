import java.io.*;
import java.util.Scanner;

public class FINAL_PROJECT_CODE {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n====== Java Notes Manager ======");
            System.out.println("1. Create Note (JavaFile1.txt or JavaFile2.txt)");
            System.out.println("2. Display Note");
            System.out.println("3. Copy JavaFile1.txt to JavaFile2.txt");
            System.out.println("4. Analyze JavaFile1.txt");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: createNote(); break;
                case 2: displayNote(); break;
                case 3: copyFile1ToFile2(); break;
                case 4: analyzeFile(); break;
                case 5: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 5);
    }
    static void createNote() {
        try {
            System.out.print("Enter filename (JavaFile1.txt / JavaFile2.txt): ");
            String filename = scanner.nextLine();

            System.out.println("Enter content for " + filename + " (type 'end' to finish):");
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));

            while (true) {
                String line = scanner.nextLine();
                if (line.equalsIgnoreCase("end")) break;
                writer.write(line);
                writer.newLine();
            }

            writer.close();
            System.out.println("Note saved successfully!");

        } catch (IOException e) {
            System.out.println("Error writing to file.");
            e.printStackTrace();
        }
    }

    // Step 2: Display Note
    static void displayNote() {
        try {
            System.out.print("Enter filename to display: ");
            String filename = scanner.nextLine();

            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            System.out.println("\n--- Content of " + filename + " ---");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();

        } catch (IOException e) {
            System.out.println("Error reading file.");
            e.printStackTrace();
        }
    }

    // Step 3: Copy JavaFile1.txt → JavaFile2.txt
    static void copyFile1ToFile2() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("JavaFile2.txt", true));
            BufferedReader reader = new BufferedReader(new FileReader("JavaFile1.txt"));

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            reader.close();
            writer.close();
            System.out.println("Content from JavaFile1.txt appended to JavaFile2.txt");

        } catch (IOException e) {
            System.out.println("Error during file copy.");
            e.printStackTrace();
        }
    }

    // Step 4: Analyze JavaFile1.txt
    static void analyzeFile() {
        String filename = "JavaFile1.txt";
        String wordToSearch = "polymorphism";
        int lineCount = 0, wordCount = 0, charCount = 0, totalOccurrences = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;

            while ((line = reader.readLine()) != null) {
                lineCount++;
                charCount += line.length();

                String[] words = line.split("\\s+");
                wordCount += words.length;

                if (line.toLowerCase().contains(wordToSearch.toLowerCase())) {
                    System.out.println("Word '" + wordToSearch + "' found at line: " + lineCount);
                }

                for (String word : words) {
                    word = word.replaceAll("[^a-zA-Z]", ""); // remove punctuation
                    if (word.equalsIgnoreCase(wordToSearch)) {
                        totalOccurrences++;
                    }
                }
            }

            reader.close();

            System.out.println("\n--- Analysis of JavaFile1.txt ---");
            System.out.println("Total Characters: " + charCount);
            System.out.println("Total Words: " + wordCount);
            System.out.println("Total Lines: " + lineCount);
            System.out.println("Total Occurrences of '" + wordToSearch + "': " + totalOccurrences);

        } catch (IOException e) {
            System.out.println("Error reading file.");
            e.printStackTrace();
        }
    }
}
