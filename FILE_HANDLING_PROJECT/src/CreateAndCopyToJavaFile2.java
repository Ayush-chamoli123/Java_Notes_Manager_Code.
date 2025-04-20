import java.io.*;
public class CreateAndCopyToJavaFile2 {
    public static void main(String[] args){
        try{
            FileWriter fw = new FileWriter("JavaFile2.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("this is the first line in this javaFile2.txt file");
            bw.newLine();
            bw.close();

            BufferedReader br = new BufferedReader(new FileReader("JavaFile1.txt"));
            FileWriter fwAppend = new FileWriter("JavaFile2.txt",true);
            BufferedWriter bwAppend = new BufferedWriter(fwAppend);
            String line;
            while((line = br.readLine()) != null){
                bwAppend.write(line);
                bwAppend.newLine();
            }
            br.close();
            bwAppend.close();
            System.out.println("Content from javaFile1.txt hasd been appended to JavaFile1.txt");


        }
        catch(IOException e){
            System.out.println("Erro during file copy");
            e.printStackTrace();
        }
    }
}
