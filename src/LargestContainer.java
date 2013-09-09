import java.util.*;

public class LargestContainer {
	/**
	 * @param args
	 */
	public static int maxArea(int[] height) {
		int area = 0;
		class ValueComparator implements Comparator<Integer> {
			Map<Integer, Integer> base;
			public ValueComparator(Map<Integer, Integer> base) {
				this.base = base;
			}
			public int compare(Integer a, Integer b) {
				if(base.get(a) >= base.get(b)) 
					return 1;
				else
					return -1;
			}
		}
		HashMap<Integer, Integer> coord = new HashMap<Integer, Integer>();
		ValueComparator bvc = new ValueComparator(coord);
		TreeMap<Integer, Integer> ordered_coord = new TreeMap<Integer, Integer>(bvc);
		int size = height.length;
		for(int i = 1; i <= size; i++) {
			coord.put(i, height[i - 1]);
		}
		ordered_coord.putAll(coord);
		while(!ordered_coord.isEmpty()) {
			Map.Entry<Integer, Integer> current = ordered_coord.pollFirstEntry();
			int h = current.getValue();
//			System.out.println(h);
			int x = current.getKey();
//			System.out.println(x);
			int distance = 0;
			if(!ordered_coord.isEmpty()) {
				Set<Integer> xValues = ordered_coord.keySet();
				for(int y : xValues) {
					distance = (Math.abs(x - y) > distance)?Math.abs(x - y):distance;
				}
				int temp = h * distance;
				if(temp > area)
					area = temp;
			}
		}
		return area;
	}
	public static int maxArea2(int[] height) {
		int maxArea = 0; 
		int low = 0; 
		int high = height.length - 1;
		while(low < high) {
			maxArea = Math.max(maxArea, (high - low)*Math.min(height[low], height[high]));
			if(height[low] < height[high])
				low++;
			else
				high--;
		}
		return maxArea;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] h = {1,4,1,2};
		System.out.println(maxArea2(h));
	}

}
