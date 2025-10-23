package sudoku;


/**
 Punto de entrada. Carga un Sudoku X, lo imprime, lo resuelve e imprime
 métricas de ejecución (tiempo, llamadas recursivas, asignaciones, backtracks, checks).

 
 @author Isai Emmanuel Castro Hernandez
 @version 1.0
 @since 22-10-2025
 */
public class Main {

    private static final int[][] INSTANCE = {
            {0,9,0, 8,0,7, 0,4,0},
            {0,1,0, 4,0,0, 0,9,0},
            {0,0,0, 0,0,0, 0,0,8},
            
            {0,2,0, 0,5,0, 0,0,0},
            {0,0,9, 0,3,2, 0,0,0},
            {0,5,0, 0,0,0, 0,0,3},
            
            {0,0,0, 0,0,0, 0,7,1},
            {0,0,6, 0,7,0, 0,0,0},
            {8,0,0, 0,0,0, 0,0,0}
    };

    public static void main(String[] args) {
        SudokuBoard board = new SudokuBoard(INSTANCE);
        Metrics metrics = new Metrics();
        SudokuSolver solver = new SudokuSolver(board, metrics);

        board.print("Sudoku (inicial)");

        metrics.reset();
        metrics.startTimer();
        boolean ok = solver.solve();
        metrics.stopTimer();

        if (ok) {
            board.print("Sudoku (resuelto)");
            System.out.println(metrics);
        } else {
            System.out.println("\nNo se encontró solución. Revisa la instancia.");
        }
    }
}