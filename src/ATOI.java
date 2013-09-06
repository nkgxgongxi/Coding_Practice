public class ATOI {
	public int atoi(String s) {
        long res = 0;
		boolean isNegative = false;
		while(s.length() > 0 && s.startsWith(" ")){
			s = s.substring(1);
		}
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
		int len = 0;
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) >= '0' && s.charAt(i) <= '9')
				len ++;
			else
				break;
		}
		int counter = len - 1;
		for(int i = 0; i < len && len != 0; i++){
			if(s.charAt(i) < '0' || s.charAt(i) > '9'){
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
				return (0 - (int) res);
		}
		else{
			if(res > Integer.MAX_VALUE)
				return Integer.MAX_VALUE;
			else
				return (int) res;
		}
	}
	public static void main(String[] args){
		String input = " b11228552307";
		System.out.println(new ATOI().atoi(input));
	}
}
