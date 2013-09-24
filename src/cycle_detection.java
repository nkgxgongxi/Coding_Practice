import java.io.*;
import java.util.Scanner;

public class cycle_detection {
	public static void main(String[] args)
	{
		File fin = new File(args[0]);
		String Line;
		try{
			Scanner scanner = new Scanner(fin);
			while(scanner.hasNextLine())
			{
				Line = scanner.nextLine();
				String[] parses = Line.split(" ");
				int size = parses.length;
				Num[] numbers = new Num[size];
				for(int i = 0; i< size; i++)
				{
					int value = Integer.parseInt(parses[i]);
					numbers[i] = new Num(value, i);
				}
				for(int i = 0; i < size; i++)
				{
					if(numbers[i].isTested == false)
					{
						boolean result = numbers[i].detectCycle(numbers);
						if(result == true)
							break;
					}
				}
			}
			scanner.close();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
}

class Num{
	int Value;
	int Index;
	boolean isTested;
	
	public Num(int k, int counter)
	{
		Value = k;
		Index = counter;
		isTested = false;
	}
	public boolean detectCycle(Num n[])
	{
		boolean found = false;
		for(int k = this.Index + 1; k < n.length;)
		{
			int index = this.findNext(n, k);
			if(index != -1 && index < n.length)
			{
				int res = this.findNextSeq(n, index);
//				System.out.println("The length of the sequence is " + res);
				if(res == -1)
				{
					k = index + 1;
				}
				else
				{
					for(int i = 0; i < res; i++)
					{
						System.out.printf("%d ", n[this.Index + i].Value);
					}
					System.out.print("\n");
					found = true;
					return found;
				}
			}
			else
				return found;
			
		}
		return found;
		
	}
	private int findNext(Num n[], int k)
	{
		for(int j = k; j < n.length; j++)
		{
			if(n[j].Value == this.Value)
				return j;
		}
		return -1;
	}
	private int findNextSeq(Num n[], int index)
	{
		int seqLen = 2;
		int startIndex = this.Index;
		if(n[startIndex + 1].Value != n[index + 1].Value)
		{
			n[index + 1].isTested = true;
			return -1;
		}
		else
		{
			int k = 2;
			while(((startIndex + k) < n.length)&&((index + k) < n.length)&&(n[startIndex + k].Value == n[index + k].Value))
			{
				seqLen++;
				k++;
			}
			return seqLen;
		}
			
	}
}

