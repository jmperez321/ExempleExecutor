https://moodle.elpuig.xeill.net/pluginfile.php/132108/mod_resource/content/1/Lista%20ejercicios%20concurrencia.pdf

# El puente estrecho
 Construya un sistema para gestionar el tráfico sobre un puente estrecho. El puente lo
pueden atravesar vehículos desde ambos extremos. Como el puente tiene un solo
carril, en un momento dado sólo puede haber vehículos cruzándolo en un único
sentido. El puente tiene una capacidad de carga limitada: si hay más de tres vehículos,
se hunde. Implemente una solución en la que cada vehículo sea un hilo. 
 
El algoritmo que sigue cada vehículo debe ser parecido a esto:

    void vehículo (sentido) {
    llegar_al_puente(sentido)
    cruzar_puente(sentido)
    salir_del_puente(sentido)
    }

El parámetro sentido indica en qué sentido se cruza el puente (o sea, que puede tener
dos valores, por ejemplo izquierda y derecha).
Garantice que no ocurren colisiones y que el puente no se hunde.
Como añadido opcional, intente que no se produzcan esperas indefinidas.