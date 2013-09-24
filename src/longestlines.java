import java.io.*;
import java.util.*;

public class longestlines {
	public static void main(String[] args) throws FileNotFoundException
	{
		int n = 0;
		String Line;
		File fin = new File(args[0]);
		try {

            Scanner scanner = new Scanner(fin);
            n = Integer.parseInt(scanner.nextLine());
            while (scanner.hasNextLine()) {
                Line = scanner.nextLine();
                ALine newLine = new ALine(Line);
                newLine.Insert();
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }           
		ALine.PrintList(n);		
	}
}

class ALine{
	private static ALine Lines = null;
	String Value;
	int Length;
	ALine Next;
	
	public ALine(String s)
	{
		Value = s;
		Length = s.length();
		Next = null;
	}
	
	public static ALine Head()
	{
		return Lines;
	}
	
	public void Insert()
	{
		if(Lines == null)
		{
			Lines = this;
			return;
		}
		if(Length > Lines.Length)
		{
			Next = Lines;
			Lines = this;
			return;
		}
		else if (Lines.Next == null)
		{
			Lines.Next = this;
			return;
		}
		for (ALine L = Lines; L.Next != null; L = L.Next)
		{
			if(Length > L.Next.Length)
			{
				Next = L.Next;
				L.Next = this;
				return;
			}
			else if (L.Next.Next == null)
			{
				L.Next.Next = this;
				return;
			}
		}
	}
	
	public static void PrintList(int k)
	{
		if(Lines == null)
		{
			return;
		}
		ALine Recv = Lines;
		for (int i = 0; i < k; i++)
		{
			System.out.println(Recv.Value);
			Recv = Recv.Next;
		}
	}
}
