//
// This is only a SKELETON file for the 'Matrix' exercise. It's been provided as a
// convenience to get you started writing code faster.
//

export class Matrix {
  constructor(matrixString) {
    // Convert the string into a 2D array (matrix)
    this.matrix = matrixString.split('\n').map(row => row.split(' ').map(Number));
  }

  // Get the rows
  get rows() {
    return this.matrix;
  }

  // Get the columns
  get columns() {
    // Transpose the matrix to get columns as rows
    return this.matrix[0].map((_, colIndex) => this.matrix.map(row => row[colIndex]));
  }
}
