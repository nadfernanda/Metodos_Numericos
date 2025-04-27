import java.util.function.BiFunction;

public class MetodoRungeKutta {

    public static void rungeKutta(BiFunction<Double, Double, Double> f, double x0, double y0, double h, int n) {
        double x = x0;
        double y = y0;

        System.out.println("Paso\t x\t\t y");
        System.out.printf("0\t %.5f\t %.5f%n", x, y);

        for (int i = 1; i <= n; i++) {
            // Calculamos los cuatro k del método de Runge-Kutta
            double k1 = h * f.apply(x, y);
            double k2 = h * f.apply(x + h / 2.0, y + k1 / 2.0);
            double k3 = h * f.apply(x + h / 2.0, y + k2 / 2.0);
            double k4 = h * f.apply(x + h, y + k3);

            // Fórmula para actualizar y
            y = y + (k1 + 2 * k2 + 2 * k3 + k4) / 6.0;

            // Avanzamos en x
            x = x + h;

            // Imprimimos los valores de cada paso
            System.out.printf("%d\t %.5f\t %.5f%n", i, x, y);
        }
    }

    public static void main(String[] args) {
        // Definimos la derivada dy/dx como una función que depende de x e y
        BiFunction<Double, Double, Double> derivada = (x, y) -> x + y; // Ejemplo: dy/dx = x + y

        // Parámetros iniciales
        double x0 = 0;    // Valor inicial de x
        double y0 = 1;    // Valor inicial de y
        double h = 0.1;   // Tamaño de paso
        int n = 10;       // Número de pasos

        // Llamamos al método de Runge-Kutta
        rungeKutta(derivada, x0, y0, h, n);
    }
}
