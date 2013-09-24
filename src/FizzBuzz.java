
/**
 * @author patios02
 *
 */
import java.util.Scanner;
import java.io.*;
	
public class FizzBuzz {
    public static void main (String[] args)throws FileNotFoundException
    {
        File file = new File(args[0]);
        Scanner scanner = new Scanner(new FileReader(file));
        while (scanner.hasNextLine()) 
        {
            Scanner recv = new Scanner(scanner.nextLine());
            int Fizz = recv.nextInt();
            int Buzz = recv.nextInt();
            int MaxNum = recv.nextInt();
            int FizzBuzz = Fizz*Buzz;
            recv.close();
            for( int i = 1; i <= MaxNum; i++)
            {
                if(i%Fizz == 0)
                {
                    if(i%FizzBuzz == 0)
                    {
                        System.out.print("FB ");
                    }
                    else
                        System.out.print("F ");  
                }
                else if(i%Buzz == 0)
                    System.out.print("B ");
                else
                    System.out.printf("%d ", i);
            }
            System.out.print("\n");
        }
        scanner.close();
    }
}
