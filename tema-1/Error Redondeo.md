## Definición
El **error de redondeo** es la diferencia entre el valor aproximado de un número y su valor exacto. Este error ocurre cuando se redondea un número a un cierto número de decimales o dígitos significativos. Es común en cálculos numéricos, especialmente cuando se trabaja con números de punto flotante en computadoras, donde la precisión es limitada.  

## Algoritmo  
1. Anota el valor real (el número original).

2. Elige a cuántos decimales vas a redondear.

3. Redondea el valor real al número de decimales elegido.

4. Resta el valor redondeado al valor real.

5. Escribe el resultado del error.

### Implementación en Java
```java
/**
 * Clase que proporciona métodos para calcular el error de redondeo entre un valor exacto y su aproximación.
 */
public class ErrorRedondeo {

    /**
     * Calcula el error de redondeo entre un valor exacto y su aproximación.
     * 
     * @param valorExacto El valor exacto (tipo double).
     * @param valorAproximado El valor aproximado (tipo double).
     * @return El error de redondeo absoluto (diferencia entre el valor exacto y el aproximado).
     * 
     * @throws IllegalArgumentException Si alguno de los parámetros no es un número finito.
     */
    public static double calcularErrorRedondeo(double valorExacto, double valorAproximado) {
        // Validación de parámetros
        if (!Double.isFinite(valorExacto) || !Double.isFinite(valorAproximado)) {
            throw new IllegalArgumentException("Los valores deben ser números finitos.");
        }
        
        return Math.abs(valorExacto - valorAproximado);
    }

    /**
     * Ejemplo de uso del método calcularErrorRedondeo.
     */
    public static void main(String[] args) {
        // Valores de ejemplo
        double exacto = 1.23456789;
        double aproximado = 1.234;
        
        // Cálculo del error
        double error = calcularErrorRedondeo(exacto, aproximado);
        
        // Resultado
        System.out.printf("Valor exacto: %.8f%n", exacto);
        System.out.printf("Valor aproximado: %.3f%n", aproximado);
        System.out.printf("Error de redondeo: %.8f%n", error);
    }
}
```
## Ejercicios Prácticos
## Ejercicio 1
Redondea el valor de Math.E (el número de Euler) a 2 cifras decimales y calcula su error de redondeo.

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-1/imagenes/Error%20Redondeo/Ejercicio%201.png" width="35%" alt="Solución Ejercicio 2">

**Análisis** 🧠

En este ejercicio, trabajamos con el número de Euler (e ≈ 2.718281...) y lo redondeamos a solo dos cifras decimales, obteniendo 2.72. La diferencia entre el valor real y el redondeado genera un error de redondeo de aproximadamente 0.001718, lo cual es relativamente grande si consideramos que se trata de una constante matemática que a menudo se usa con alta precisión en cálculos científicos. Este resultado deja claro que, al reducir tanto los decimales, se pierde información significativa del valor original. Además, el error no es simétrico respecto al redondeo, ya que 2.72 está por encima de e, generando un sesgo positivo en la estimación. Esto ilustra bien cómo los errores de redondeo pueden afectar la exactitud de un resultado.

## Ejercicio 2
Usa como valor real el número 9.87654321, y redondea a 3 cifras decimales. Calcula el error.

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-1/imagenes/Error%20Redondeo/Ejercicio%202.png" width="35%" alt="Solución Ejercicio 2">

**Análisis** 🧠

Aquí se redondea un número decimal extenso a 3 cifras decimales, lo que nos da 9.877. El error de redondeo en este caso es de aproximadamente 0.000457, mucho más pequeño que el del ejercicio anterior. Esto muestra que al conservar más cifras decimales, la pérdida de precisión es menor. Aun así, el error existe y debe considerarse cuando se hacen cálculos encadenados o sensibles. El resultado redondeado está ligeramente por encima del valor real, lo que también puede tener impacto dependiendo del contexto (por ejemplo, en cálculos financieros o físicos). Este ejercicio demuestra la importancia de elegir adecuadamente el número de cifras según la aplicación.

## Ejercicio 3
Usa como valor real -4.98765 y redondea a 1 decimal. Calcula el error de redondeo.


**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-1/imagenes/Error%20Redondeo/Ejercicio%203.png" width="35%" alt="Solución Ejercicio 2">

**Análisis** 🧠

En este caso usamos un valor negativo y lo redondeamos a una sola cifra decimal. El número -4.98765 se convierte en -5.0, y el error generado es de 0.012350. Este es un error notable, pues al redondear a un solo decimal, se pierde mucha información. El análisis aquí es interesante porque el número está más cerca de -4.9 que de -5.0, pero el redondeo automático empuja el valor hacia abajo. En contextos donde los signos importan (como en deudas, cargas eléctricas o direcciones), esta pérdida puede alterar completamente un cálculo. Además, demuestra que el redondeo de números negativos requiere atención especial porque visualmente puede parecer más lejos del real.

## Ejercicio 4
Utiliza el valor real 0.00043219 y redondea a 5 decimales. Calcula el error.


**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-1/imagenes/Error%20Redondeo/Ejercicio%204.png" width="35%" alt="Solución Ejercicio 2">

**Análisis** 🧠

Este ejercicio trata con un número muy pequeño, y lo redondeamos a 5 decimales. Sorpresivamente, no hubo error de redondeo en este caso, es decir, el número ya tenía 5 cifras decimales exactas. Este resultado nos enseña que no todos los redondeos generan errores: si el número ya coincide con el formato solicitado, no hay pérdida de información. Este tipo de casos es común cuando los valores provienen de cálculos exactos o ya están definidos con una precisión específica. Sirve como ejemplo para mostrar que el redondeo no siempre afecta negativamente, pero aun así siempre conviene verificar si es realmente necesario redondear en cada paso.

## Ejercicio 5
Usa 123.456789, redondea a 2 cifras decimales (esto debería truncar parte del número). Calcula el error.

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-1/imagenes/Error%20Redondeo/Ejercicio%205.png" width="35%" alt="Solución Ejercicio 2">

**Análisis** 🧠

Aquí redondeamos un número bastante preciso a solo 2 decimales, obteniendo 123.46, con un error de 0.003211. Aunque el número final se ve limpio, esta operación eliminó casi toda la parte fraccionaria detallada del número. El error en este caso sigue siendo pequeño en proporción al valor total, pero puede ser significativo en aplicaciones donde se manejen datos financieros, mediciones o cálculos acumulativos. También es importante notar que el redondeo aumentó el número ligeramente, lo que en ciertos escenarios puede traducirse en un error sistemático positivo si se repite muchas veces. Este ejercicio demuestra cómo una acción aparentemente "inofensiva" como redondear puede tener implicaciones prácticas no triviales.

