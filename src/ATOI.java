
public class ATOI {
	public int atoi(String s) {
        int res = 0;
		boolean isNegative = false;
        if(s.length() == 0)
            return 0;
		if(s.startsWith("-")){
			isNegative = true;
			s = s.substring(1, s.length());
		}
		else if(s.startsWith("+")){
			isNegative = false;
			s = s.substring(1, s.length());
		}
		else{
			if(s.charAt(0) < '0' || s.charAt(0) > '9'){
				return 0;
			}
		}
		int counter = s.length() - 1;
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(0) < '0' || s.charAt(0) > '9'){
				return 0;
			}
//			System.out.println(res);
			res += (int) Math.pow((double) 10, (double) counter)*(s.charAt(i) - 48);
			counter --;
//			System.out.println(res);
		}
		if(isNegative){
			if(res > Integer.MAX_VALUE)
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
		String input = "-2147483647";
		System.out.println(new ATOI().atoi(input));
	}
}
