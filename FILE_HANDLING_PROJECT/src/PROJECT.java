//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.*;
public class PROJECT {
    public static void main(String[] args) {
        try{
            String path="JavaFile1.txt";
            File file=new File(path);
            FileWriter fw=new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            String s1 = "Java is an object-oriented programming language.\n" +
                    "It supports encapsulation, inheritance, and polymorphism.\n" +
                    "File handling in Java allows for efficient reading and searching of text.\n" +
                    "Keep learning and mastering Java!\n";
            bw.write(s1);
            bw.close();
            fw.close();
            System.out.println("JAVAFILE has been created");
        }
        catch(IOException e){
            System.out.println("ERROR: unable to write");
            e.printStackTrace();
        }
    }
}