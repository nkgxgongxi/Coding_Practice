/**
 * Xi Gong
 * Sep 7, 2013
 */

public class LongestPalindrome {
	public static boolean isPalindrome(String s) {
		if(s.length() == 0)
			return false;
		else if(s.length() == 1)
			return true;
		else if(s.length() == 2){
			if(s.charAt(0) == s.charAt(1))
				return true;
			else
				return false;
		}
		else {
			if(s.charAt(0) == s.charAt(s.length() - 1))
				return isPalindrome(s.substring(1, s.length() - 1));
			else 
				return false;
		}
	}
	
	public static String findLongest(String[] arg) {
		String longest = "";
		for(String s : arg) {
			if(isPalindrome(s)) {
				if(s.length() > longest.length()) 
					longest = s;
			}
		}
		return longest;
	}
	
	public static void main(String[] args) {
		String[] t = {"aba", "", "aabbaa", "abb", "cdeflad", "abcba"};
//		System.out.println(t.substring(1, t.length() - 1));
//		for(String s : t) {
//			System.out.println(s + " is palindrome? " + isPalindrome(s));
//		}
		System.out.println(findLongest(t));
	}
}
