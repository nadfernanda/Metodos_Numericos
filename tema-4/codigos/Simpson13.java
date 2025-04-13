public class Simpson13 {

    public static double f(double x) {
        return Math.pow(x, 2); // Función a integrar
    }

    public static double simpson13(double a, double b, int n) {
        // Validación: n debe ser par para que el método funcione
        if (n % 2 != 0) {
            throw new IllegalArgumentException("El número de subintervalos (n) debe ser par para usar Simpson 1/3.");
        }

        // Paso 1: calcular el ancho de cada subintervalo
        double h = (b - a) / n;

        // Paso 2: inicializar suma con los extremos
        double suma = f(a) + f(b);

        // Paso 3: sumar los términos intermedios
        for (int i = 1; i < n; i++) {
            double xi = a + i * h; // Punto intermedio

            // Los coeficientes son 4 para impares, 2 para pares
            if (i % 2 == 0) {
                suma += 2 * f(xi);
            } else {
                suma += 4 * f(xi);
            }
        }

        // Paso 4: aplicar la fórmula de Simpson 1/3
        return (h / 3) * suma;
    }

    /**
     * Método principal: define los límites y el número de subintervalos,
     * luego llama al método Simpson para obtener el resultado.
     */
    public static void main(String[] args) {
        double a = 0;  // Límite inferior de integración
        double b = 4;  // Límite superior de integración
        int n = 6;     // Número de subintervalos (debe ser par)

        // Calcular la integral aproximada
        double resultado = simpson13(a, b, n);

        // Mostrar el resultado
        System.out.println("Resultado usando Simpson 1/3: " + resultado);
    }
}

