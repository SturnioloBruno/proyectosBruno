# Ejercicio de TDD (Test Development Driven)
Este repositorio contiene un ejercicio de muestra que se puede utilizar para mostrar el proceso de desarrollo iterativo utilizando la metodología de TDD (Test Development Driven).
Para poder apreciar las iteraciones commit a commit, se debe cambiar a la rama TDD donde se encuentra el ejercicio correspondiente.
Cada commit representa un paso en el proceso de desarrollo utilizando TDD.
El ejercicio correspondiente al proyecto 2 se encuentra en la carpeta test.

¡Disfruta el ejercicio de TDD! 

Iteracion 1: Se comienza con el testeo, al no existir todavía el método, falla por error de compilación.

Iteracion 2: Se busca lograr que el caso al menos compile, para lo cual se programa el método que se desea probar con el objetivo de que simplemente pase la compilación, no necesariamente de que resuelva bien la necesidad de negocio.

Iteracion 3: Hacemos lo estrictamente necesario para que el caso pase correctamente el test. En este caso, como siempre devuelve 1, el test pasará correctamente.

Iteracion 4: En nuestro ejemplo, nos damos cuenta de que usando un tipo de dato booleano podemos ser más eficientes, por lo que hacemos las modificaciones necesarias para implementar esta mejora.

Iteracion 5: Hacemos que el algoritmo para determinar la paridad sea cada vez más eficiente. Para este ejemplo, dado que todo número par al dividirlo por 2 siempre su resto da 0 (cero), podemos utilizar el operador % que nos devuelve el resto de una división.