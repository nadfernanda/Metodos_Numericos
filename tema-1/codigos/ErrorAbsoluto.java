/**
 * Clase que calcula el Error Absoluto entre un valor verdadero y un valor aproximado.
 */
public class ErrorAbsoluto {

    /**
     * Calcula el error absoluto entre dos valores.
     *
     * @param valorVerdadero El valor exacto o verdadero.
     * @param valorAproximado El valor estimado o aproximado.
     * @return El valor del error absoluto.
     */
    public static double calcularErrorAbsoluto(double valorVerdadero, double valorAproximado) {
        // Usamos Math.abs para obtener el valor absoluto de la diferencia
        return Math.abs(valorVerdadero - valorAproximado);
    }

    /**
     * Método principal que ejecuta el ejemplo de cálculo del error absoluto.
     *
     * @param args Argumentos de la línea de comandos (no se utilizan en este caso).
     */
    public static void main(String[] args) {
        // Definimos un valor verdadero y uno aproximado
        double valorVerdadero = 3.1416;
        double valorAproximado = 3.14;

        // Calculamos el error absoluto usando el método
        double error = calcularErrorAbsoluto(valorVerdadero, valorAproximado);

        // Mostramos el resultado en consola con 6 decimales
        System.out.printf("Error absoluto: %.6f\n", error);
    }
}
