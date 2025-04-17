## Definición
El **error relativo** es una medida de la precisión de una aproximación en relación con el valor exacto. Se define como el cociente entre el error absoluto y el valor exacto:
Error Relativo = |Valor Exacto - Valor Aproximado| / |Valor Exacto|

## Algoritmo 
1. **Obtener el valor exacto** y el **valor aproximado**.
2. **Calcular el error absoluto**: `|Valor Exacto - Valor Aproximado|`.
3. **Calcular el error relativo**: `Error Absoluto / |Valor Exacto|`.
4. **Opcional**: Convertir a porcentaje multiplicando por 100.

### Implementación en Java
```java
/**
 * Clase para calcular el error relativo entre un valor exacto y un valor aproximado.
 * El error relativo es una medida de la precisión de una aproximación en comparación
 * con el valor exacto.
 */
public class ErrorRelativo {

    /**
     * Método para calcular el error relativo.
     * 
     * @param valorExacto El valor exacto o teórico (no puede ser cero)
     * @param valorAproximado El valor aproximado o medido
     * @return El error relativo como valor absoluto
     * @throws IllegalArgumentException Si el valor exacto es cero
     */
    public static double calcularErrorRelativo(double valorExacto, double valorAproximado) {
        if (valorExacto == 0) {
            throw new IllegalArgumentException("El valor exacto no puede ser cero (división por cero)");
        }
        return Math.abs((valorExacto - valorAproximado) / valorExacto);
    }

    /**
     * Método principal para demostrar el uso del cálculo de error relativo.
     * 
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        // Ejemplo de cálculo de error relativo
        double exacto = 10.0;
        double aproximado = 9.5;
        
        double error = calcularErrorRelativo(exacto, aproximado);
        System.out.printf("Error relativo: %.4f (%.2f%%)%n", error, error * 100);
    }
}
```
## Ejercicios Prácticos
## Ejercicio 1
Calcula el error relativo cuando el valor exacto es 100 y el valor aproximado es 98.5. 

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-1/imagenes/Error%20Relativo/Ejercicio%201.png" width="35%" alt="Solución Ejercicio 1">

**Análisis** 🧠

Este ejercicio introduce el concepto básico del error relativo con valores sencillos, permitiendo verificar fácilmente el cálculo manual. El resultado (0.015) refleja una discrepancia del 1.5%, típica en casos donde la aproximación es cercana al valor real, demostrando cómo el error relativo cuantifica la magnitud del desvío proporcionalmente.

## Ejercicio 2
En un experimento científico, el valor teórico de una constante es 9.81 m/s² (gravedad), pero se midió como 9.78 m/s². Calcula el error relativo porcentual.

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-1/imagenes/Error%20Relativo/Ejercicio%202.png" width="35%" alt="Solución Ejercicio 2">

**Análisis** 🧠

Aquí se aplica el error relativo a un contexto científico real (medición de gravedad), destacando su utilidad en experimentos. El bajo error (0.31%) indica una medición muy precisa, ilustrando cómo esta métrica evalúa la calidad de datos empíricos frente a valores teóricos aceptados.

## Ejercicio 3
Dos estudiantes aproximaron el valor de π (3.1415926535). El primero usó 3.14 y el segundo 3.1416. Calcula y compara sus errores relativos.

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-1/imagenes/Error%20Relativo/Ejercicio%203.png" width="35%" alt="Solución Ejercicio 2">

**Análisis** 🧠

Compara dos aproximaciones de π, revelando cómo el error relativo sirve para elegir entre métodos o mediciones. La drástica reducción del error (de 0.05% a 0.0002%) con solo dos decimales más evidencia que pequeñas mejoras en precisión pueden impactar significativamente en resultados.

## Ejercicio 4
Al calcular la suma de los primeros 5 términos de la serie 1/n², se obtiene 1.4636. El valor exacto de la serie infinita es π²/6 (≈1.644934). Calcula el error relativo.

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-1/imagenes/Error%20Relativo/Ejercicio%204.png" width="35%" alt="Solución Ejercicio 2">

**Análisis** 🧠

Analiza el error en series truncadas, común en métodos numéricos. El error del 11% refleja la limitación de usar solo 5 términos, mientras que la "precisión" (89%) contextualiza el resultado, vinculando matemáticas puras con aplicaciones prácticas en algoritmos iterativos.

## Ejercicio 5
Al calcular la raíz cuadrada de 2 mediante un método numérico, se obtuvo una aproximación de 1.4142. Sabiendo que el valor real es √2 ≈ 1.41421356237, calcula el error relativo de la aproximación y exprésalo en porcentaje.

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-1/imagenes/Error%20Relativo/Ejercicio%205.png" width="35%" alt="Solución Ejercicio 2">

**Análisis** 🧠

Este ejercicio aplica el error relativo a una aproximación numérica clásica (√2), mostrando cómo incluso con solo 4 decimales, el error es extremadamente bajo (0.00096%). Esto ilustra la eficacia de métodos numéricos bien implementados y cómo el error relativo ayuda a validar su precisión en cálculos matemáticos avanzados.
