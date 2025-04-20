import java.io.*;
public class ReadJavaFile1 {
    public static void main(String[] args){
        try {
            File file = new File("JavaFile1.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            System.out.println("content of javaFile1.txt:\n");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        }
        catch(IOException e){
            System.out.println("Error unable to read the file");
            e.printStackTrace();
        }

   }
}
