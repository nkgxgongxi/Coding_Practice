
public class ATOI {
	public static int atoi(String s){
		int res = 0;
		boolean isNumber = true;
		boolean isNegative = false;
		if(s.length() == 0)
			return -1;
		if(s.startsWith("-")){
			isNegative = true;
			s = s.substring(1, s.length());
		}
		else{
			if(s.charAt(0) < '0' || s.charAt(0) > '9'){
				isNumber = false;
				return -1;
			}
		}
		int counter = s.length() - 1;
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(0) < '0' || s.charAt(0) > '9'){
				isNumber = false;
				return -1;
			}
//			System.out.println(res);
			res += (int) Math.pow((double) 10, (double) counter)*(s.charAt(i) - 48);
			counter --;
//			System.out.println(res);
		}
		if(isNegative){
			if(res >= Integer.MAX_VALUE)
				return Integer.MIN_VALUE;
			else
				return (0 - res);
		}
		else{
			if(res >= Integer.MAX_VALUE)
				return Integer.MAX_VALUE;
			else
				return res;
		}
	}
	public static void main(String[] args){
		String input = "";
		System.out.println(atoi(input));
	}
}
