## Definición
La regla del trapecio es un método de integración numérica que sirve para aproximar el valor de 
una integral definida. Se basa en reemplazar la curva de la función por segmentos de línea recta que
forman trapecios, y luego calcula el área de esos trapecios.
Para una función f(x) definida en el intervalo [a,b], la integral aproximada se calcula como el promedio
de los valores de la función en los extremos multiplicado por el ancho del intervalo:

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-4/imagenes/Regla%20trapecio%201.png" width="30%" alt="Fórmula simple">

Si el intervalo [a,b] se divide en n subintervalos de igual tamaño h=b-a/n, la fórmula generalizada es:

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-4/imagenes/Regla%20trapecio%20compuesta.png" width="30%" alt="Fórmula compuesta">
donde xi = a + i * h para i = 0,1,…,n.

## Algoritmo 
**Para la regla del trapecio simple:**
1. Definir el intervalo de integración con los valores de $a$ y $b$.
2. Evaluar la función en los extremos:
   * Calcular $f(a)$
   * Calcular $f(b)$
3. Aplicar la fórmula:
   Aproximación $= \frac{b - a}{2} [f(a) + f(b)]$
4. Mostrar el resultado como la aproximación de la integral.
   
**Para la regla del trapecio compuesta:**
1. Definir los valores de $a$, $b$, y el número de subintervalos $n$.
2. Calcular la longitud del paso: $h = \frac{b-a}{n}$.
3. Calcular los puntos $x_i = a + i h$ para $i = 0, 1, \ldots, n$.
4. Evaluar la función $f(x)$ en cada $x_i$.
5. Aplicar la fórmula del trapecio compuesta:
   Aproximación $= \frac{h}{2} [f(x_0) + 2(f(x_1) + f(x_2) + \cdots + f(x_{n-1})) + f(x_n)]$
6. Mostrar el resultado como la aproximación de la integral.

### Implementación en Java
```java
public class ReglaTrapecio {

    /**
     * Representa la función a integrar: f(x) = e^(-x^2)
     * 
     * @param x valor en el que se evalúa la función
     * @return resultado de f(x)
     */
    public static double funcion(double x) {
        return Math.exp(-Math.pow(x, 2));
    }

    /**
     * Aplica la regla del trapecio compuesta para aproximar la integral definida
     * 
     * Fórmula: (h/2) * [f(x0) + 2*f(x1) + 2*f(x2) + ... + 2*f(x_{n-1}) + f(xn)]
     * 
     * @param a límite inferior del intervalo
     * @param b límite superior del intervalo
     * @param n número de subintervalos
     * @return aproximación de la integral
     */
    public static double reglaTrapecioCompuesta(double a, double b, int n) {
        double h = (b - a) / n; // Tamaño de cada subintervalo
        double suma = funcion(a) + funcion(b); // f(x0) + f(xn)

        // Suma de los términos con coeficiente 2: f(x1), f(x2), ..., f(x_{n-1})
        for (int i = 1; i < n; i++) {
            double xi = a + i * h; // Punto xi dentro del intervalo
            suma += 2 * funcion(xi);
        }

        return (h / 2) * suma; // Aplicación final de la fórmula
    }

    public static void main(String[] args) {
        double a = 0;    // Límite inferior de integración
        double b = 1;    // Límite superior de integración
        int n = 6;       // Número de subintervalos

        // Calculamos la aproximación usando la regla del trapecio compuesta
        double resultado = reglaTrapecioCompuesta(a, b, n);

        // Imprimimos el resultado con 4 decimales
        System.out.printf("Aproximación de la integral: %.4f%n", resultado);
    }
}
```

## Ejercicios Prácticos
### Ejercicio 1
Dada la Función:
f(x)=x^2 + 3x en el intervalo[1,3],n = 4

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-4/imagenes/Regla_Trapecio/Ejercicio%201.png" width="20%" alt="Solución Ejercicio 1">

**Análisis**
En este caso estamos integrando una función polinómica de segundo grado, que es continua, suave y no presenta ningún tipo de comportamiento inesperado dentro del intervalo [1,3]. La segunda derivada de la función es constante, lo cual es clave, ya que el
error de la regla del trapecio depende directamente de dicha derivada. Como la curvatura de la función es uniforme y no cambia, el método del trapecio ofrece una aproximación sumamente precisa. De hecho, para funciones cuadráticas, la regla del trapecio casi no
presenta error. En consecuencia, el valor obtenido es muy cercano al real y no se justificaría usar un método más complejo o más divisiones a menos que se busque una exactitud extremadamente alta.

### Ejercicio 2
Dada la Función:
f(x)= x ⋅ ln(x+1) en el intervalo [0,2], n=4

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-4/imagenes/Regla_Trapecio/Ejercicio%202.png" width="20%" alt="Solución Ejercicio 2">

**Análisis**
Aquí trabajamos con una función que combina el crecimiento lineal con el comportamiento logarítmico. Aunque no es una función polinómica, es perfectamente continua en el intervalo evaluado y presenta una curvatura suave. La presencia del logaritmo hace que la
función no sea simétrica ni de crecimiento uniforme, pero no representa una dificultad significativa para el método del trapecio. Al no haber cambios bruscos en la segunda derivada, la aproximación obtenida con cuatro subintervalos resulta aceptable. Aun así,
dado que el logaritmo introduce cierta curvatura, el área estimada podría beneficiarse de una mayor cantidad de subintervalos o incluso del uso de la regla de Simpson, especialmente si se requiere más precisión.

### Ejercicio 3
Dada la Función:
f(x)=e^−x^2 en el intervalo[0,1], n=6

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-4/imagenes/Regla_Trapecio/Ejercicio%203.png" width="20%" alt="Solución Ejercicio 3">

**Análisis**
Esta función es un caso muy interesante porque se relaciona con la campana de Gauss, ampliamente usada en estadística. Es una función muy suave, con decaimiento progresivo y simétrico. Sin embargo, su segunda derivada no es constante y presenta un punto donde cambia de comportamiento, lo que genera una curvatura variable en el intervalo. Debido a esto, aunque el método del trapecio logra una buena aproximación, el área calculada puede estar ligeramente subestimada o sobrestimada dependiendo del número de subintervalos.
Con seis particiones, como se usó aquí, la precisión es más que razonable, pero un aumento en la cantidad de tramos o el uso de un método como Simpson podría capturar mejor las variaciones sutiles de la curva.

### Ejercicio 4
Dada la Función:
f(x)=x^2+1/x+1 en el intervalo [1,3], n=4

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-4/imagenes/Regla_Trapecio/Ejercicio%204.png" width="20%" alt="Solución Ejercicio 4">

**Análisis**
En este ejercicio se integra una función racional que no tiene ningún problema de indefinición en el intervalo considerado. Aunque la función no es polinómica, se comporta de forma bastante regular y sin picos de curvatura. La segunda derivada es positiva en todo
el intervalo, lo que indica que la función es cóncava hacia arriba, aunque dicha curvatura disminuye progresivamente a medida que x crece. El método del trapecio, al basarse en segmentos lineales, tiende a subestimar levemente el área bajo funciones con esta forma,
pero la diferencia no es significativa en este caso. Con solo cuatro particiones ya se logra una buena estimación del área, y únicamente en contextos de alta exigencia numérica se justificaría cambiar de método.

### Ejercicio 5
Dada la Función:
f(x)=√x^3+1 en el intervalo [0,2], con n=5

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-4/imagenes/Regla_Trapecio/Ejercicio%205.png" width="20%" alt="Solución Ejercicio 5">

**Análisis**
La función f(x)= √x^3+1 se evalúa en el intervalo [0,2] utilizando la Regla del Trapecio con n=5 subintervalos. La función es continua y suave, lo que hace que el método sea adecuado. Al dividir el intervalo y evaluar en los puntos correspondientes, obtenemos una aproximación razonable de la integral, que es 3.268. La función tiene un crecimiento más lento al principio y se acelera al final, lo que hace que la estimación sea precisa con un número moderado de subintervalos. Si se necesita mayor precisión, se podrían aumentar los subintervalos o usar métodos como la regla de Simpson, pero el resultado obtenido es satisfactorio para los 5 subintervalos empleados.

### Ejercicio 6 (sin solución)
Dada la Función:
f(x)=e^x^2 en el intervalo[0,1], n=4

**Solución con algoritmo de java**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-4/imagenes/Regla_Trapecio/Ejercicio%206.png" width="20%" alt="Solución Ejercicio 6">

**Análisis**
En este ejercicio se integró la función f(x)=e^x^2 en el intervalo [0,1] con n=4 subintervalos. Aunque la función es continua y suave, su integral no tiene una solución exacta en términos de funciones elementales, lo que significa que no puede resolverse con métodos clásicos de integración. Sin embargo, la regla del trapecio ofrece una manera efectiva de aproximar el área bajo la curva. El resultado obtenido con el código (≈ 1.4627) es razonable y útil, especialmente porque en este caso no existe una forma exacta conocida para comparar.
Este ejemplo muestra cómo los métodos numéricos pueden ser esenciales cuando la solución analítica no está disponible.
