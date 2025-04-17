public class ErrorIterativo {
    /**
 * Clase para calcular el error iterativo en métodos numéricos.
 * Incluye errores absoluto, relativo y porcentual entre iteraciones.
 */

    /**
     * Calcula el error absoluto iterativo.
     * 
     * @param xActual  Valor de la iteración actual (x_n).
     * @param xAnterior Valor de la iteración anterior (x_{n-1}).
     * @return Error absoluto iterativo.
     */
    public static double errorAbsolutoIterativo(double xActual, double xAnterior) {
        return Math.abs(xActual - xAnterior);
    }

    /**
     * Calcula el error relativo iterativo.
     * 
     * @param xActual  Valor de la iteración actual (x_n).
     * @param xAnterior Valor de la iteración anterior (x_{n-1}).
     * @return Error relativo iterativo.
     * @throws IllegalArgumentException Si xActual es cero (para evitar división por cero).
     */
    public static double errorRelativoIterativo(double xActual, double xAnterior) {
        if (xActual == 0) {
            throw new IllegalArgumentException("xActual no puede ser cero en el error relativo.");
        }
        return Math.abs(xActual - xAnterior) / Math.abs(xActual);
    }

    /**
     * Calcula el error relativo porcentual iterativo.
     * 
     * @param xActual  Valor de la iteración actual (x_n).
     * @param xAnterior Valor de la iteración anterior (x_{n-1}).
     * @return Error relativo porcentual iterativo.
     */
    public static double errorPorcentualIterativo(double xActual, double xAnterior) {
        return errorRelativoIterativo(xActual, xAnterior) * 100;
    }

    /**
     * Ejemplo de uso: Aproximación de la raíz cuadrada de 2 usando el método de Newton-Raphson.
     */
    public static void main(String[] args) {
        double tolerancia = 0.0001; // Tolerancia del 0.01%
        double xAnterior = 2.0; // Valor inicial (puede ser cualquier aproximación)
        double xActual = 1.5; // Primera iteración manual

        int iteracion = 1;
        double errorRelPerc;

        System.out.println("Iteración\tAproximación\tError Relativo %");
        System.out.printf("%d\t\t%.6f\t\t-\n", iteracion, xAnterior);

        do {
            iteracion++;
            xAnterior = xActual;
            xActual = (xAnterior + 2.0 / xAnterior) / 2; // Fórmula de Newton-Raphson para √2

            errorRelPerc = errorPorcentualIterativo(xActual, xAnterior);

            System.out.printf("%d\t\t%.6f\t\t%.6f%%\n", iteracion, xActual, errorRelPerc);
        } while (errorRelPerc > tolerancia);

        System.out.printf("\nResultado final: √2 ≈ %.6f (con error < %.4f%%)", xActual, tolerancia);
    }
}
