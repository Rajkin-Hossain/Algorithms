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
	
	void SortWithComparator(ArrayList<Pair> intervals) {
        Collections.sort(intervals, new Comparator<Pair>() {
            
        	// Current is actually this
        	// if you need to return current just direct use -1
        	// if you need to return next just direct use 1
        	
        	/* if Pair class has Wrapper class 
        	 	If you need to return current you can use like current.compareTo(next)
        	 	BE CAREFULL: Wrapper class equality check like == wont work so, 
        	 	use instead equals method for Wrapper class
        	*/
        	
            public int compare(Pair current, Pair next) {
            	
            	// sort based in ascending order
                return current.start - next.start;
            }
        });
	}
	
	class Pair{
		int start, end;

		public Pair(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
}