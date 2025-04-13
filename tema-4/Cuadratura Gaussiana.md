## Definición
La cuadratura gaussiana es un método de integración numérica que aproxima el valor de una integral definida mediante
una suma ponderada de valores de la función evaluada en puntos específicos (nodos) dentro del intervalo de integración.
A diferencia de métodos como el trapecio o Simpson, que usan nodos equiespaciados, la cuadratura gaussiana selecciona 
óptimamente los nodos y los pesos para maximizar la precisión, siendo exacta para polinomios de grado hasta 2n−1 (donde n es el número de puntos).

## Algoritmo 
**Paso 1: Cambiar el intervalo**

Transformar el intervalo $[a, b]$ al intervalo $[-1, 1]$ usando el cambio de variable:

$x = \frac{b - a}{2}t + \frac{b + a}{2}$, entonces: $dx = \frac{b - a}{2}dt$
La integral queda:

$\int_a^b f(x) dx = \frac{b - a}{2} \int_{-1}^1 f\left(\frac{b - a}{2}t + \frac{b + a}{2}\right) dt$

**Paso 2: Seleccionar el número de puntos $n$**

Decidir cuántos puntos $n$ quieres usar (más puntos = más precisión).

**Paso 3: Obtener los nodos $x_i$ y pesos $w_i$**

* Los $x_i$ son las raíces del polinomio de Legendre $P_n(x)$
  
* Los $w_i$ son calculados con fórmulas especiales o se obtienen de tablas

**Paso 4: Evaluar la función en los puntos transformados**

Para cada $x_i$, transformar al intervalo original y evaluar la función:

$x'_i = \frac{b - a}{2} x_i + \frac{b + a}{2}$

**Paso 5: Calcular la suma**

Finalmente:

$\int_a^b f(x) dx \approx \frac{b - a}{2} \sum_{i=1}^n w_i f(x'_i)$


### Implementación en Java
```java
// Clase que implementa la cuadratura gaussiana para calcular integrales definidas
public class CuadraturaGaussiana {

    /**
     * Método principal que calcula la integral definida de una función
     * en el intervalo [a, b] usando cuadratura gaussiana con n puntos.
     *
     * @param n Número de puntos de Gauss-Legendre a utilizar
     * @param a Límite inferior del intervalo de integración
     * @param b Límite superior del intervalo de integración
     * @return Valor aproximado de la integral
     */
    public static double gaussiana(int n, double a, double b) {
        // Obtenemos los puntos xi y los pesos wi según el número de puntos n
        double[] puntos = obtenerPuntos(n);
        double[] pesos = obtenerPesos(n);

        double resultado = 0.0;

        // Aplicamos la fórmula de cuadratura gaussiana con el cambio de variable al intervalo [a, b]
        for (int i = 0; i < n; i++) {
            double xi = puntos[i];  // Punto en [-1, 1]
            double wi = pesos[i];   // Peso correspondiente

            // Transformamos el punto xi del intervalo [-1, 1] al intervalo [a, b]
            double x = 0.5 * (b - a) * xi + 0.5 * (a + b);

            // Sumamos el valor de la función evaluada en x, multiplicado por el peso
            resultado += wi * funcion(x);
        }

        // Multiplicamos por el factor de cambio de variable
        resultado *= 0.5 * (b - a);

        return resultado;
    }

    /**
     * Función a integrar. Aquí se usa una función de ejemplo: f(x) = x^2.
     *
     * @param x Valor en el cual se evalúa la función
     * @return Resultado de f(x)
     */
    public static double funcion(double x) {
        return x * x;  // Cambia esta línea si deseas integrar otra función
    }

    /**
     * Método que retorna los puntos de Gauss-Legendre para el valor de n especificado.
     * Estos puntos son predefinidos y dependen del número de puntos n.
     *
     * @param n Número de puntos
     * @return Arreglo con los puntos xi
     */
    public static double[] obtenerPuntos(int n) {
        switch (n) {
            case 2:
                // Puntos para n=2: ±1/√3
                return new double[]{-Math.sqrt(1.0 / 3), Math.sqrt(1.0 / 3)};
            case 3:
                // Puntos para n=3: ±√(3/5), 0
                return new double[]{-Math.sqrt(3.0 / 5), 0, Math.sqrt(3.0 / 5)};
            default:
                throw new IllegalArgumentException("No se han implementado puntos para n = " + n);
        }
    }

    /**
     * Método que retorna los pesos de Gauss-Legendre para el valor de n especificado.
     *
     * @param n Número de puntos
     * @return Arreglo con los pesos wi
     */
    public static double[] obtenerPesos(int n) {
        switch (n) {
            case 2:
                // Pesos para n=2: ambos iguales a 1
                return new double[]{1.0, 1.0};
            case 3:
                // Pesos para n=3: 5/9, 8/9, 5/9
                return new double[]{5.0 / 9, 8.0 / 9, 5.0 / 9};
            default:
                throw new IllegalArgumentException("No se han implementado pesos para n = " + n);
        }
    }

    /**
     * Método principal donde se ejecuta el programa.
     */
    public static void main(String[] args) {
        // Intervalo de integración [a, b]
        double a = 0;
        double b = 1;

        // Número de puntos de Gauss que se quiere usar
        int n = 2;

        // Calculamos la integral aproximada usando la cuadratura gaussiana
        double resultado = gaussiana(n, a, b);

        // Mostramos el resultado en consola
        System.out.println("Resultado de la integral: " + resultado);
    }
}

```
## Ejercicios Prácticos

## Ejercicio 1
Dada la Función:

f(x) = x³ - 2x + 1 en el intervalo [0,2] usando cuadratura gaussiana
de n=2 puntos.

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-4/imagenes/Cuadratura_Gaussiana/Ejercicio%201.png" width="35%" alt="Solución Ejercicio 1">

**Análisis**

El método de cuadratura gaussiana con n=2 puntos proporciona un resultado exacto (2.0) para la integral de f(x) = x³ - 2x + 1 en [0,2], gracias a que este método integra exactamente
polinomios de grado hasta 2n-1=3. Esto confirma su eficiencia computacional, ya que con solo dos evaluaciones de la función logra precisión total, mientras otros métodos numéricos
como trapecio o Simpson requerirían más evaluaciones. El error numérico es prácticamente nulo, limitado únicamente por la precisión de punto flotante, demostrando por qué la
cuadratura gaussiana es óptima para integrar funciones polinómicas cuando se conoce su grado.

## Ejercicio 2
Dada la Función:

f(x) = 1/(1+x²) en el intervalo [0,1] usando cuadratura gaussiana
con n=2 puntos.

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-4/imagenes/Cuadratura_Gaussiana/Ejercicio%202.png" width="35%" alt="Solución Ejercicio 2">

**Análisis**

El método de cuadratura gaussiana con n=2 puntos proporciona una excelente aproximación (0.7869) para la integral de f(x) = 1/(1+x²) en [0,1], cuyo valor exacto es π/4 ≈
0.7854. El error relativo es aproximadamente 0.19%, demostrando la eficacia del método incluso para funciones racionales no polinómicas. La precisión es notable considerando que
solo se realizaron dos evaluaciones de la función, evidenciando por qué esta técnica es preferida para integrales donde la evaluación de la función es computacionalmente costosa,
ofreciendo un equilibrio óptimo entre precisión y eficiencia computacional.

## Ejercicio 3
Dada la Función:

f(x) = sin(πx) en el intervalo[0,1] usando cuadratura gaussiana con
n=2 puntos.

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-4/imagenes/Cuadratura_Gaussiana/Ejercicio%203.png" width="35%" alt="Solución Ejercicio 3">

**Análisis**

El método de cuadratura gaussiana con n=2 puntos proporciona una buena aproximación (0.6182) para la integral de f(x) = sin(πx) en [0,1], cuyo valor exacto es 2/π ≈ 0.6366. El
error relativo es aproximadamente 2.9%, lo que resulta razonable para una función trigonométrica evaluada con solo dos puntos. Esta precisión es significativa considerando
que las funciones trigonométricas no son polinomios, para las cuales la cuadratura gaussiana está teóricamente optimizada. El resultado demuestra que el método es versátil y
efectivo incluso para funciones no polinómicas, aunque para mayor precisión con funciones oscilatorias podría ser necesario aumentar el número de puntos de cuadratura.

## Ejercicio 4
Dada la Función:

f(x) = √x en el intervalo [0,4] usando cuadratura gaussiana con n=2
puntos.

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-4/imagenes/Cuadratura_Gaussiana/Ejercicio%204.png" width="35%" alt="Solución Ejercicio 4">

**Análisis**

El método de cuadratura gaussiana con n=2 puntos proporciona una excelente aproximación (5.3912) para la integral de f(x) = √x en [0,4], cuyo valor exacto es 16/3 ≈
5.3333. El error relativo es aproximadamente 1.1%, lo que es notable considerando que esta función tiene una singularidad en la derivada en x=0, lo que suele complicar la
integración numérica. Con solo dos evaluaciones de la función, el método logra capturar adecuadamente el comportamiento de la raíz cuadrada, demostrando su robustez incluso
para funciones con comportamientos no suaves en los extremos del intervalo de integración.

## Ejercicio 5 (sin solución)
Dada la Función:

f(x) = e^(-x²) en el intervalo [0,2] usando cuadratura gaussiana
con n=2 puntos.

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-4/imagenes/Cuadratura_Gaussiana/Ejercicio%205.png" width="35%" alt="Solución Ejercicio 5">

**Análisis**

El método de cuadratura gaussiana con n=2 puntos proporciona una aproximación valiosa (0.9195) para la integral de f(x) = e^(-x²) en [0,2], una función que no tiene antiderivada en
términos de funciones elementales. Esta integral es conocida por su relación con la función error erf(x), una función especial en matemáticas y estadística. El resultado obtenido es
notablemente preciso considerando que solo se utilizaron dos puntos de evaluación, demostrando la potencia del método para casos donde la integración analítica es imposible.
Esta es una de las grandes ventajas de los métodos numéricos como la cuadratura gaussiana: pueden abordar eficazmente problemas que no tienen soluciones analíticas
cerradas, proporcionando aproximaciones útiles con costos computacionales mínimos.
