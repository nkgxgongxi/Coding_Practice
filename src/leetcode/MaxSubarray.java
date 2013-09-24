package leetcode;
public class MaxSubarray {	
	public static int getMaxValue(int[] array){
		int current = array[0];
		int index = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i] >= current ) {
				index = i;
				current = array[i];
			}
		}
		return index;
	}
	
	public static int[] getMax(int[] array){
		int[] res;
		if(array.length == 1) {
			res = new int[1];
			res[0] = array[0];
		}
		else {
			int startIndex = 0;
			int endIndex = 0;
			int[] backward = array.clone();
			for(int i = backward.length - 1; i > 0; i--)
				backward[i - 1] = backward[i] + array[i - 1];
			startIndex = getMaxValue(backward);
			int size = array.length - startIndex;
			int[] forward = new int[size];
			forward[0] = array[startIndex];
			for(int i = 1; i < forward.length; i++)
				forward[i] = forward[i - 1] + array[i + startIndex];
			endIndex = startIndex + getMaxValue(forward);
			int resSize = endIndex - startIndex + 1;
			res = new int[resSize];
			for(int i = 0; i < res.length; i++) {
				res[i] = array[i + startIndex];
			}
		}
		return res;
	}
	
	public static int getSum(int[] a) {
		int sum = 0;
		for(int i = 0; i < a.length; i++)
			sum += a[i];
		return sum;
	}
		
	public static void getMaximumSubarray(int[] input) {
		
		int[] res = getMax(input);
		System.out.print("{");
		for(int i = 0; i < res.length - 1; i++)
			System.out.print(res[i] + ",");
		System.out.print(res[res.length - 1] + "}, Sum = " + getSum(res));

		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] input = {2, 5, -3, 4, -25, 11, 7, -2};
		getMaximumSubarray(input);
	}
}
