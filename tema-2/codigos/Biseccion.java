public class Biseccion {

    /**
     * Función que queremos encontrar la raíz.
     * Puedes cambiar esta función para probar con otros ejercicios.
     * Ejemplo actual: f(x) = x^3 - x - 2
     */
    public static double f(double x) {
        return Math.pow(x, 3) - x - 2;
    }

    /**
     * Método que aplica el algoritmo de bisección.
     * @param a          Límite inferior del intervalo
     * @param b          Límite superior del intervalo
     * @param tolerancia Error máximo permitido (cuán precisa queremos la raíz)
     * @param maxIter    Número máximo de iteraciones permitidas
     */
    public static void biseccion(double a, double b, double tolerancia, int maxIter) {
        // Verificar si hay cambio de signo: f(a) * f(b) debe ser negativo
        if (f(a) * f(b) >= 0) {
            System.out.println("No se puede aplicar el método: no hay cambio de signo en el intervalo.");
            return; // Termina el método porque no hay garantía de raíz
        }

        double c = a; // Variable para almacenar el punto medio
        int iteracion = 0; // Contador de iteraciones

        // Repetimos hasta alcanzar la tolerancia deseada o llegar al límite de iteraciones
        while ((b - a) / 2 > tolerancia && iteracion < maxIter) {
            c = (a + b) / 2; // Calcular punto medio del intervalo

            // Si f(c) es cero exacto, encontramos la raíz
            if (f(c) == 0.0) {
                break;
            }
            // Si f(c) tiene signo distinto a f(a), la raíz está en [a, c]
            else if (f(a) * f(c) < 0) {
                b = c;
            }
            // Si no, la raíz está en [c, b]
            else {
                a = c;
            }

            iteracion++; // Aumentamos el número de iteraciones
        }

        // Mostrar el resultado con 4 decimales
        System.out.printf("Raíz aproximada: %.4f\n", c);
        System.out.println("Iteraciones realizadas: " + iteracion);
    }

    public static void main(String[] args) {
        // Definimos el intervalo donde buscamos la raíz
        double a = 1;              // Límite inferior
        double b = 2;              // Límite superior

        // Precisión deseada: mientras más pequeña, más precisa
        double tolerancia = 1e-6;

        // Número máximo de intentos para encontrar la raíz
        int maxIter = 100;

        // Llamamos al método de bisección
        biseccion(a, b, tolerancia, maxIter);
    }
}