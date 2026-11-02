# Caníbales y misioneros
En el África profunda viven junto a un río una tribu de caníbales y un grupo de
misioneros. El río se puede cruzar mediante un bote, con capacidad para tres
personas. Como las aguas son bravas, el bote siempre tiene que transportar carga
completa. Si se sientan dos misioneros y un caníbal, éstos le comen el tarro al caníbal,
hasta el punto de que el caníbal se arroja al agua: hay que evitar esta situación. Las
demás combinaciones no dan problemas.
El sistema debe lanzar varios hilos, uno por cada persona. Escriba dos procedimientos:
LlegaMisionero() y LlegaCaníbal(), para cuando cada persona llega al bote. Estos
procedimientos dejan al hilo esperando hasta que el bote se encuentre lleno y seguro.
Cuando esto ocurra, el procedimiento retorna y se considera que el barco vuelve a
quedar vacío