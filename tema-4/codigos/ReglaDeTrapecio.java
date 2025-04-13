public class ReglaDeTrapecio {

    public static double funcion(double x) {
        return Math.pow(x, 2) + 1; // Función a integrar
    }

    public static double reglaTrapecioCompuesta(double a, double b, int n) {
        double h = (b - a) / n; // Tamaño del subintervalo
        double suma = funcion(a) + funcion(b); // f(x0) + f(xn)

        // Sumamos los valores intermedios multiplicados por 2
        for (int i = 1; i < n; i++) {
            double xi = a + i * h;
            suma += 2 * funcion(xi);
        }

        return (h / 2) * suma; // Resultado final
    }

    public static void main(String[] args) {
        // Define los límites del intervalo y el número de subintervalos
        double a = 0;  // Límite inferior
        double b = 2;  // Límite superior
        int n = 4;     // Número de subintervalos

        // Calcula la aproximación de la integral
        double resultado = reglaTrapecioCompuesta(a, b, n);

        // Muestra el resultado 
        System.out.println("Aproximación de la integral: " + resultado);
    }
}