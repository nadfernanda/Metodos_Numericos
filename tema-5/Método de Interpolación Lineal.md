## Definición
El método de interpolación lineal es una forma sencilla y directa de estimar un valor desconocido que se encuentra entre dos valores conocidos. La idea principal es asumir que existe una relación lineal (una línea recta) entre los dos puntos de datos conocidos y usar esa línea para predecir el valor en el punto intermedio.

Imagina que tienes dos puntos en una gráfica:

- Punto 1: $(x_0, y_0)$
  
- Punto 2: $(x_1, y_1)$

Si quieres encontrar el valor de $y$ para un valor de $x$ que está entre $x_0$ y $x_1$, la interpolación lineal traza una línea recta que conecta estos dos puntos y luego encuentra el valor de $y$ en esa línea para el $x$ deseado.

## Algoritmo 
1. Toma dos puntos conocidos: $(x_0, y_0)$ y $(x_1, y_1)$.
   
2. Elige un valor de $x$ que esté entre $x_0$ y $x_1$.
   
3. Aplica la fórmula:
   
   $$f(x) = y_0 + \frac{(y_1 - y_0)}{(x_1 - x_0)} \cdot (x - x_0)$$

4. El resultado es una estimación de $f(x)$.

### Implementación en Java
```java
/**
 * Método de Interpolación Lineal
 * 
 * La interpolación lineal estima el valor de una función f(x)
 * dentro de dos puntos conocidos (x0, y0) y (x1, y1).
 * Se asume que el cambio entre los puntos es lineal.
 */
public class InterpolacionLineal {

    /**
     * Calcula la interpolación lineal en un punto x
     * @param x0 Primer valor de x conocido
     * @param y0 Valor de la función en x0
     * @param x1 Segundo valor de x conocido
     * @param y1 Valor de la función en x1
     * @param x Punto donde se desea interpolar
     * @return Valor aproximado de f(x)
     */
    public static double interpolar(double x0, double y0, double x1, double y1, double x) {
        // Aplicar la fórmula de interpolación lineal:
        // f(x) = y0 + ((y1 - y0) / (x1 - x0)) * (x - x0)
        double resultado = y0 + ((y1 - y0) / (x1 - x0)) * (x - x0);
        return resultado;
    }

    public static void main(String[] args) {
        // Puntos conocidos
        double x0 = 2.0, y0 = 4.0;
        double x1 = 5.0, y1 = 10.0;

        // Punto a interpolar
        double x = 3.5;

        // Cálculo de la interpolación
        double valorInterpolado = interpolar(x0, y0, x1, y1, x);

        // Mostrar resultado
        System.out.println("El valor interpolado en x = " + x + " es: " + valorInterpolado);
    }
}

```
## Ejercicios Prácticos
## Ejercicio 1
Una máquina fue monitoreada a las 9:00 a.m. y marcó 30 °C. A las 11:00 a.m. registró 90 °C. ¿Qué temperatura se estima que tenía a las 10:15 a.m.?

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-5/imagenes/Inter_Lineal/Ejercicio%201.png" width="35%" alt="Solución Ejercicio 2">

**Análisis** 

De acuerdo con el método de interpolación lineal, este ejercicio estima el valor intermedio de temperatura bajo la suposición de que el aumento entre las 9:00 a.m. y 11:00 a.m. fue constante. Es un caso clásico donde la variación continua del tiempo permite aplicar el método con bastante fiabilidad. Se considera una buena aproximación en ausencia de eventos térmicos abruptos.

## Ejercicio 2
Un auto viajaba a 60 km/h a los 10 minutos del recorrido y a 100 km/h a los 30 minutos. ¿Cuál fue su velocidad estimada a los 20 minutos?

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-5/imagenes/Inter_Lineal/Ejercicio%202.png" width="35%" alt="Solución Ejercicio 2">

**Análisis** 

Aplicando la interpolación lineal, se puede estimar la velocidad del vehículo a los 20 minutos suponiendo un incremento uniforme desde los 10 hasta los 30 minutos. Este enfoque es válido si no hubo cambios bruscos en la aceleración. El método permite conocer un valor promedio en un punto intermedio, útil en situaciones de control de tráfico o consumo.

## Ejercicio 3
Se mide el pH de una solución con una concentración de 5 ml (pH 4.0) y otra con 15 ml (pH 6.0). ¿Cuál sería el pH aproximado con 12 ml de concentración?

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-5/imagenes/Inter_Lineal/Ejercicio%203.png" width="35%" alt="Solución Ejercicio 2">

**Análisis** 

El método de interpolación lineal se emplea aquí para estimar el pH de una solución química, bajo la suposición de una relación lineal entre volumen y acidez. Aunque el pH puede tener variaciones no lineales, si el intervalo es pequeño y el sistema está amortiguado, la interpolación es una herramienta aceptable para obtener una estimación rápida y cercana al valor real.

## Ejercicio 4
Una fuente de luz emite 800 lux a 1 metro y 200 lux a 4 metros. ¿Qué intensidad habrá a 2 metros?

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-5/imagenes/Inter_Lineal/Ejercicio%204.png" width="35%" alt="Solución Ejercicio 2">

**Análisis** 

Este ejercicio aplica interpolación lineal a un fenómeno que, en la realidad, sigue una ley inversa cuadrática. Sin embargo, en distancias cortas y condiciones controladas, la suposición de una variación lineal puede ser razonable para estimaciones rápidas. El método es útil si no se requiere alta precisión física.


## Ejercicio 5(sin solución)
Se tienen dos puntos con la misma coordenada X: (4.0, 10.0) y (4.0, 20.0). Se desea interpolar en x = 4.0. ¿Qué ocurre?

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-5/imagenes/Inter_Lineal/Ejercicio%205.png" width="35%" alt="Solución Ejercicio 2">

**Análisis** 

De acuerdo con el fundamento de la interpolación lineal, los puntos deben tener valores de `x` distintos, ya que la fórmula implica dividir entre `(x1 - x0)`. En este caso, al tener `x0 = x1`, se produce una división por cero, lo cual hace imposible la interpolación. Este tipo de configuración debe ser evitado, ya que contradice las condiciones del método.
