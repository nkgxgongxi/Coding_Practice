
public class ITOR {
	public static String itor(int input) {
		String romanNum = "";
		if(input >= 1000) {
//			System.out.println("I am here");
			String pre = "";
			String suf = itor(input%1000);
			for(int i = 1; i <= (input - input%1000)/1000; i++)
				pre = pre.concat("M");
			romanNum = pre + suf;
		}
		else if(input >= 500) {
//			System.out.println("I am here");
			String pre = "";
			String suf = itor(input%100);
			if(input/100 == 9) {pre = pre.concat("CM");}
			else {
				pre = pre.concat("D");
				for(int i = 0; i < input/100 - 5; i++) {pre = pre.concat("C");}
			}
			romanNum = pre + suf;
		}
		else if(input >= 100) {
//			System.out.println("I am here");
			String pre = "";
			String suf = itor(input%100);
			if(input/100 == 4) {pre = pre.concat("CD");}
			else {
				for(int i = 0; i < input/100; i++) {pre = pre.concat("C");}
			}
			romanNum = pre + suf;
		}
		else if(input >= 50) {
//			System.out.println("I am here");
			String pre = "";
			String suf = itor(input%10);
			if(input/10 == 9) {pre = pre.concat("XC");}
			else {
				pre = pre.concat("L");
				for(int i = 0; i < input/10 - 5; i++) {pre = pre.concat("X");}
			}
			romanNum = pre + suf;
		}
		else if(input >= 10) {
//			System.out.println("I am here");
			String pre = "";
			String suf = itor(input%10);
			if(input/10 == 4) {pre = pre.concat("XL");}
			else {
				for(int i = 0; i < input/10; i++) {pre = pre.concat("X");}
			}
			romanNum = pre + suf;
		}
		else if(input > 5) {
//			System.out.println("I am here");
			String pre = "";
			if(input/10 == 9) {pre = pre.concat("IX");}
			else {
				pre = pre.concat("V");
				for(int i = 0; i < input - 5; i++) {pre = pre.concat("I");}
			}
			romanNum = pre;
		}
		else if(input > 0) {
//			System.out.println("I am here");
			String pre = "";
			if(input == 4) {pre = pre.concat("IV");}
			else {
				for(int i = 0; i < input; i++) {pre = pre.concat("I");}
			}
			romanNum = pre;		
//			System.out.println(pre);
		}
		else {
			romanNum = "";
		}
		
		return romanNum;
	}
	
	public static int rtoi(String input) {
		int value = 0;
		if(input.startsWith("CM")) {
			value += 900;
			value += rtoi(input.substring(2));
		}
		else if(input.startsWith("M")) {
			value += 1000; 
			value += rtoi(input.substring(1));
		}
		else if(input.startsWith("CD")) {
			value += 400;
			value += rtoi(input.substring(2));
		}
		else if(input.startsWith("D")) {
			value += 500;
			value += rtoi(input.substring(1));
		}
		else if(input.startsWith("C")) {
			value += 100;
			value += rtoi(input.substring(1));
		}
		else if(input.startsWith("XC")) {
			value += 90;
			value += rtoi(input.substring(2));
		}
		else if(input.startsWith("L")) {
			value += 50;
			value += rtoi(input.substring(1));
		}
		else if(input.startsWith("X")) {
			value += 10;
			value += rtoi(input.substring(1));
		}
		else if(input.startsWith("IX")) {
			value += 9;
			value += rtoi(input.substring(2));
		}
		else if(input.startsWith("V")) {
			value += 5;
			value += rtoi(input.substring(1));
		}
		else if(input.startsWith("I")) {
			value += 1;
			value += rtoi(input.substring(1));
		}
		else {
//			System.out.println("Invalid output.");
			
		}
		return value;
	}
	public static void main(String[] args){
		int input = 2008;
		System.out.println(itor(input));
		String input2 = "I";
		System.out.println(rtoi(input2));
	}
}
