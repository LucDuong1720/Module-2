import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            FileReader fileReader = new FileReader("./source.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            int line = 0;
            FileWriter fileWriter = new FileWriter("./target.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            while ((line = bufferedReader.read()) != -1) {
                try {
                    bufferedWriter.write(line);
                } catch (IOException ioException) {
                    System.out.println("Quang Ế");
                }
            }
            bufferedWriter.close();
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

