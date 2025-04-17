   /**
 * Clase para calcular el error relativo entre un valor exacto y un valor aproximado.
 * El error relativo es una medida de la precisión de una aproximación en comparación
 * con el valor exacto.
 */
public class ErrorRelativo {

    /**
     * Método para calcular el error relativo.
     * 
     * @param valorExacto El valor exacto o teórico (no puede ser cero)
     * @param valorAproximado El valor aproximado o medido
     * @return El error relativo como valor absoluto
     * @throws IllegalArgumentException Si el valor exacto es cero
     */
    public static double calcularErrorRelativo(double valorExacto, double valorAproximado) {
        if (valorExacto == 0) {
            throw new IllegalArgumentException("El valor exacto no puede ser cero (división por cero)");
        }
        return Math.abs((valorExacto - valorAproximado) / valorExacto);
    }

    /**
     * Método principal para demostrar el uso del cálculo de error relativo.
     * 
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        // Ejemplo de cálculo de error relativo
        double exacto = 10.0;
        double aproximado = 9.5;
        
        double error = calcularErrorRelativo(exacto, aproximado);
        System.out.printf("Error relativo: %.4f (%.2f%%)%n", error, error * 100);
    }
}
    