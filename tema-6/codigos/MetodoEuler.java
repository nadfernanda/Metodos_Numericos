import java.util.function.BiFunction;

/**
 * Clase que implementa el método de Euler para resolver ecuaciones diferenciales ordinarias
 * de primer orden de la forma dy/dx = f(x, y).
 */
public class MetodoEuler {

    /**
     * Resuelve una ecuación diferencial ordinaria usando el método de Euler.
     * El método realiza un número fijo de pasos y muestra únicamente el resultado final.
     *
     * @param f  La función f(x, y) que representa la derivada dy/dx.
     *           Se utiliza BiFunction para permitir el paso de una función lambda.
     * @param x0 Valor inicial de x (condición inicial).
     * @param y0 Valor inicial de y (condición inicial).
     * @param h  Tamaño del paso (incremento de x en cada iteración).
     * @param n  Número de pasos a realizar.
     */
    public static void euler(BiFunction<Double, Double, Double> f, double x0, double y0, double h, int n) {
        double x = x0;  // Inicializa x con el valor inicial
        double y = y0;  // Inicializa y con el valor inicial

        // Bucle que aplica el método de Euler n veces
        for (int i = 1; i <= n; i++) {
            // Aplica la fórmula de Euler: y_{n+1} = y_n + h * f(x_n, y_n)
            y = y + h * f.apply(x, y);
            x = x + h;  // Incrementa x en cada paso
        }

        // Imprime el resultado final de y para el valor de x alcanzado
        System.out.printf("Resultado final: y(%.3f) = %.3f%n", x, y);
    }

    /**
     * Método principal que configura y ejecuta un ejemplo del método de Euler.
     */
    public static void main(String[] args) {
        // Define la derivada dy/dx = f(x, y). En este caso, f(x, y) = x + 1
        BiFunction<Double, Double, Double> derivada = (x, y) -> x + 1;

        // Parámetros del problema
        double x0 = 0;    // Valor inicial de x
        double y0 = 1;    // Valor inicial de y
        double h = 0.1;   // Tamaño del paso
        int n = 10;       // Número de pasos

        // Llama al método de Euler con los parámetros definidos
        euler(derivada, x0, y0, h, n);
    }
}
