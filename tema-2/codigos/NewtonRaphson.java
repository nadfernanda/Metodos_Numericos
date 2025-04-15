// Clase que implementa el método de Newton-Raphson para encontrar raíces de funciones
public class NewtonRaphson {

    // Definición de la función f(x) = x^3 - x - 2
    public static double f(double x) {
        return Math.pow(x, 3) - x - 2;
    }

    // Definición de la derivada de la función f'(x) = 3x^2 - 1
    public static double df(double x) {
        return 3 * Math.pow(x, 2) - 1;
    }

    /**
     * Método que implementa el algoritmo de Newton-Raphson.
     * @param x0 Valor inicial (estimación inicial de la raíz)
     * @param tol Tolerancia deseada (criterio de convergencia)
     * @param maxIter Número máximo de iteraciones permitidas
     */
    public static void newtonRaphson(double x0, double tol, int maxIter) {
        double x = x0;        // Inicialización del valor de x
        int iter = 0;         // Contador de iteraciones
        double error;         // Error entre iteraciones sucesivas

        // Bucle principal del método
        do {
            double fx = f(x);     // Evaluación de la función en x
            double dfx = df(x);   // Evaluación de la derivada en x

            // Verificación para evitar división por cero
            if (dfx == 0) {
                System.out.println("Error: La derivada es cero. No se puede continuar.");
                return; // Termina el método si no se puede continuar
            }

            // Cálculo del siguiente valor de x según la fórmula de Newton-Raphson
            double x1 = x - fx / dfx;

            // Cálculo del error como la diferencia absoluta entre iteraciones
            error = Math.abs(x1 - x);

            // Actualización de x para la siguiente iteración
            x = x1;

            iter++; // Incremento del contador de iteraciones

        } while (error > tol && iter < maxIter); // Criterios de parada: tolerancia o máximo de iteraciones

        // Impresión del resultado
        System.out.printf("Raíz aproximada: %.4f\n", x);
        System.out.printf("Obtenida en la iteración: %d\n", iter);
    }

    public static void main(String[] args) {
        double x0 = 1.5;            // Valor inicial para comenzar el método
        double tolerancia = 1e-4;   // Tolerancia deseada (error máximo permitido)
        int maxIter = 100;          // Número máximo de iteraciones permitidas

        // Llamada al método de Newton-Raphson con los parámetros definidos
        newtonRaphson(x0, tolerancia, maxIter);
    }
}
