
/**
 * @author patios02
 *
 */

public class prime_palindrome {
	public static void main(String[] args)
	{
		final int MAX = 999;
		boolean find = false;
		int num = MAX;
		while(find == false)
		{
			if(palindromeTest(num))
			{
				find = primeTest(num);
				if(find == true)
				{
					System.out.println(num);
				}
			}
			num -= 2;
		}
	}
	
	protected static boolean palindromeTest(int n)
	{
		boolean isPalindrome = false;
		String num;
		num = Integer.toString(n);
//		System.out.println(num);
		char left = num.charAt(0);
		char right = num.charAt(num.length() - 1);
		if(left == right)
			isPalindrome = true;
			
		return isPalindrome;
	}
	protected static boolean primeTest(int n)
	{
		boolean isPrime = false;
		int sqrtRoot = (int)(Math.sqrt((double)n));
		int i = 3;
		while(i <= sqrtRoot)
		{
//			System.out.println(i);
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
