## Definición
El **método gráfico** es una técnica utilizada en métodos numéricos para resolver sistemas de ecuaciones lineales
o problemas de optimización con dos variables. Su principal ventaja es la facilidad de interpretación 
al representar visualmente las soluciones en un plano cartesiano.

## Algoritmo 
1.**Plantear el sistema de ecuaciones** en la forma estándar.

2.**Despejar 𝑦 en ambas ecuaciones** (opcional) para facilitar la gráfica.

3.**Graficar ambas ecuaciones**
-Encontrar dos puntos por ecuación.
-Dibujar las rectas en el plano cartesiano.

4.**Identificar el punto de intersección**

-Si las rectas se cruzan en un solo punto → solución única.

-Si son coincidentes → infinitas soluciones.

-Si son paralelas → sin solución.

5.**Verificar la solución** (opcional) sustituyendo los valores en las ecuaciones.

## Ejercicios Prácticos

### Ejercicio 1: Encuentro entre un ciclista y un corredor 🚴‍♂️🏃‍♂️
Un ciclista y un corredor comienzan su recorrido en diferentes puntos y con velocidades distintas.

El ciclista sigue la ecuación: 

**d(t)=3t+12** donde d(t) representa la distancia recorrida en metros después de t minutos.

El corredor sigue la ecuación:

**p(t)=-3+36** donde p(t) representa su distancia en metros después de t minutos.

**Pregunta:** 
¿En qué momento y a qué distancia del punto de inicio se encontrarán el ciclista y el corredor?

**Solución**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-2/Imagenes/M%C3%A9todo%20Gr%C3%A1fico/metodo%20grafico%20ejemplo%201.png" width="40%" alt="método gráfico ejemplo1">

El ciclista y el corredor se encuentran en el minuto 4, a una distancia de 24 metros del punto de inicio. En la gráfica, este punto de intersección se representa como: **(4,24)**.
Esto indica que cuando t=4 minutos, ambas ecuaciones tienen el mismo valor de distancia 24, lo que confirma que en ese instante ambos coinciden en el mismo lugar.

### Ejercicio 2: El Puente Inestable 🌉
En una ciudad costera, los ingenieros están diseñando un puente colgante sobre un río. La estabilidad del puente depende de la tensión en los cables principales, la cual varía según la ecuación:

**f(x) = x³ - 3x² - 3x + 1**

donde x representa la distancia horizontal en metros desde un extremo del puente y f(x) representa la fuerza neta ejercida en esa posición.
Por motivos de seguridad, es crucial encontrar los puntos donde la fuerza neta es cero, es decir, los valores de 
x para los cuales f(x)=0. Estos puntos indican los lugares donde la tensión en los cables es nula, lo que podría comprometer la estabilidad del puente.

**Pregunta:**
Determina en qué puntos el puente presenta una tensión nula resolviendo la ecuación:  x³ - 3x² - 3x + 1 = 0

**Solución**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-2/Imagenes/M%C3%A9todo%20Gr%C3%A1fico/metodo%20grafico%20ejemplo2.png" width="70%" alt="método gráfico ejemplo2">


El puente presenta puntos de tensión nula en las posiciones **x ≈ -1, x ≈ 0.27 y x ≈ 3.73.**  
Los ingenieros deben prestar especial atención a estos puntos para reforzar la estructura y evitar riesgos.

### Ejercicio 3: Encuentro en el Mercado 🛍️
Eric y Kenny son dos vendedores ambulantes que recorren la ciudad vendiendo frutas y verduras. Cada mañana, parten desde distintos puntos y siguen rutas diferentes hasta llegar al mercado principal.

Eric sigue un camino descrito por la ecuación:

**y=2x+3**

Mientras que Kenny sigue un trayecto diferente, descrito por la ecuación:

**y=−x+9**

En algún momento del día, ambos vendedores se cruzan en una intersección antes de llegar al mercado. Para planear mejor su estrategia de ventas, quieren saber en qué punto exacto de la ciudad se encontrarán.

**Pregunta:**
¿En qué coordenadas se cruzan las trayectorias de Eric y Kenny?

**Solución**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-2/Imagenes/M%C3%A9todo%20Gr%C3%A1fico/metodo%20grafico%20ejemplo3.png" width="60%" alt="método gráfico ejemplo2">

Si Eric y Kenny quieren aprovechar su encuentro para intercambiar productos o conversar sobre estrategias de venta, saben que deben encontrarse en la posición **(2,7)** dentro de la ciudad.

### Ejercicio 4: Cruce de Caminos 🏙️
En una ciudad, dos carreteras principales se cruzan en un punto. La primera carretera sigue una trayectoria que se puede representar con la ecuación:

**3x−y=4** 

Mientras que la segunda carretera sigue un recorrido distinto, descrito por la ecuación:

**x+y=2** 

El departamento de tránsito necesita determinar el punto exacto donde ambas carreteras se cruzan para instalar una nueva señal de tráfico y mejorar la seguridad vial.

**Pregunta:**
¿En qué coordenadas se intersectan estas dos carreteras?

**Solución**

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-2/Imagenes/M%C3%A9todo%20Gr%C3%A1fico/metodo%20grafico%20ejemplo4.png" width="60%" alt="método gráfico ejemplo2">

El departamento de tránsito debe colocar la nueva señal en la ubicación **(1.5, 0.5)**  para garantizar una mejor circulación y seguridad en la intersección.

### Ejercicio 5: Intersección de Rutas 🚌
Dos rutas de autobuses atraviesan la ciudad y en algún punto se cruzan. La primera ruta sigue el camino descrito por la ecuación:

**2x+3y=12** 

Mientras que la segunda ruta sigue la trayectoria:

**4x−y=5** 

Los conductores de ambas líneas de autobuses quieren saber en qué punto exacto se intersectan para optimizar los tiempos de viaje y evitar congestión en la parada compartida.

**Pregunta:**
¿En qué coordenadas se intersectan ambas rutas?

**Solución**

**Tablas de Tabulación**
**Primera función:** y = (12-2x)/3
| x | y |
|---|---|
| 0 | 4 |
| 3 | 2 |
| 6 | 0 |

**Segunda función:** y = 4x - 5
| x | y |
|---|---|
| 0 | -5 |
| 2 | 3 |
| 3 | 7 |

<img src="https://github.com/nadfernanda/Metodos_Numericos/blob/main/tema-2/Imagenes/M%C3%A9todo%20Gr%C3%A1fico/metodo%20grafico%20ejemplo5.png" width="60%" alt="método gráfico ejemplo2">

Los conductores pueden planear su parada conjunta en la ubicación **(1.93, 2.71)** para mejorar la eficiencia del servicio y reducir tiempos de espera. Además, la tabulación de valores permite visualizar gráficamente cómo se cruzan las rutas en ese punto.
