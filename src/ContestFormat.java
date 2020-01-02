/* Rajkin Hossain */

import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class ContestFormat{
   
    FastInput k = new FastInput(System.in);
    FastOutput z = new FastOutput();
    
    void takeInputsFromFile() {
        k = new FastInput("/home/rajkin/Desktop/input.txt");
    }
    
    void startProgram() {
    	takeInputsFromFile();
    	
    	while(k.hasNext()) {
    		
    	}
    	
    	z.flush();
    	System.exit(0);
    }
    
    public static void main(String [] args) throws IOException {
        new Thread(null, new Runnable(){
            public void run(){
            	try{ 
            		new ContestFormat().startProgram();
            	}
            	catch(Exception e){
            		e.printStackTrace();
            	}
            }
        },"Main",1<<28).start();
    }
    
    static class Template {
    	
    	static <E> HashSet<E> generateSet(E [] y) {
    		HashSet<E> set = new HashSet<E>();
    		
    		for(E key : y) {
    			set.add(key);
    		}
    		
    		return set;
    	}
    	
    	static <E> HashMap<E, Integer> generateCountMap(E [] y) {
    		HashMap<E, Integer> map = new HashMap<E, Integer>();
    		
    		for(E key : y) {
    			map.putIfAbsent(key, 0);
    			map.put(key, map.get(key) + 1);
    		}
    		
    		return map;
    	}
    }

    /* MARK: FastInput and FastOutput */
 
    class FastInput {
        BufferedReader reader;
        StringTokenizer tokenizer;
 
        FastInput(InputStream stream){
            reader = new BufferedReader(new InputStreamReader(stream));
        }
       
        FastInput(String path){
            try {
                reader = new BufferedReader(new FileReader(path));
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            tokenizer = null;
        }
 
        String next() {
            return nextToken();
        }
       
        String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
           
            return null;
        }
 
        boolean hasNext(){
            try {
                return reader.ready();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return false;
        }
 
        String nextToken() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                String line = null;
                try {
                    line = reader.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                if (line == null) {
                    return null;
                }
                tokenizer = new StringTokenizer(line);
            }
            return tokenizer.nextToken();
        }
 
        int nextInt() {
            return Integer.parseInt(nextToken());
        }
       
        long nextLong() {
            return Long.valueOf(nextToken());
        }
        
        int [] getInputIntArray(int n) {
        	
        	int [] input = new int[n];
        	
        	for(int i = 0; i<n; i++) {
        		input[i] = nextInt();
        	}
        	
        	return input;
        }
        
        long [] getInputLongArray(int n) {
        	
        	long [] input = new long[n];
        	
        	for(int i = 0; i<n; i++) {
        		input[i] = nextLong();
        	}
        	
        	return input;
        }
        
        int [] getInputIntArrayOneBasedIndex(int n) {
        	
        	int [] input = new int[n+1];
        	
        	for(int i = 1; i<=n; i++) {
        		input[i] = nextInt();
        	}
        	
        	return input;
        }
        
        long [] getInputLongArrayOneBasedIndex(int n) {
        	
        	long [] input = new long[n+1];
        	
        	for(int i = 1; i<=n; i++) {
        		input[i] = nextLong();
        	}
        	
        	return input;
        }
        
        <E> void fill2DArray(E [][] array, E value) {
        	for(int i = 0; i<array.length; i++) {
            	for(int j = 0; j<array[0].length; j++) {
            		array[i][j] = value;
            	}
        	}
        }
        
        <E> void fill3DArray(E [][][] array, E value) {
        	for(int i = 0; i<array.length; i++) {
            	for(int j = 0; j<array[0].length; j++) {
                	for(int k = 0; k<array[0][0].length; k++) {
                		array[i][j][k] = value;
                	}
            	}
        	}
        }
        
        <E> void fill4DArray(E [][][][] array, E value) {
        	for(int i = 0; i<array.length; i++) {
            	for(int j = 0; j<array[0].length; j++) {
                	for(int k = 0; k<array[0][0].length; k++) {
                    	for(int l = 0; l<array[0][0][0].length; l++) {
                    		array[i][j][k][l] = value;
                    	}
                	}
            	}
        	}
        }
    }
 
    class FastOutput extends PrintWriter {
		FastOutput() {
			super(new BufferedOutputStream(System.out)); 
		}
		
		public void debug(Object...obj) {
		    System.err.println(Arrays.deepToString(obj));
		}
    }
}
