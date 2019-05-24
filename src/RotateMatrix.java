public class RotateMatrix {

	int row = 3;
	int col = 3;

	int [][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
	int [][] rotatedMatrixTo90Degree = new int[row][col];
	
	void print(){
		for(int i = 0; i<row; i++){
			for(int j = 0; j<col; j++){
				System.out.print(rotatedMatrixTo90Degree[i][j]);
			}
			
			System.out.println();
		}
	}
	
	void startProgram(){
		int oldJ = col-1;
		
		for(int i = 0; i<row; i++){
			int oldI = 0;
			for(int j = 0; j<col; j++){
				rotatedMatrixTo90Degree[i][j] = matrix[oldI][oldJ];
				oldI++;
			}
			
			oldJ--;
		}
		
		print();
	}
	
	public static void main(String[] args) {
		new RotateMatrix().startProgram();
	}
}
