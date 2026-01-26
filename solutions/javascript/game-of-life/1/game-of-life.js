//
// This is only a SKELETON file for the 'Conway's Game of Life' exercise. It's been provided
// as a convenience to get you started writing code faster.
//

export class GameOfLife {
  constructor(matrix) {
     // Copie profonde de la grille d'entrée
    this.grid = matrix.map(row => [...row]);

    // Nombre de lignes et colonnes
    this.rows = matrix.length;
    this.cols = this.rows > 0 ? matrix[0].length : 0;
  }

  tick() {
    const next = this.grid.map(row => [...row]);

    for (let row = 0; row < this.rows; row++) {
      for (let col = 0; col < this.cols; col++) {
        const liveNeighbors = this.countLiveNeighbors(row, col);
        const cell = this.grid[row][col];

        if (cell === 1) {
          // Une cellule vivante reste vivante si elle a 2 ou 3 voisines vivantes
          next[row][col] = (liveNeighbors === 2 || liveNeighbors === 3) ? 1 : 0;
        } else {
          // Une cellule morte devient vivante si elle a exactement 3 voisines vivantes
          next[row][col] = (liveNeighbors === 3) ? 1 : 0;
        }
      }
    }

    this.grid = next;
  }

  countLiveNeighbors(row, col) {
    let count = 0;

    for (let i = -1; i <= 1; i++) {
      for (let j = -1; j <= 1; j++) {
        // On ignore la cellule elle-même
        if (i === 0 && j === 0) continue;

        const r = row + i;
        const c = col + j;

        // On reste dans les limites de la grille
        if (r >= 0 && r < this.rows && c >= 0 && c < this.cols) {
          count += this.grid[r][c];
        }
      }
    }

    return count;
  }

  state() {
    return this.grid.map(row => [...row]);
  }
}
