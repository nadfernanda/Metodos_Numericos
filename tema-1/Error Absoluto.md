## Definición
El **error absoluto** es la diferencia entre el valor exacto (o teórico) de una magnitud y su valor aproximado (o medido).
Se define matemáticamente como:
Error Absoluto = |Valor Exacto - Valor Aproximado|
Donde:
- `| |` representa el valor absoluto (siempre positivo).
- **Valor Exacto**: El valor teórico o real.
- **Valor Aproximado**: El valor obtenido mediante medición o cálculo.
- Es una medida de la precisión de una aproximación o medición. A diferencia del error relativo, no considera la magnitud del valor exacto.
  
## Algoritmo 
1. **Obtener el valor exacto** y el **valor aproximado**.
2. **Calcular la diferencia** entre ambos valores.
3. **Tomar el valor absoluto** de la diferencia.

### Implementación en Java
```java
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

```
## Ejercicios Prácticos

## Ejercicio 1
Se ha estimado el valor de e (número de Euler) como 2.71. Calcula el error absoluto si el valor verdadero de e es 2.71828.

**Solución con algoritmo de java**
<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-1/imagenes/Error%20Absoluto/Ejercicio%201.png" width="35%" alt="Solución Ejercicio 1">

**Análisis** 🧠

El error absoluto obtenido al estimar el número de Euler como 2.71 en lugar de 2.71828 es bajo, lo que indica una aproximación bastante precisa. Aunque hay una diferencia, esta es mínima y en la mayoría de aplicaciones prácticas el valor estimado podría considerarse aceptable.

## Ejercicio 2
Se mide la gravedad como 9.8 m/s². El valor verdadero es 9.81 m/s².

**Solución con algoritmo de java**
<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-1/imagenes/Error%20Absoluto/Ejercicio%202.png" width="35%" alt="Solución Ejercicio 2">

**Análisis**🧠

El error absoluto de 0.01 al medir la gravedad sugiere una ligera imprecisión que puede ser relevante dependiendo del contexto. En física o ingeniería, donde se requiere alta exactitud, este pequeño desvío podría afectar cálculos más complejos, aunque para fines educativos o demostrativos es tolerable.

## Ejercicio 3
La raíz cuadrada de 2 se aproxima como 1.41. El valor real es 1.4142.

**Solución con algoritmo de java**
<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-1/imagenes/Error%20Absoluto/Ejercicio%203.png" width="35%" alt="Solución Ejercicio 3">

**Análisis**🧠

La diferencia de 0.0042 al aproximar la raíz de 2 refleja una buena aproximación, especialmente si se considera que muchos cálculos numéricos usan valores truncados. Este pequeño error es aceptable en contextos escolares o de ingeniería básica, aunque se puede reducir fácilmente con una mejor estimación.

## Ejercicio 4
Se estima la constante de Euler-Mascheroni como 0.58. El valor real es 0.5772.

**Solución con algoritmo de java**
<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-1/imagenes/Error%20Absoluto/Ejercicio%204.png" width="35%" alt="Solución Ejercicio 4">

**Análisis**🧠

La estimación de 0.58 en lugar de 0.5772 produce un error absoluto pequeño (0.0028), lo que sugiere que la aproximación es razonable. Dado que esta constante se utiliza principalmente en contextos teóricos, el nivel de precisión dependerá del uso específico, pero en general no representa un error crítico.


## Ejercicio 5
Un estudiante aproxima el valor de π (pi) como 3.142 en un cálculo. El valor verdadero es 3.1416. Calcula el error absoluto de esta aproximación.

**Solución con algoritmo de java**
<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-1/imagenes/Error%20Absoluto/Ejercicio%205.png" width="35%" alt="Solución Ejercicio 5">

**Análisis**🧠

El error absoluto de 0.0004 al usar 3.142 en lugar de 3.1416 demuestra que la estimación del estudiante es muy precisa. Esta pequeña diferencia probablemente no afecte ningún cálculo común, por lo que se trata de una aproximación adecuada para la mayoría de aplicaciones académicas y prácticas cotidianas.
