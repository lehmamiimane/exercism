class SpiralMatrixBuilder {
    int[][] buildMatrixOfSize(int size) {
        int[][] matrix = new int[size][size];
        if (size == 0) return matrix;

        int count = 1;
        int top = 0, bottom = size - 1;
        int left = 0, right = size - 1;

        while (top <= bottom && left <= right) {
            // gauche → droite
            for (int j = left; j <= right; j++) {
                matrix[top][j] = count++;
            }
            top++;

            // haut → bas
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = count++;
            }
            right--;

            // droite → gauche
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    matrix[bottom][j] = count++;
                }
                bottom--;
            }

            // bas → haut
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = count++;
                }
                left++;
            }
        }

        return matrix;
    }
}
