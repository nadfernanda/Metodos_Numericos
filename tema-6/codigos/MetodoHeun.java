/**
 * Clase que implementa el método de Heun (Euler modificado)
 * para resolver una EDO y mostrar solo el resultado final.
 */
public class MetodoHeun {

    /**
     * Interfaz funcional para representar la función f(x, y).
     */
    @FunctionalInterface
    public interface Funcion {
        double aplicar(double x, double y);
    }

    /**
     * Aplica el método de Heun para resolver la EDO y retorna el valor final de y.
     *
     * @param f  función f(x, y)
     * @param x0 valor inicial de x
     * @param y0 valor inicial de y
     * @param h  paso
     * @param n  número de pasos
     * @return valor final de y después de n pasos
     */
    public static double heun(Funcion f, double x0, double y0, double h, int n) {
        double x = x0;
        double y = y0;

        for (int i = 1; i <= n; i++) {
            double k1 = f.aplicar(x, y);
            double k2 = f.aplicar(x + h, y + h * k1);
            y = y + (h / 2.0) * (k1 + k2);
            x = x + h;
        }

        return y;
    }

    /**
     * Método principal con ejemplo de uso.
     * Resuelve dy/dx = y con y(0) = 1, h = 0.2, n = 5
     */
   public static void main(String[] args) {
    // Definición de la función f(x, y) = -3y + 6
    Funcion f = (x, y) -> -3 * y + 6;
    
    // Parámetros iniciales de la EDO
    double x0 = 0.0;  // x inicial
    double y0 = 0.0;  // y inicial
    double h = 0.1;   // paso
    int n = 8;        // número de pasos
    
    // Ejecutar el método de Heun
    double resultadoFinal = heun(f, x0, y0, h, n);
    System.out.printf("Resultado final en x = %.2f: y ≈ %.6f\n", x0 + h * n, resultadoFinal);
}
    }

