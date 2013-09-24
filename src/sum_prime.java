
/**
 * @author patios02
 *
 */
public class sum_prime {
	public static void main(String[] args)
	{
		int count = 1;
		int beginner = 3;
		int sum = 2;
		while(count < 1000)
		{
			if(primeTest(beginner))
			{
				sum += beginner;
				count += 1;
			}
			beginner += 2;
		}
		System.out.println(sum);
	}
	
	protected static boolean primeTest(int n)
	{
		boolean isPrime = false;
		int sqrtRoot = (int)(Math.sqrt((double)n));
		int i = 3;
		while(i <= sqrtRoot)
		{
			if(n%i == 0)
				break;
			else
				i += 2;
		}
		if(i > sqrtRoot)
			isPrime = true;
		return isPrime;
	}
}
