import java.util.*;

public class LargestContainer {
	/**
	 * @param args
	 */
	public int maxArea(int[] height) {
		int area;
		TreeMap<Integer, Integer> coordinates = new TreeMap<Integer, Integer>();
		int size = height.length;
		for(int i = 1; i <= size; i++) {
			coordinates.put(i, height[i - 1]);
		}
		for(int h : height) {
			int x1 = ;
			int x2 = ;
			area = h * (Math.abs(x2 - x1));
		}
		return area;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
