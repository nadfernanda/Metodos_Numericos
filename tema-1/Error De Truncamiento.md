## Definición
El error de truncamiento es la diferencia entre el valor real de una función (o resultado exacto de una operación) y su aproximación cuando se usa una fórmula numérica que omite parte de la información, como una serie finita o una estimación.

## Algoritmo
1. Obtener el valor real de la función o resultado exacto.
   
2.Calcular el valor aproximado usando una técnica o fórmula.

3. Calcular el error de truncamiento con la fórmula:
   
Error de truncamiento = ∣valorReal − valorAproximado∣

4. (Opcional) Si se desea expresar el error en porcentaje relativo:

Error porcentual=(valor real - valor aprox. / valor real) * 100

### Implementación en Java
```java
public class ErrorTruncamiento {

    /**
     * Calcula el error absoluto de truncamiento.
     * 
     * @param valorReal        El valor exacto de la función.
     * @param valorAproximado  El valor obtenido por una aproximación.
     * @return El error absoluto.
     */
    public static double calcularErrorTruncamiento(double valorReal, double valorAproximado) {
        return Math.abs(valorReal - valorAproximado);
    }

    /**
     * Calcula el error relativo porcentual de truncamiento.
     * 
     * @param valorReal        El valor exacto de la función.
     * @param valorAproximado  El valor obtenido por una aproximación.
     * @return El error relativo en porcentaje.
     */
    public static double calcularErrorPorcentual(double valorReal, double valorAproximado) {
        double errorAbsoluto = calcularErrorTruncamiento(valorReal, valorAproximado);
        return (errorAbsoluto / Math.abs(valorReal)) * 100;
    }

    public static void main(String[] args) {
        // Ejemplo: valor real de e^1 = 2.7182818
        double valorReal = 2.7182818;
        
        // Aproximación con 2 términos de la serie de Taylor: 1 + 1 = 2.0
        double valorAproximado = 2.0;

        double errorAbsoluto = calcularErrorTruncamiento(valorReal, valorAproximado);
        double errorPorcentual = calcularErrorPorcentual(valorReal, valorAproximado);

        System.out.printf("Error absoluto: %.8f%n", errorAbsoluto);
        System.out.printf("Error porcentual: %.4f%%%n", errorPorcentual);
    }
}

```
## Ejercicios Prácticos
## Ejercicio 1 
Aproximar e^x usando la fórmula de la serie de Taylor hasta el segundo término. El valor exacto de e^1 es 2.7182818.

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-1/imagenes/Error%20Truncamiento/Ejercicio%201.png" width="35%" alt="Solución Ejercicio 1">

**Análisis** 🧠

El error es considerable (26.42%) porque estamos truncando la serie de Taylor después de solo un término. Esto demuestra cómo la truncación impacta negativamente la precisión en las aproximaciones. Para mejorar la exactitud, es necesario incluir más términos de la serie de Taylor.

## Ejercicio 2
Calcula el error absoluto y relativo porcentual al aproximar π (valor real = 3.1415926535) usando 3.14 como valor aproximado.

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-1/imagenes/Error%20Truncamiento/Ejercicio%202.png" width="35%" alt="Solución Ejercicio 2">

**Análisis** 🧠

El error absoluto es pequeño (0.0016), pero el error relativo (0.0507%) muestra que la aproximación es bastante precisa. Esto se debe a que π es un valor grande en comparación con el error absoluto.

## Ejercicio 3
Aproximar la constante de Euler usando la suma parcial de la serie de la inversa de los factoriales hasta el décimo término. El valor exacto de e es 2.7182818.

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-1/imagenes/Error%20Truncamiento/Ejercicio%203.png" width="35%" alt="Solución Ejercicio 3">

**Análisis** 🧠

El error relativo es bajo (0.2979%), lo que sugiere que 1.41 es una aproximación aceptable para √2 en contextos donde no se requiere alta precisión.

## Ejercicio 4
Aproximación de $\sin(\pi/6)$ usando solo el primer término de la serie de Taylor ($\sin(x) \approx x$, donde $x = \pi/6 \approx 0.5235987756$). Compara con el valor real (0.5).

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-1/imagenes/Error%20Truncamiento/Ejercicio%204.png" width="35%" alt="Solución Ejercicio 4">

**Análisis** 🧠

El error relativo (~4.72%) es significativo, lo que indica que el primer término de la serie de Taylor no es suficiente para una buena aproximación de 
sin(x).

## Ejercicio 5
Usa la aproximación de $\ln(2)$ con la serie $\ln(1 + x) \approx x - x^2 / 2$ (para $x = 1$, valor aproximado = 0.5). Compara con el valor real ($\ln(2) \approx 0.69314718056$).

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-1/imagenes/Error%20Truncamiento/Ejercicio%205.png" width="35%" alt="Solución Ejercicio 5">

**Análisis** 🧠

El error relativo alto (27.86%) muestra que la serie truncada a solo dos términos no es suficiente para aproximar ln(2) con precisión. Se necesitan más términos.
