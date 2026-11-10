# Los fumadores
En torno a una mesa hay cuatro personas: tres fumadores y un proveedor. Cada
fumador fuma cigarrillos uno detrás de otro. Para poder fumarse un cigarrillo se
necesitan tres ingredientes: papel, tabaco y fósforos. Uno de los fumadores tiene
papel, el otro tabaco y el otro fósforos. El proveedor tiene una cantidad infinita de los
tres ingredientes.
Inicialmente, el agente coloca dos de los ingredientes en la mesa, escogidos al azar. El
fumador que tiene el ingrediente que falta toma lo que hay en la mesa, lía un cigarrillo
y se lo fuma. Cuando termina, se lo indica al proveedor. El proveedor entonces coloca
otros dos ingredientes y el ciclo se repite una y otra vez.
Se pide construir un programa compuesto por cuatro hilos (tres fumadores y el
proveedor) que estén correctamente sincronizados.
La anterior sería una modalidad muy básica del problema con la que se obtendría una
calificación mínima en la práctica. Como opción adicional, se puede variar el
comportamiento de los fumadores para permitir una mayor tema1.concurrencia:

* Cuando un fumador toma lo que hay en la mesa y se pone a fumar, el proveedor
inmediatamente toma dos ingredientes y los coloca en la mesa. De esta forma,
mientras un fumador está fumando, se da la posibilidad de que otro fumador
pueda tomar la pareja de ingredientes que hay en la mesa y así lleguemos a tener
varios fumadores al mismo tiempo. (Aunque esto no ocurrirá si el proveedor coloca
justo el par de ingredientes que no le sirven a los fumadores en espera, pero eso
depende del azar).