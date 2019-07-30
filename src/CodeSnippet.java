import java.util.*;
public class CodeSnippet {
	
	int[] getArray(ArrayList<Integer> list) {
		int [] array = new int[list.size()];
		for(int i = 0; i<list.size(); i++) {
			array[i] = list.get(i);
		}
		
		return array;
	}
	
	void sortInReverseOrder(Integer [] array) {
		Arrays.sort(array, Comparator.reverseOrder());
	}
	
	PriorityQueue<Integer> getReverseOrderPriorityQueue() {
		return new PriorityQueue<>(Collections.reverseOrder());
	}
}
