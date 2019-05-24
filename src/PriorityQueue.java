public class PriorityQueue {
	
	Triple [] heap;
	int index;
	
	public PriorityQueue(int size) {
		heap = new Triple[size];
		index = 0;
	}
	
	public void swap(int i, int j) {
		Triple swapValue = heap[i];
		heap[i] = heap[j];
		heap[j] = swapValue;
	}
	
	public boolean compareGreater(int i, int j) {
		if(heap[i].value == heap[j].value) {
			return heap[i].id > heap[j].id;
		}
		
		return heap[i].value > heap[j].value;
	}
	
	public void heapifyAbove(int index) {
		int parent = index >> 1;
		while(parent != 0 && compareGreater(parent, index)) {
			swap(parent, index);
			index = parent;
			parent = index >> 1;
		}
	}
	
	public void heapifyBelow(int index) {
		int left = index << 1;
		int right = left + 1;
		
		if(right > this.index && left > this.index) {
			return;
		}
		else if(right > this.index) {
			// here left didn't crossed range confirm so check only left range
			if(compareGreater(index, left)) {
				swap(index, left);
				heapifyBelow(left);
			}
		}
		else if(left > this.index) {
			// here right didn't crossed range confirm so check only right range
			if(compareGreater(index, right)) {
				swap(index, right);
				heapifyBelow(right);
			}
		}
		else {
			// both left and right are ok. so compare left and right first..
			if(compareGreater(left, right)) {
				if(compareGreater(index, right)){
					swap(index, right);
					heapifyBelow(right);						
				}
			}
			else{
				if(compareGreater(index, left)){
					swap(index, left);
					heapifyBelow(left);						
				}
			}
		}
	}
	
	public void add(Triple triple) {
		// heap array starts from index = 1, make sure of it.. 
		
		index++;
		heap[index] = triple;
		
		heapifyAbove(index);
	}
	
	public Triple poll() {
		Triple returnTriple = heap[1];
		heap[1] = heap[index];
		
		// Make sure you decrement index here..
		index--;
		
		heapifyBelow(1);
		
		return returnTriple;
	}
}

class Triple {
	int id, value, initialValue;

	public Triple(int id, int value, int initialValue) {
		this.id = id;
		this.value = value;
		this.initialValue = initialValue;
	}
}