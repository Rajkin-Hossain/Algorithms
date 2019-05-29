import java.util.ArrayList;

public class LongestCommonPrefix {
	
    public String longestCommonPrefix(ArrayList<String> A) {
    	Trie trie = new Trie(A.size());
    	for(int i = 0; i<A.size(); i++){
    		trie.addWord(A.get(i).toCharArray());
    	}
    	
    	return trie.longestCommonPrefix;
    }
	
	class Trie {
		TrieNode root;
		String longestCommonPrefix;
		int noOfStrings;
		int longestCommonPrefixMaxLength;
		
		public Trie(int noOfStrings){
			root = new TrieNode();
			this.noOfStrings = noOfStrings;
			longestCommonPrefixMaxLength = 0;
			longestCommonPrefix = "";
		}
		
		public boolean isCapital(char ch){
			return ch >= 'A' && ch <= 'Z';
		}
		
		public void addWord(char [] y){
			TrieNode cursor = root;
			StringBuilder prefix = new StringBuilder("");
			
			for(int i = 0; i<y.length; i++){
				int index = isCapital(y[i]) ? y[i] - 'A' : y[i] - 'a' + 26;
				
				if(cursor.child[index] == null){
					cursor.child[index] = new TrieNode();
				}
				
				cursor = cursor.child[index];
				prefix.append(y[i]);
				cursor.prefixCount++;
				
				if(cursor.prefixCount == noOfStrings){
					if(prefix.length() > longestCommonPrefixMaxLength){
						longestCommonPrefixMaxLength = prefix.length();
						longestCommonPrefix = prefix.toString();
					}
				}
			}
		}

		class TrieNode {
			TrieNode [] child;
			int prefixCount;
			
			public TrieNode(){
				child = new TrieNode[52];
				prefixCount = 0;
			}
		}
	}
}
