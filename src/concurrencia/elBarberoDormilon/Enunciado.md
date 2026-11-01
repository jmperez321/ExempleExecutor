# El barbero dormilón (the sleeping barber)
Este problema fue planteado por Edsger Dijkstra. Una barbería tiene una sala de espera con N sillas, 
más la silla de barbero. Si no hay clientes, el barbero se echa a
dormir. Si un cliente entra en la barbería y encuentra todas las sillas ocupadas, se
marcha de la barbería. Si el barbero está ocupado, pero hay sillas disponibles, el cliente
se sienta en una de ellas. Si el barbero está dormido, el cliente lo despierta. Se trata de
escribir un programa que coordine al barbero y los clientes, cada uno de los cuales se
corresponde con un hilo