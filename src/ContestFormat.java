/* Rajkin Hossain */

import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class ContestFormat{
   
    FastInput k = new FastInput(System.in);
    FastOutput z = new FastOutput();
    Template t = new Template();
    
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
    
    class Template {
    	
    	//assume that a and b cannot both be 0
    	long gcd(long a, long b) {
	    	if (b==0) return a;
	    	
	    	return gcd(b,a%b);
    	}
    	
    	long lcm(long a, long b) {
    		
    		return b*a/gcd(a,b);
    	}
    	
    	//assume that a and b cannot both be 0
    	int gcd(int a, int b) {
	    	if (b==0) return a;
	    	
	    	return gcd(b,a%b);
    	}
    	
    	int lcm(int a, int b) {
    		
    		return b*a/gcd(a,b);
    	}
    	
	    HashSet<Integer> generateSet(int [] y) {
			HashSet<Integer> set = new HashSet<Integer>();
			
			for(Integer key : y) {
				set.add(key);
			}
			
			return set;
		}
	    
	    HashSet<Long> generateSet(long [] y) {
			HashSet<Long> set = new HashSet<Long>();
			
			for(Long key : y) {
				set.add(key);
			}
			
			return set;
		}
		
		HashMap<Integer, Integer> generateCountMap(int [] y) {
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			
			for(int key : y) {
				map.putIfAbsent(key, 0);
				map.put(key, map.get(key) + 1);
			}
			
			return map;
		}
		
		HashMap<Long, Integer> generateCountMap(long [] y) {
			HashMap<Long, Integer> map = new HashMap<Long, Integer>();
			
			for(long key : y) {
				map.putIfAbsent(key, 0);
				map.put(key, map.get(key) + 1);
			}
			
			return map;
		}
		
		int [] shrink(int[] a) {
	        int n = a.length;
	        long [] b = new long[n];
	        
	        for (int i = 0; i < n; i++) b[i] = (long) a[i] << 32 | i;
	        
	        shuffleAndSort(b);
	        
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
		
		long [] shrink(long [] a) {
	        int n = a.length;
	        long[] b = new long[n];
	        
	        for (int i = 0; i < n; i++) b[i] = (long) a[i] << 32 | i;
	        
	        shuffleAndSort(b);
	        
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
		
		int getMax(int [] a) {
			int maxValue = Integer.MIN_VALUE;
			
			for(int v : a) {
				maxValue = max(v, maxValue);
			}
			
			return maxValue;
		}
		
		long getMax(long [] a) {
			long maxValue = Long.MIN_VALUE;
			
			for(long v : a) {
				maxValue = max(v, maxValue);
			}
			
			return maxValue;
		}
		
		int getMin(int [] a) {
			int minValue = Integer.MAX_VALUE;
			
			for(int v : a) {
				minValue = min(v, minValue);
			}
			
			return minValue;
		}
		
		long getMin(long [] a) {
			long minValue = Long.MAX_VALUE;
			
			for(long v : a) {
				minValue = min(v, minValue);
			}
			
			return minValue;
		}
		
	    void shuffleAndSort(ArrayList<Integer> a) {
	        Random rnd = new Random();
	        
	        int size = a.size();
	        
	        for (int i = size - 1; i >= 1; i--) {
	            int j = rnd.nextInt(i + 1);
	            int t = a.get(i);
	            a.set(i, a.get(j));
	            a.set(j, t);
	        }
	        
	        Collections.sort(a);
	    }
		
	    void shuffleAndSortLongList(ArrayList<Long> a) {
	        Random rnd = new Random();
	        
	        int size = a.size();
	        
	        for (int i = size - 1; i >= 1; i--) {
	            int j = rnd.nextInt(i + 1);
	            long t = a.get(i);
	            a.set(i, a.get(j));
	            a.set(j, t);
	        }
	        
	        Collections.sort(a);
	    }
		
	    void shuffleAndSort(int [] a) {
	        Random rnd = new Random();
	        
	        for (int i = a.length - 1; i >= 1; i--) {
	            int j = rnd.nextInt(i + 1);
	            int t = a[i];
	            a[i] = a[j];
	            a[j] = t;
	        }
	        
	        Arrays.sort(a);
	    }
	    
	    void shuffleAndSort(long [] a) {
	        Random rnd = new Random();
	        
	        for (int i = a.length - 1; i >= 1; i--) {
	            int j = rnd.nextInt(i + 1);
	            long t = a[i];
	            a[i] = a[j];
	            a[j] = t;
	        }
	        
	        Arrays.sort(a);
	    }
	    
		int[] getIntArray(ArrayList<Integer> list) {
			
			int [] array = new int[list.size()];
			
			int size = array.length;
			
			for(int i = 0; i<size; i++) {
				array[i] = list.get(i);
			}
			
			return array;
		}
		
		long[] getLongArray(ArrayList<Long> list) {
			
			long [] array = new long[list.size()];
			
			int size = array.length;
			
			for(int i = 0; i<size; i++) {
				array[i] = list.get(i);
			}
			
			return array;
		}
	    
        void fill2DArray(int [][] array, int value) {
        	for(int [] singleDimension : array) {
        		Arrays.fill(singleDimension, value);
        	}
        }
        
        void fill2DArray(long [][] array, long value) {
        	for(long [] singleDimension : array) {
        		Arrays.fill(singleDimension, value);
        	}
        }
        
        void fill3DArray(int [][][] array, int value) {
        	for(int [][] seconddimension : array) {
            	for(int [] singleDimension : seconddimension) {
            		Arrays.fill(singleDimension, value);
            	}
        	}
        }
        
        void fill3DArray(long [][][] array, long value) {
        	for(long [][] seconddimension : array) {
            	for(long [] singleDimension : seconddimension) {
            		Arrays.fill(singleDimension, value);
            	}
        	}
        }
        
        void fill4DArray(int [][][][] array, int value) {
        	for(int [][][] thirthdimension : array) {
            	for(int [][] seconddimension : thirthdimension) {
                	for(int [] singleDimension : seconddimension) {
                		Arrays.fill(singleDimension, value);
                	}
            	}
        	}
        }
        
        void fill4DArray(long [][][][] array, long value) {
        	for(long [][][] thirthdimension : array) {
            	for(long [][] seconddimension : thirthdimension) {
                	for(long [] singleDimension : seconddimension) {
                		Arrays.fill(singleDimension, value);
                	}
            	}
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
