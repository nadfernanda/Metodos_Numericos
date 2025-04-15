public class PuntoFijo {

    /**
     * Función g(x) que define la ecuación en forma de punto fijo: x = 1 - x^3
     * Esta función se obtiene a partir de f(x) = x^3 + x - 1
     */
    public static double g(double x) {
        return 1 - Math.pow(x, 3);
    }

    public static void main(String[] args) {

        // Valor inicial de x
        double x0 = 0.5;

        // Tolerancia o margen de error aceptable
        double tolerancia = 1e-6;

        // Número máximo de iteraciones permitidas
        int maxIteraciones = 100;

        // Variable para guardar el nuevo valor calculado en cada iteración
        double x1;

        // Contador de iteraciones
        int iteracion = 0;

        // Bucle principal del método de punto fijo
        do {
            // Calcular el nuevo valor usando la función g(x)
            x1 = g(x0);
            iteracion++;

            // Verificar si el error entre la iteración actual y la anterior es menor que la tolerancia
            if (Math.abs(x1 - x0) < tolerancia) {
                // Si cumple la condición de convergencia, mostrar resultados
                System.out.printf("Raíz aproximada: %.4f\n", x1);
                System.out.println("Iteración: " + iteracion);
                break;
            }

            // Actualizar el valor de x0 para la siguiente iteración
            x0 = x1;

        } while (iteracion < maxIteraciones);

        // Si se llegó al máximo de iteraciones sin converger
        if (iteracion == maxIteraciones) {
            System.out.println("No se encontró convergencia en " + maxIteraciones + " iteraciones.");
        }
    }
}
