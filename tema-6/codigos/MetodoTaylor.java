import java.util.function.BiFunction;

/**
 * Clase que implementa el método de Taylor de orden 2
 * para resolver ecuaciones diferenciales ordinarias (EDO).
 */
public class MetodoTaylor {

    /**
     * Método que resuelve una EDO usando el método de Taylor de orden 2.
     *
     * Fórmula: 
     * y(i+1) = y(i) + h*f(x(i), y(i)) + (h^2/2)*f'(x(i), y(i))
     *
     * @param f      Función que representa la derivada primera dy/dx
     * @param df_dx  Función que representa la derivada segunda d²y/dx²
     * @param x0     Valor inicial de x
     * @param y0     Valor inicial de y
     * @param h      Tamaño de paso
     * @param n      Número de pasos a realizar
     */
    public static void taylorOrden2(BiFunction<Double, Double, Double> f,
                                    BiFunction<Double, Double, Double> df_dx,
                                    double x0, double y0, double h, int n) {
        double x = x0;
        double y = y0;

        // Aplicamos la fórmula de Taylor en cada paso
        for (int i = 1; i <= n; i++) {
            double dy = f.apply(x, y);       // Primera derivada
            double d2y = df_dx.apply(x, y);  // Segunda derivada

            y = y + h * dy + (h * h / 2.0) * d2y;
            x = x + h;
        }

        // Mostrar resultado final
        System.out.printf("Resultado final en x = %.4f: y = %.4f%n", x, y);
    }

    public static void main(String[] args) {
        // Ejemplo de funciones para dy/dx = x + y y d²y/dx² = 1 + (x + y)
        BiFunction<Double, Double, Double> derivadaPrimera = (x, y) -> x + y;
        BiFunction<Double, Double, Double> derivadaSegunda = (x, y) -> 1 + (x + y);

        // Parámetros iniciales
        double x0 = 0;    // Valor inicial de x
        double y0 = 1;    // Valor inicial de y
        double h = 0.1;   // Tamaño de paso
        int n = 10;       // Número de pasos

        // Ejecutamos el método de Taylor
        taylorOrden2(derivadaPrimera, derivadaSegunda, x0, y0, h, n);
    }
}
