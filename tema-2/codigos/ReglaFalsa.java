public class ReglaFalsa {

    /**
     * Función f(x) que se desea analizar.
     * Ejemplo actual: f(x) = x^2 - 4
     *
     * @param x Valor en el que se evalúa la función
     * @return  Resultado de f(x)
     */
    public static double f(double x) {
        return x * x - 4;  //Función
    }

    /**
     * Método que aplica el algoritmo de la regla falsa (falsa posición).
     *
     * @param a          Límite inferior del intervalo
     * @param b          Límite superior del intervalo
     * @param tolerancia Error máximo permitido (cuán precisa queremos la raíz)
     * @param maxIter    Número máximo de iteraciones permitidas
     */
    public static void reglaFalsa(double a, double b, double tolerancia, int maxIter) {
        double fa = f(a);
        double fb = f(b);

        // Verifica que el intervalo sea válido (f(a) y f(b) deben tener signos opuestos)
        if (fa * fb >= 0) {
System.out.println("No hay solución en el intervalo, ya que f(a) y f(b) tienen el mismo signo.");
	 return;  // Salir si no hay solución
        }

        double raiz = 0;
        int iteraciones = 0;

        // Ciclo principal del método de la regla falsa
        while (iteraciones < maxIter) {
            // Cálculo de la raíz aproximada mediante fórmula de falsa posición
            raiz = (a * fb - b * fa) / (fb - fa);
            double fRaiz = f(raiz);
            iteraciones++;

            // Si la función evaluada en la raíz está dentro del margen de tolerancia, se detiene
            if (Math.abs(fRaiz) < tolerancia) {
                break;
            }

            // Actualización del intervalo según el signo de f(raiz)
            if (fa * fRaiz < 0) {
                b = raiz;
                fb = fRaiz;
            } else {
                a = raiz;
                fa = fRaiz;
            }
        }

        // Imprimir los resultados solicitados
        System.out.printf("Raíz aproximada: %.4f\n", raiz);
        System.out.println("Iteraciones: " + iteraciones);
    }

    public static void main(String[] args) {
        // Llamada al método con valores de ejemplo
        double a = 0;
        double b = 5;
        double tolerancia = 0.0001;
        int maxIteraciones = 100;

        reglaFalsa(a, b, tolerancia, maxIteraciones);
    }
}
