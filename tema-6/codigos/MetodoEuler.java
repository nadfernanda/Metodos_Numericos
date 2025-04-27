import java.util.function.Function;

public class MetodoEuler {

    public static void euler(Function<Double, Double> f, double x0, double y0, double h, int n) {
        double x = x0;
        double y = y0;

        System.out.println("Paso\t x\t\t y");
        System.out.printf("0\t %.5f\t %.5f%n", x, y);

        // Itera n veces aplicando el método de Euler
        for (int i = 1; i <= n; i++) {
            y = y + h * f.apply(x);  // Fórmula de Euler: y(i+1) = y(i) + h*f(x(i))
            x = x + h;               // Avanza en x con el tamaño de paso h

            // Imprime los valores actuales de x e y
            System.out.printf("%d\t %.5f\t %.5f%n", i, x, y);
        }
    }

    public static void main(String[] args) {
        // Definimos la derivada dy/dx como una función
        Function<Double, Double> derivada = (x) -> x + 1; // Ejemplo: dy/dx = x + 1

        // Parámetros iniciales
        double x0 = 0;    // Valor inicial de x
        double y0 = 1;    // Valor inicial de y
        double h = 0.1;   // Tamaño de paso
        int n = 10;       // Número de pasos

        // Llamamos al método de Euler
        euler(derivada, x0, y0, h, n);
    }
}
