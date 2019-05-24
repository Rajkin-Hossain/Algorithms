public class MergeSort {
	
	long [] L = new long[1000000];
    long [] R = new long[1000000];
    
    long [] array = {8, -100, 7, 5, 4};
    
    void merge(int l, int m, int r){
    	int n1 = m-l+1;
    	int n2 = r-m;
    	
    	for(int i = 0; i<n1; i++){
    		L[i] = array[l + i];
    	}
    	
    	for(int j = 0; j<n2; j++){
    		R[j] = array[m + 1 + j];
    	}
    	
    	int i = 0, j = 0, k = l;
    	
    	while(i < n1 && j < n2){
    		if(L[i] <= R[j]){
    			array[k++] = L[i++];
    		}
    		else{
    			array[k++] = R[j++];
    		}
    	}
    	
    	while(i < n1){
    		array[k++] = L[i++];
    	}
    	
    	while(j < n2){
    		array[k++] = R[j++];
    	}
    }
    
    void mergeSort(int l, int r){
    	if(l < r){
    		int m = (l + r) / 2;
    		
    		mergeSort(l, m);
    		mergeSort(m+1, r);
    		
    		merge(l, m, r);
    	}
    }
	
	void startAlgorithm(){
		mergeSort(0, array.length-1);
	}
	
	public static void main(String[] args) {
		new MergeSort().startAlgorithm();
	}
}