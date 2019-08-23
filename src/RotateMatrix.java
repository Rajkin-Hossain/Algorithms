public class RotateMatrix {

	int row = 3;
	int col = 3;

	int [][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
	
	void print(int [][] a){
		for(int i = 0; i<row; i++){
			for(int j = 0; j<col; j++){
				System.out.print(a[i][j]);
			}
			
			System.out.println();
		}
	}
	
	void rotate90Clockwise(int [][] a) {
		int N = a.length;
		
	    for (int x = 0; x < N / 2; x++) { 
	        for (int y = x; y < N - x - 1; y++) { 
	        	
	            int temp = a[x][y];
	            
	            a[x][y] = a[N - 1 - y][x];
	            
	            a[N - 1 - y][x] = a[N - 1 - x][N - 1 - y];
	            
	            a[N - 1 - x][N - 1 - y] = a[y][N - 1 - x];
	            
	            a[y][N - 1 - x] = temp;
	        }
	    }
	    
	    print(a);
	}
	
	void rotate90AntiClockwise(int [][] a) {
		int N = a.length;
		
		for (int x = 0; x < N / 2; x++) {
	        for (int y = x; y < N-x-1; y++) {
	        	
	            int temp = a[x][y];
	            
	            a[x][y] = a[y][N-1-x];
	            
	            a[y][N-1-x] = a[N-1-x][N-1-y];
	            
	            a[N-1-x][N-1-y] = a[N-1-y][x];
	            
	            a[N-1-y][x] = temp;
	        }
	    }
		
		print(a);
	}
	
	void rotate90ClockwiseUsingExtraMemory() {
		int [][] rotatedMatrixTo90Degree = new int[row][col];
		
		int oldJ = col-1;
		
		for(int i = 0; i<row; i++){
			int oldI = 0;
			for(int j = 0; j<col; j++){
				rotatedMatrixTo90Degree[i][j] = matrix[oldI][oldJ];
				oldI++;
			}
			
			oldJ--;
		}
		
		print(rotatedMatrixTo90Degree);
	}
	
	public static void main(String[] args) {
		//new RotateMatrix().rotate90ClockwiseUsingExtraMemory();
		//new RotateMatrix().rotate90Clockwise(new RotateMatrix().matrix);
		new RotateMatrix().rotate90AntiClockwise(new RotateMatrix().matrix);
	}
}
