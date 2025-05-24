import java.util.function.BiFunction;

/**
 * Clase que implementa el método de Runge-Kutta de cuarto orden (RK4)
 * para resolver ecuaciones diferenciales ordinarias (EDO) de primer orden.
 */
public class MetodoRungeKutta {

    /**
     * Método estático que implementa el algoritmo de Runge-Kutta de cuarto orden.
     * Este método aproxima la solución de una EDO de la forma dy/dx = f(x, y)
     * en un intervalo definido por el número de pasos y el tamaño de paso.
     *
     * @param f    Función que representa la derivada dy/dx, dependiente de x e y
     * @param x0   Valor inicial de x (condición inicial)
     * @param y0   Valor inicial de y (condición inicial)
     * @param h    Tamaño de paso (incremento de x)
     * @param n    Número de pasos a ejecutar
     */
    public static void rungeKutta(BiFunction<Double, Double, Double> f, double x0, double y0, double h, int n) {
        double x = x0; // Inicializa x con el valor inicial
        double y = y0; // Inicializa y con el valor inicial

        // Itera n veces para calcular la aproximación de y en x + n*h
        for (int i = 1; i <= n; i++) {
            // Calcula los coeficientes de Runge-Kutta
            double k1 = h * f.apply(x, y);
            double k2 = h * f.apply(x + h / 2.0, y + k1 / 2.0);
            double k3 = h * f.apply(x + h / 2.0, y + k2 / 2.0);
            double k4 = h * f.apply(x + h, y + k3);

            // Actualiza el valor de y usando los coeficientes
            y = y + (k1 + 2 * k2 + 2 * k3 + k4) / 6.0;

            // Incrementa el valor de x
            x = x + h;
        }

        // Imprime el resultado final de y en x final
        System.out.printf("Resultado final: y(%.2f) = %.5f%n", x, y);
    }

    /**
     * Método principal para probar la implementación del método de Runge-Kutta.
     * Define la función derivada, condiciones iniciales, tamaño de paso y número de pasos.
     */
    public static void main(String[] args) {
        // Definición de la función derivada dy/dx = x * sqrt(y)
        BiFunction<Double, Double, Double> derivada = (x, y) -> x * Math.sqrt(y);

        // Condiciones iniciales
        double x0 = 0;    // Valor inicial de x
        double y0 = 1;    // Valor inicial de y

        // Parámetros del método
        double h = 0.2;   // Tamaño de paso
        int n = 5;        // Número de pasos

        // Llamada al método de Runge-Kutta para resolver la EDO
        rungeKutta(derivada, x0, y0, h, n);
    }
}
