package sudoku;

/**
 Registra métricas de ejecución del solver para análisis de complejidad empírica.
 Contabiliza comparaciones (checks), asignaciones, retrocesos (backtracks),
 y llamadas recursivas, además de medir el tiempo total de ejecución.
 
 @author Isai Emmanuel Castro Hernandez
 @version 1.0
 @since 22-10-2025
 */
public class Metrics {
	
	 private long checks;
	    private long assignments;
	    private long backtracks;
	    private long recursiveCalls;
	    private long startNano;
	    private long endNano;

	    public void reset() {
	        checks = assignments = backtracks = recursiveCalls = 0L;
	        startNano = endNano = 0L;
	    }

	    public void startTimer() {
	        startNano = System.nanoTime();
	    }

	    public void stopTimer() {
	        endNano = System.nanoTime();
	    }

	    public double getElapsedSeconds() {
	        if (startNano == 0 || endNano == 0) return 0.0;
	        return (endNano - startNano) / 1_000_000_000.0;
	    }

	    public void incChecks() { checks++; }

	    public void addChecks(long n) { checks += n; }

	    public void incAssignments() { assignments++; }

	    public void incBacktracks() { backtracks++; }

	    public void incRecursiveCalls() { recursiveCalls++; }

	    public long getChecks() { return checks; }
	    public long getAssignments() { return assignments; }
	    public long getBacktracks() { return backtracks; }
	    public long getRecursiveCalls() { return recursiveCalls; }

	    @Override
	    public String toString() {
	        return new StringBuilder()
	                .append("Métricas de ejecución:\n")
	                .append("- Tiempo (s): ").append(String.format("%.6f", getElapsedSeconds())).append('\n')
	                .append("- Llamadas recursivas: ").append(recursiveCalls).append('\n')
	                .append("- Asignaciones: ").append(assignments).append('\n')
	                .append("- Retrocesos (backtracks): ").append(backtracks).append('\n')
	                .append("- Comparaciones/chequeos: ").append(checks).append('\n')
	                .toString();
	    }
	
}
