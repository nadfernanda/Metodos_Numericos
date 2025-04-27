import java.util.function.BiFunction;

public class MetodoTaylor {

    public static void taylorOrden2(BiFunction<Double, Double, Double> f, 
                                    BiFunction<Double, Double, Double> df_dx, 
                                    double x0, double y0, double h, int n) {
        double x = x0;
        double y = y0;

        System.out.println("Paso\t x\t\t y");
        System.out.printf("0\t %.5f\t %.5f%n", x, y);

        for (int i = 1; i <= n; i++) {
            // Fórmula de Taylor de orden 2:
            // y(i+1) = y(i) + h * f(x(i), y(i)) + (h^2 / 2) * d²y/dx²(x(i), y(i))
            double dy = f.apply(x, y);
            double d2y = df_dx.apply(x, y);

            y = y + h * dy + (h * h / 2.0) * d2y;
            x = x + h;

            // Imprimimos el resultado de cada paso
            System.out.printf("%d\t %.5f\t %.5f%n", i, x, y);
        }
    }

    public static void main(String[] args) {
        // Definimos la primera derivada dy/dx como función
        BiFunction<Double, Double, Double> derivadaPrimera = (x, y) -> x + y; // Ejemplo: dy/dx = x + y

        // Definimos la segunda derivada d²y/dx²
        BiFunction<Double, Double, Double> derivadaSegunda = (x, y) -> 1 + (x + y); 
        // Para el ejemplo: d²y/dx² = 1 + (x + y) (esto depende del problema)

        // Parámetros iniciales
        double x0 = 0;    // Valor inicial de x
        double y0 = 1;    // Valor inicial de y
        double h = 0.1;   // Tamaño de paso
        int n = 10;       // Número de pasos

        // Llamamos al método de Taylor
        taylorOrden2(derivadaPrimera, derivadaSegunda, x0, y0, h, n);
    }
}
