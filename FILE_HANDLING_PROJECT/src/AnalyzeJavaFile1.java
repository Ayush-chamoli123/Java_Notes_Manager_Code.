import java.io.*;
public class AnalyzeJavaFile1 {
    public static void main(String[] args){
        String filename = "JavaFile1.txt";
        String wordToSearch = "polymorphism";
        int lineCount=0;
        int wordCount = 0;
        int charCount = 0;
        int foundLines=0;
        int totalOccurrences = 0;
        try{
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while((line = reader.readLine()) != null){
                lineCount++;
                charCount += line.length();
                String[] words = line.split("\\s+");
                wordCount += words.length;

                if(line.toLowerCase().contains(wordToSearch.toLowerCase())){
                    foundLines++;
                    System.out.println("word"+wordToSearch+"found at line:"+lineCount);

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


        }
        catch(IOException e){
            System.out.println("Error reading file. ");
            e.printStackTrace();
        }
    }
}
