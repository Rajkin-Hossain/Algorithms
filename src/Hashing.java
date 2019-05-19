public class Hashing {
    long prime = 33;
    long [] primes;
    
    public void computePrimes(){
        primes[1] = prime;
        for(int i = 2; i<primes.length; i++){
            //primes[i] = (primes[i-1] * prime);
            primes[i] = (primes[i-1] << (long) 5) + primes[i-1];
        }
    }
    
    public long getHash(String name){
        long hash = 0;
        for(int i = 0; i<name.length(); i++){
            //hash = (hash * prime) + name.charAt(i);
            hash = ((hash << (long)5) + hash) + name.charAt(i);
        }
        
        return hash;
    }
    
    public boolean isFound(String text, String pattern) {
    	int textLength = text.length();
    	int patternLength = pattern.length();

        primes = new long[textLength + 1];
        computePrimes();
        
        long requiredHash = getHash(pattern);
        long [] prefixHashes = new long[textLength];
        
        long hash = 0;
        for(int i = 0; i<Math.min(textLength, patternLength); i++){
            //hash = (hash * prime) + A.charAt(i);
            hash = ((hash << (long)5) + hash)  + text.charAt(i);
            prefixHashes[i] = hash;
        }
        
        if(requiredHash == hash) return true;
        
        int start = 0;
        for(int i = Math.min(textLength, patternLength); i<textLength; i++){
            //hash = (hash * prime) + A.charAt(i);
            hash = ((hash << (long)5) + hash)  + text.charAt(i);
            
            prefixHashes[i] = hash;
            
            if((hash - (prefixHashes[start] * primes[patternLength])) == requiredHash) {
            	return true;
            }
            
            start++;
        }
        
        return false;
    }
}
