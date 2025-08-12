
class Matrix {
    private final int[][] matrix;
    
    Matrix(String matrixAsString) {
        String[] rows = matrixAsString.split("\n");
        int rowCount = rows.length;
        int colCount = rows[0].trim().split("\\s+").length;

        matrix = new int[rowCount][colCount];
        for(int i = 0; i< rowCount; i++){
            String[] numbers =rows[i].trim().split("\\s+");
            for(int j = 0; j<colCount; j++){
                matrix[i][j] = Integer.parseInt(numbers[j]);
            }
        }
    }

    int[] getRow(int rowNumber) {
        return matrix[rowNumber - 1];
    }

    int[] getColumn(int columnNumber) {
        int[] col = new int[matrix.length];

        for(int i = 0; i< matrix.length; i++){
            col[i] = matrix[i][columnNumber -1];
        }

        return col;
    }
}
