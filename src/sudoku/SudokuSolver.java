package sudoku;

/**
 Solver de Sudoku X por backtracking recursivo.
 Sudoku X: además de filas/columnas/bloques 3x3, no se repiten números en
 las dos diagonales principales.
 
 @author Isai Emmanuel Castro Hernandez
 @version 1.0
 @since 22-10-2025
 */
public class SudokuSolver {

    private final SudokuBoard board;
    private final Metrics metrics;

    /**
     @param board tablero 9x9 con 0 en celdas vacías
     @param metrics colector de métricas para instrumentación
     */
    public SudokuSolver(SudokuBoard board, Metrics metrics) {
        this.board = board;
        this.metrics = metrics;
    }

    /**
     @return true si encontró solución única/alguna; false si no hay solución.
     */

    public boolean solve() {
        metrics.incRecursiveCalls();   // <-- debe estar aquí, lo primero

        int[] pos = board.findEmptyCell();
        if (pos == null) {
            return true; // No hay vacíos: sudoku completo
        }

        int i = pos[0], j = pos[1];
        for (int n = 1; n <= 9; n++) {
            if (isValid(n, i, j)) {
                board.set(i, j, n);
                metrics.incAssignments();

                if (solve()) {
                    return true;
                }

                // Backtrack
                board.set(i, j, 0);
                metrics.incBacktracks();
            }
        }
        return false;
    }
    /**
     Verifica si el número n se puede colocar en (i, j) respetando:
     - Fila i
     - Columna j
     - Subcuadrícula 3x3
     - Diagonales principales (Sudoku X) si (i==j) o (i+j==8)
    
     @param n valor candidato [1..9]
     @param i fila [0..8]
     @param j columna [0..8]
     @return true si es válido colocar n en (i, j)
     */
    public boolean isValid(int n, int i, int j) {
        int[][] g = board.getGrid();

        for (int col = 0; col < 9; col++) {
            metrics.incChecks();
            if (g[i][col] == n) return false;
        }

        for (int fil = 0; fil < 9; fil++) {
            metrics.incChecks();
            if (g[fil][j] == n) return false;
        }

        int bi = (i / 3) * 3;
        int bj = (j / 3) * 3;
        for (int r = bi; r < bi + 3; r++) {
            for (int c = bj; c < bj + 3; c++) {
                metrics.incChecks();
                if (g[r][c] == n) return false;
            }
        }

        if (i == j) {
            for (int k = 0; k < 9; k++) {
                metrics.incChecks();
                if (g[k][k] == n) return false;
            }
        }

        if (i + j == 8) {
            for (int k = 0; k < 9; k++) {
                metrics.incChecks();
                if (g[k][8 - k] == n) return false;
            }
        }

        return true;
    }
}