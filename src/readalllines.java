import java.io.*;
import java.util.Scanner;

public class readalllines {
	public static void main(String[] args) throws IOException {     
        int counter = 0; 
        String line = null;

         // Location of file to read
        File file = new File("longestlines.input");

        try {

            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                System.out.println(line);
                counter++;                    
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }           
        System.out.println(counter);        
    }
}
