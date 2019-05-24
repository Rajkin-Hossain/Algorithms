public class UnionFind {
	
	int [] parent;
	int [] rank;
	
	int size;
	
	public UnionFind(int size) {
		this.size = size;
		
		rank = new int[size];
		parent = new int[size];
		
		for(int i = 0; i<size; i++) {
			parent[i] = i;
		}
	}
	
	public void mergeSets(int x, int y) {
		int PX = findSet(x);
		int PY = findSet(y);
		
		if(PX == PY) return;
		
		if (rank[PX] > rank[PY]) {
			parent[PY] = PX; // means py er parent ekhon px
		}
		else {
			parent[PX] = PY;
		}
		
		if (rank[PX] == rank[PY]) rank[PY] = rank[PY] + 1; // 2 ta rank soman thaka means ekta tree er size barano
	}
	
	public int findSet(int x){
		while (x != parent[x]) { 
			x = parent[x];
		}
		
		return parent[x];
	}
	
	public boolean isSameSet(int x, int y) {
		
		return findSet(x) == findSet(y);
	}
}