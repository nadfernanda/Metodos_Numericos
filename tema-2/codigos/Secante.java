public class Secante {

    /**
     * Función f(x) para la cual se busca la raíz.
     * 
     * @param x El valor de entrada para la función.
     * @return El valor de la función evaluada en x.
     */
    public static double f(double x) {
        return x * x - 4; // Función
    }

    /**
     * Implementación del método de la secante para encontrar la raíz de la función f(x).
     * 
     * @param x0 El primer valor inicial.
     * @param x1 El segundo valor inicial.
     * @param epsilon El umbral de tolerancia para determinar la convergencia.
     * @param maxIter El número máximo de iteraciones permitidas.
     */
    public static void metodoSecante(double x0, double x1, double epsilon, int maxIter) {
        double x2;  // Variable para almacenar el valor de la nueva aproximación de la raíz.
        int iter = 0;  // Contador de iteraciones.

        // Bucle para realizar las iteraciones del método de la secante
        while (iter < maxIter) {
            // Evaluar la función f(x) en los valores actuales x0 y x1
            double f0 = f(x0);
            double f1 = f(x1);

            // Calcular el siguiente valor de la raíz usando la fórmula de la secante
            x2 = x1 - f1 * (x1 - x0) / (f1 - f0);

            // Verificar si la diferencia entre las dos iteraciones consecutivas es menor que epsilon
            // Si la diferencia es suficientemente pequeña, se considera que se ha encontrado la raíz
            if (Math.abs(x2 - x1) < epsilon) {
                System.out.printf("Raíz aproximada: %.4f\n", x2);
                System.out.printf("Número de iteraciones: %d\n", iter + 1);
                return;  // Se termina el algoritmo ya que la convergencia se ha alcanzado.
            }

            // Actualizar los valores de x0 y x1 para la siguiente iteración
            x0 = x1;
            x1 = x2;

            // Incrementar el contador de iteraciones
            iter++;
        }

        // Si se llega al máximo número de iteraciones sin haber encontrado la raíz, mostrar mensaje de error
        System.out.println("El método no convergió en el número máximo de iteraciones.");
    }

    /**
     * Función principal que inicia el proceso del método de la secante.
     * 
     * @param args Argumentos de la línea de comandos (no se utilizan en este caso).
     */
    public static void main(String[] args) {
        // Valores iniciales
        double x0 = 1.0;  // Primer valor inicial
        double x1 = 2.0;  // Segundo valor inicial
        double epsilon = 1e-6;  // Tolerancia para la convergencia
        int maxIter = 100;  // Número máximo de iteraciones

        // Llamar al método de la secante para encontrar la raíz de la función
        metodoSecante(x0, x1, epsilon, maxIter);
    }
}
