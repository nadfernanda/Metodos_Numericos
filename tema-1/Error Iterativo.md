## Definición
El error iterativo es la diferencia entre el valor aproximado obtenido en una iteración actual ($x_n$) y el valor aproximado de la iteración anterior ($x_{n-1}$). Se utiliza en métodos numéricos iterativos (como Newton-Raphson, bisección, etc.) para determinar cuándo detener las iteraciones, asegurando que la solución converja a un valor aceptable dentro de una tolerancia predefinida.

## Algoritmo
1. Definir la tolerancia ($\epsilon$): Límite aceptable para el error.
   
2. Obtener $x_n$ y $x_{n-1}$: Valores de la iteración actual y anterior.
   
3. Calcular el error: Usar una de las fórmulas anteriores.
   
4. Verificar convergencia: Si $E < \epsilon$, se detiene el proceso.

### Implementación en Java
```java
/**
 * Clase para calcular el error iterativo en métodos numéricos.
 * Incluye errores absoluto, relativo y porcentual entre iteraciones.
 */
public class ErrorIterativo {

    /**
     * Calcula el error absoluto iterativo.
     * 
     * @param xActual  Valor de la iteración actual (x_n).
     * @param xAnterior Valor de la iteración anterior (x_{n-1}).
     * @return Error absoluto iterativo.
     */
    public static double errorAbsolutoIterativo(double xActual, double xAnterior) {
        return Math.abs(xActual - xAnterior);
    }

    /**
     * Calcula el error relativo iterativo.
     * 
     * @param xActual  Valor de la iteración actual (x_n).
     * @param xAnterior Valor de la iteración anterior (x_{n-1}).
     * @return Error relativo iterativo.
     * @throws IllegalArgumentException Si xActual es cero (para evitar división por cero).
     */
    public static double errorRelativoIterativo(double xActual, double xAnterior) {
        if (xActual == 0) {
            throw new IllegalArgumentException("xActual no puede ser cero en el error relativo.");
        }
        return Math.abs(xActual - xAnterior) / Math.abs(xActual);
    }

    /**
     * Calcula el error relativo porcentual iterativo.
     * 
     * @param xActual  Valor de la iteración actual (x_n).
     * @param xAnterior Valor de la iteración anterior (x_{n-1}).
     * @return Error relativo porcentual iterativo.
     */
    public static double errorPorcentualIterativo(double xActual, double xAnterior) {
        return errorRelativoIterativo(xActual, xAnterior) * 100;
    }

    /**
     * Ejemplo de uso: Aproximación de la raíz cuadrada de 2 usando el método de Newton-Raphson.
     */
    public static void main(String[] args) {
        double tolerancia = 0.0001; // Tolerancia del 0.01%
        double xAnterior = 2.0; // Valor inicial (puede ser cualquier aproximación)
        double xActual = 1.5; // Primera iteración manual

        int iteracion = 1;
        double errorRelPerc;

        System.out.println("Iteración\tAproximación\tError Relativo %");
        System.out.printf("%d\t\t%.6f\t\t-\n", iteracion, xAnterior);

        do {
            iteracion++;
            xAnterior = xActual;
            xActual = (xAnterior + 2.0 / xAnterior) / 2; // Fórmula de Newton-Raphson para √2

            errorRelPerc = errorPorcentualIterativo(xActual, xAnterior);

            System.out.printf("%d\t\t%.6f\t\t%.6f%%\n", iteracion, xActual, errorRelPerc);
        } while (errorRelPerc > tolerancia);

        System.out.printf("\nResultado final: √2 ≈ %.6f (con error < %.4f%%)", xActual, tolerancia);
    }
}
```
## Ejercicios Prácticos
## Ejercicio 1 
Queremos sumar 0.1 diez veces y comparar el resultado con el valor esperado (1.0). Calcula el error absoluto en cada paso.

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-1/imagenes/Error%20Iterativo/Ejercicio%201.png" width="35%" alt="Solución Ejercicio 2">

**Análisis** 🧠

El error absoluto disminuye progresivamente a medida que la suma se acerca al valor real (1.0). En la última iteración, el error es cero porque la aproximación coincide exactamente con el valor esperado. Esto demuestra cómo, en operaciones acumulativas, el error puede reducirse sistemáticamente al aumentar las iteraciones.

## Ejercicio 2
Aproxima el valor de π (3.1416) usando la fracción 22/7. Calcula el error relativo porcentual.

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-1/imagenes/Error%20Iterativo/Ejercicio%202.png" width="35%" alt="Solución Ejercicio 2">

**Análisis** 🧠

La fracción 22/7 aproxima π con un error relativo mínimo (0.0402%), lo que confirma su utilidad como estimación práctica. Este ejemplo ilustra que incluso fórmulas sencillas pueden ofrecer resultados muy cercanos al valor real en contextos donde no se requiere precisión extrema.

## Ejercicio 3
Usa el método de Newton-Raphson para aproximar √9 (valor real = 3.0). Muestra el error en cada paso.

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-1/imagenes/Error%20Iterativo/Ejercicio%203.png" width="35%" alt="Solución Ejercicio 2">

**Análisis** 🧠

El método de Newton-Raphson converge rápidamente hacia la raíz cuadrada de 9, reduciendo el error de 0.4 a casi 0.0 en solo cuatro iteraciones. Esto resalta la eficiencia del método para funciones bien comportadas, donde una buena aproximación inicial acelera la convergencia.

## Ejercicio 4
Partiendo de 2.0, divide el número entre 2 en cada iteración hasta que se acerque a 1.0. Calcula el error absoluto en cada paso.

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-1/imagenes/Error%20Iterativo/Ejercicio%204.png" width="35%" alt="Solución Ejercicio 2">

**Análisis** 🧠

Aquí, el error aumenta en cada iteración porque la operación (dividir entre 2) aleja el resultado del valor objetivo (1.0). Este caso advierte sobre la importancia de elegir algoritmos que converjan al valor deseado, ya que no todos los métodos iterativos garantizan una reducción del error.

## Ejercicio 5
Calcula el interés compuesto de $1000 al 5% anual durante 3 años. Compara con el valor real y calcula el error porcentual.

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-1/imagenes/Error%20Iterativo/Ejercicio%205.png" width="35%" alt="Solución Ejercicio 2">

**Análisis** 🧠

El interés simple subestima el valor real del interés compuesto en solo un 0.66%, pero en aplicaciones financieras, este pequeño error puede traducirse en diferencias significativas con el tiempo. El ejercicio muestra cómo las aproximaciones simplificadas, aunque útiles, pueden omitir efectos acumulativos importantes.
