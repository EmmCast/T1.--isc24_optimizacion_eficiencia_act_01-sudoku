package sudoku;

import java.util.Arrays;

/**
 Representa un tablero 9x9 de Sudoku (int), donde 0 indica celda vacía.
 Proporciona utilidades para impresión y búsqueda de la siguiente celda libre.
 
 @author Isai Emmanuel Castro Hernandez
 @version 1.0
 @since 22-10-2025
 */
public class SudokuBoard {

    private final int[][] grid; // 9x9

    /**
     se crea un tablero a partir de una matriz 9x9.
     @param initial matriz 9x9 (0 = vacío)
     @throws IllegalArgumentException si el tamaño no es 9x9
     */
    public SudokuBoard(int[][] initial) {
        if (initial == null || initial.length != 9)
            throw new IllegalArgumentException("La matriz debe ser 9x9.");
        for (int[] row : initial) {
            if (row == null || row.length != 9)
                throw new IllegalArgumentException("La matriz debe ser 9x9.");
        }
        // Copia defensiva
        this.grid = new int[9][9];
        for (int i = 0; i < 9; i++) {
            this.grid[i] = Arrays.copyOf(initial[i], 9);
        }
    }

    public int get(int i, int j) { return grid[i][j]; }

    public void set(int i, int j, int value) { grid[i][j] = value; }

    public int[][] getGrid() { return grid; }

    /**
     Se busca la siguiente celda vacía.
     @return arreglo {i, j} o null si no hay vacíos.
     */
    public int[] findEmptyCell() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j] == 0) return new int[]{i, j};
            }
        }
        return null;
        }
    
    /** 
     Se imprimoe el tablero con separadores de subcuadrículas 3x3.
     Usaremos '.' para celdas vacías.
     */
    public void print(String title) {
        System.out.println("\n" + title);
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0) System.out.println("+-------+-------+-------+");
            StringBuilder row = new StringBuilder("| ");
            for (int j = 0; j < 9; j++) {
                int v = grid[i][j];
                row.append(v == 0 ? '.' : (char) ('0' + v)).append(' ');
                if ((j + 1) % 3 == 0) row.append("| ");
            }
            System.out.println(row);
        }
        System.out.println("+-------+-------+-------+");
    }
}