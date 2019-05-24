public class Trie {
	TrieNode root;
	char [] printChar;
	
	public Trie(){
		root = new TrieNode();
		printChar = new char[20];
	}
	
	public void addWord(char [] y){
		TrieNode cursor = root;
		
		for(int i = 0; i<y.length; i++){
			if(cursor.child[y[i] - 'a'] == null){
				cursor.child[y[i] - 'a'] = new TrieNode();
			}
			
			cursor = cursor.child[y[i] - 'a'];
		}
		
		cursor.isTerminated = true;
	}
	
	public void dfs(TrieNode cursor, int index) {
		if(cursor == null){
			
			return;
		}
		
		if(cursor.isTerminated){
			for(int i = 0; i<index; i++){
				System.out.print(printChar[i]);
			}
			
			System.out.println();
		}
		
		for(int i = 0; i<26; i++){
			printChar[index] = (char)(i + (int)'a');
			
			dfs(cursor.child[i], index+1);
		}
	}
	
	public void addAndPrintWords(){
		Trie trie = new Trie();
		
		trie.addWord("aav".toCharArray());
		trie.addWord("aac".toCharArray());
		trie.addWord("aab".toCharArray());
		trie.addWord("aaav".toCharArray());
		
		trie.addWord("aaa".toCharArray());
		trie.addWord("aaaa".toCharArray());
		
		trie.addWord("aaaaaaaaaz".toCharArray());
		
		trie.dfs(trie.root, 0);
	}
	
	public static void main(String [] args){
		new Trie().addAndPrintWords();
	}
	
	class TrieNode {
		TrieNode [] child;
		boolean isTerminated;
		
		public TrieNode(){
			child = new TrieNode[26];
			isTerminated = false;
		}
	}
}