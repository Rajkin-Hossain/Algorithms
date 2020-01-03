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
    
    
    /* MARK: Template class implementation */
    
    static class Template {
    
	    static HashSet<Integer> generateSet(int [] y) {
			HashSet<Integer> set = new HashSet<Integer>();
			
			for(Integer key : y) {
				set.add(key);
			}
			
			return set;
		}
		
		static HashMap<Integer, Integer> generateCountMap(Integer [] y) {
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			
			for(Integer key : y) {
				map.putIfAbsent(key, 0);
				map.put(key, map.get(key) + 1);
			}
			
			return map;
		}
		
	    static HashSet<Long> generateSet(long [] y) {
			HashSet<Long> set = new HashSet<Long>();
			
			for(Long key : y) {
				set.add(key);
			}
			
			return set;
		}
		
		static HashMap<Long, Integer> generateCountMap(Long [] y) {
			HashMap<Long, Integer> map = new HashMap<Long, Integer>();
			
			for(Long key : y) {
				map.putIfAbsent(key, 0);
				map.put(key, map.get(key) + 1);
			}
			
			return map;
		}
		
		static int[] shrink(int[] a) {
	        int n = a.length;
	        long[] b = new long[n];
	        for (int i = 0; i < n; i++) b[i] = (long) a[i] << 32 | i;
	        shuffle(b);
	        Arrays.sort(b);
	        int[] ret = new int[n];
	        int p = 0;
	        for (int i = 0; i < n; i++) {
	            if (i > 0 && (b[i] ^ b[i - 1]) >> 32 != 0) p++;
	            ret[(int) b[i]] = p;
	        }
	 
	        for (int i = 0; i < n; i++) {
	            ret[i]++;
	        }
	        return ret;
	    }
		
		static long[] shrink(long [] a) {
	        int n = a.length;
	        long[] b = new long[n];
	        for (int i = 0; i < n; i++) b[i] = (long) a[i] << 32 | i;
	        shuffle(b);
	        Arrays.sort(b);
	        long [] ret = new long[n];
	        int p = 0;
	        for (int i = 0; i < n; i++) {
	            if (i > 0 && (b[i] ^ b[i - 1]) >> 32 != 0) p++;
	            ret[(int) b[i]] = p;
	        }
	 
	        for (int i = 0; i < n; i++) {
	            ret[i]++;
	        }
	        return ret;
	    }
		
	    static void shuffleAndSort(int [] a) {
	        Random rnd = new Random();
	        for (int i = a.length - 1; i >= 1; i--) {
	            int j = rnd.nextInt(i + 1);
	            int t = a[i];
	            a[i] = a[j];
	            a[j] = t;
	        }
	        
	        Arrays.sort(a);
	    }
	    
	    static void shuffleAndSort(long [] a) {
	        Random rnd = new Random();
	        for (int i = a.length - 1; i >= 1; i--) {
	            int j = rnd.nextInt(i + 1);
	            long t = a[i];
	            a[i] = a[j];
	            a[j] = t;
	        }
	        
	        Arrays.sort(a);
	    }
	 
	    static void shuffle(int [] a) {
	        Random rnd = new Random();
	        for (int i = a.length - 1; i >= 1; i--) {
	            int j = rnd.nextInt(i + 1);
	            int t = a[i];
	            a[i] = a[j];
	            a[j] = t;
	        }
	    }
	    
	    static void shuffle(long [] a) {
	        Random rnd = new Random();
	        for (int i = a.length - 1; i >= 1; i--) {
	            int j = rnd.nextInt(i + 1);
	            long t = a[i];
	            a[i] = a[j];
	            a[j] = t;
	        }
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
