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
}
