package algorithm.ss;

public class GaussianElimF2 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        execute(getMatrix(2));
//        execute(getMatrix(3));
//        execute(getMatrix(4));
    }
    
    static int[][] getMatrix(int n) {
        int[][] result = new int[n * n][n * n];
        
        for (int i = 0; i < result.length; ++i) {
            for (int j = 0; j < result[i].length; ++j) {
                if ((j == i - n) ||
                        (i % n != 0 && j == i - 1) ||
                        (j == i) ||
                        (i % n != n - 1 && j == i + 1) ||
                        (j == i + n))
                    result[i][j] = 1;
                else
                    result[i][j] = 0;
            }
        }
        
        return result;
    }
    
    static void execute(int[][] matrix) {
        display(matrix);
        int[][] augmentedMatrix = augmentMatrix(matrix);
//        display(augmentedMatrix);
        eliminate(augmentedMatrix);
        display(augmentedMatrix);
    }

    static int[][] augmentMatrix(int[][] matrix) {
        int size = matrix.length;
        int[][] result = new int[size][2 * size];

        for (int rowIdx = 0; rowIdx < size; ++rowIdx) {
            for (int colIdx = 0; colIdx < 2 * size; ++colIdx) {
                if (colIdx < size)
                    result[rowIdx][colIdx] = matrix[rowIdx][colIdx];
                else if (rowIdx == colIdx - size)
                    result[rowIdx][colIdx] = 1;
                else
                    result[rowIdx][colIdx] = 0;
            }
        }

        return result;
    }
    
    static void eliminate(int[][] matrix) {
        int rowIdx = 0;
        
        for (int colIdx = 0; colIdx < matrix.length; ++colIdx) {
            int pivotIdx = findPivotIdx(matrix, rowIdx, colIdx);
            if (pivotIdx < 0)
                continue;
            
            swapRows(matrix, pivotIdx, rowIdx);
//            display(matrix);
            eliminateOtherRows(matrix, rowIdx, colIdx);
//            display(matrix);
            ++rowIdx;
        }
    }
    
    static int findPivotIdx(int[][] matrix, int rowIdx, int colIdx) {
        for (int i = rowIdx; i < matrix.length; ++i) {
            if (matrix[i][colIdx] != 0) {
                return i;
            }
        }
        return -1;
    }
    
    static void swapRows(int[][] matrix, int pivotIdx, int rowIdx) {
        if (pivotIdx == rowIdx)
            return;
        
        int[] tmp = matrix[rowIdx];
        matrix[rowIdx] = matrix[pivotIdx];
        matrix[pivotIdx] = tmp;
    }
    
    static void eliminateOtherRows(int[][] matrix, int rowIdx, int colIdx) {
        for (int i = 0; i < matrix.length; ++i) {
            display(matrix);
            if (i == rowIdx)
                continue;
            if (matrix[i][colIdx] == 0)
                continue;
            for (int j = colIdx; j < matrix[i].length; ++j)
                matrix[i][j] = matrix[i][j] ^ matrix[rowIdx][j];
        }
    }
    
    static void display(int[][] matrix) {
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                System.out.printf("%d", matrix[i][j]);
                if (j < matrix[i].length - 1)
                    System.out.printf(" ");
                else
                    System.out.println();
            }
        }
        System.out.println();
    }

}
