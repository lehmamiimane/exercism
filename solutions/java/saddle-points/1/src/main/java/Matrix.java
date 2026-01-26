import java.util.*;
import java.util.Set;

class Matrix {
   List<List<Integer>> values;

    Matrix(List<List<Integer>> values) {
        this.values = values;
    }

    Set<MatrixCoordinate> getSaddlePoints() {
        Set<MatrixCoordinate> result = new HashSet<>();
        if (values.isEmpty() || values.get(0).isEmpty()) {
        return result; 
    }
        int rowCount = values.size();
        int colCount = values.get(0).size();

        for (int i = 0; i < rowCount; i++) {
            int maxInRow = Collections.max(values.get(i));

            for (int j = 0; j < colCount; j++) {
                int current = values.get(i).get(j);
                if (current == maxInRow) {
                    boolean isMinInCol = true;
                    for (int k = 0; k < rowCount; k++) {
                        if (values.get(k).get(j) < current) {
                            isMinInCol = false;
                            break;
                        }
                    }

                    if (isMinInCol) {
                        result.add(new MatrixCoordinate(i+1, j+1));
                    }
                }
            }
        }

        return result;
    }
}
