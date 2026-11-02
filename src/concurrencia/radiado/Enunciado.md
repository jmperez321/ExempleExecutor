# Radiado atómico (atomic broadcast)
Tenemos un proceso productor y N procesos consumidores que se comunican a través
de un búfer de capacidad C. Cada elemento producido va destinado a todos los
consumidores: un elemento en el búfer no desaparece hasta que ha sido leído por
todos los consumidores. Cada consumidor va leyendo los elementos producidos de
forma secuencial, a su propio ritmo: puede haber consumidores mucho más
adelantados que otros.