## Ejemplo de patrón template method

Veamos un ejemplo del patrón haciendo una analogía con un ejemplo de la vida real. Pensemos en una pizzería y en el proceso de preparar diferentes tipos de pizzas. Intentemos identificar los pasos que un cocinero debe realizar para cocinar y entregar una pizza. Podrían ser: 

1. Preparar la masa.
2. Precocinar la masa.
3. Preparar los ingredientes.
4. Agregar los ingredientes.
5. Cocinar la pizza.
6. Empaquetar la pizza.

Por cada variedad de pizza, los cocineros tienen que hacer todos esos pasos. 

Aplicando el patrón template method, podríamos crear el método esqueleto, con los pasos comunes a todas las pizzas y dejar que los cocineros solo se preocupen por los pasos que no son comunes a todas las pizzas, en este caso, preparar los ingredientes y agregar los ingredientes.
