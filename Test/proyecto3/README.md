# Enunciado
Se debe desarrollar un programa que permita calcular el área de una figura geométrica, la cual puede ser un círculo o un cuadrado. El programa debe responder el mensaje: “El área del X es Y unidades”, donde X es el tipo de figura geométrica y Y es el valor calculado del área.
Para el cálculo de las áreas será necesario recibir como parámetro el radio del círculo o el lado del cuadrado, cuyos valores deben ser mayores que cero. En caso de que esta condición no se cumpla, se debe imprimir el mensaje: “El valor del radio o lado debe ser mayor que cero”.
Las fórmulas para el cálculo del área del círculo y del cuadrado son:
- **Círculo**: 𝜋 r^2
- **Cuadrado**: L^2
Recordemos siempre qué casos de prueba van a ser requeridos antes de implementar la lógica de los métodos.

En TDD, se comienza escribiendo pruebas que describen los comportamientos que el programa debe tener, antes de escribir el código real. Por lo tanto, el primer paso es definir los casos de prueba para la funcionalidad que se desea desarrollar.

Para este programa, se pueden definir los siguientes casos de prueba:

- **Caso de prueba 1**: Calcular el área de un círculo con radio 3.
- **Caso de prueba 2**: Calcular el área de un cuadrado con lado 4.
- **Caso de prueba 3**: Intentar calcular el área de un círculo con radio 0.
- **Caso de prueba 4**: Intentar calcular el área de un cuadrado con lado negativo.

Luego, se puede proceder a escribir el código para el programa en sí, utilizando la metodología de TDD.

- **Iteracion 1**: Se construyeron los casos de prueba tal cual acorde a los casos de prueba.
- **Iteracion 2**: Se modificó el código para que compile, y un poco los casos de prueba para hacerlos más general.
- **Iteracion 3**: Luego de un analisis de relaciones, se ve que la entidad AreaCalculator no pertenece al dominio, y se reemplaza por la interfaz FiguraGeometrica, con sus relaciones.