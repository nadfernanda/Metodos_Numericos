public class Simpson38 {
   
    public static double funcion(double x) {
        return Math.pow(x, 3); // Función a integrar
    }

    public static double simpson38(double a, double b, int n) {
        if (n % 3 != 0) {
            throw new IllegalArgumentException("El número de subintervalos debe ser múltiplo de 3.");
        }

        double h = (b - a) / n;
        double suma = funcion(a) + funcion(b);

        // Recorremos los puntos intermedios
        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            if (i % 3 == 0) {
                suma += 2 * funcion(x); // coeficiente 2 para múltiplos de 3
            } else {
                suma += 3 * funcion(x); // coeficiente 3 para los demás
            }
        }

        return (3 * h / 8) * suma;
    }

    public static void main(String[] args) {
        // Límite inferior y superior
        double a = 0;
        double b = 1;

        // Número de subintervalos (múltiplo de 3)
        int n = 6;

        // Calcular la integral
        double resultado = simpson38(a, b, n);

        // Mostrar resultado 
        System.out.println("Resultado de la integral: " + resultado);
    }
}

