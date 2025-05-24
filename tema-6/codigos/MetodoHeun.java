/**
 * Clase que implementa el Método de Euler Modificado (Heun)
 * para resolver una ecuación diferencial ordinaria de primer orden.
 */
public class MetodoHeun {

    /**
     * Interfaz funcional que representa la función f(x, y) de la EDO.
     */
    @FunctionalInterface
    public interface Funcion {
        double aplicar(double x, double y);
    }

    /**
     * Aplica el Método de Heun (Euler modificado) para resolver una EDO.
     *
     * @param f  La función f(x, y) que define la EDO dy/dx = f(x, y)
     * @param x0 Valor inicial de x
     * @param y0 Valor inicial de y (y(x0))
     * @param h  Paso de integración
     * @param n  Número de pasos
     */
    public static void heun(Funcion f, double x0, double y0, double h, int n) {
        double x = x0;
        double y = y0;

        System.out.printf("Paso\t x\t\t y\n");
        System.out.printf("0\t %.6f\t %.6f\n", x, y);

        // Iteración del método de Heun
        for (int i = 1; i <= n; i++) {
            double k1 = f.aplicar(x, y);                  // pendiente al inicio del intervalo
            double k2 = f.aplicar(x + h, y + h * k1);     // pendiente al final del intervalo
            y = y + (h / 2.0) * (k1 + k2);                // promedio de pendientes
            x = x + h;                                    // incrementa x
 // Imprime resultados 
            System.out.printf("%d\t %.4f\t %.4f\n", i, x, y);
        }
    }

    /**
     * Función principal (main) para probar el método con un ejemplo.
     * En este caso, resolvemos dy/dx = x + y con y(0) = 1
     */
    public static void main(String[] args) {
        // Definición de la función f(x, y) = x + y
        Funcion f = (x, y) -> x + y;

        // Parámetros iniciales de la EDO
        double x0 = 0.0;  // x inicial
        double y0 = 1.0;  // y inicial
        double h = 0.1;   // paso
        int n = 10;       // número de pasos

        // Ejecutar el método de Heun
        heun(f, x0, y0, h, n);
    }
}
