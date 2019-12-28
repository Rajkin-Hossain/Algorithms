import java.util.ArrayDeque;

public class StackOperation {
	
    int [] nextBiggerValueIndex;
    int [] array = {1, 4, 3, 5, 1, 8};
	
    public void computeNextBiggerValueIndex(){
        ArrayDeque<Pair> stack = new ArrayDeque<Pair>();
 
        for(int i = 0; i<array.length; i++){
            while(!stack.isEmpty() && array[i] > stack.peek().value){
            	nextBiggerValueIndex[stack.pop().index] = i;
            }
           
            stack.push(new Pair(array[i], i));
        }
       
        while(!stack.isEmpty()){
        	nextBiggerValueIndex[stack.pop().index] = 0;
        }
    }
    
    class Pair {
        int value;
        int index;
 
        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
