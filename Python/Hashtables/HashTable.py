import numpy as np
Empleados = np.zeros(10)

#Valores iniciales = 25, 18, 42, 38, 13, 27 

def hashTable(array):

    hashTable = np.zeros(10)
    for i in range(0, len(array)):
        n = i % 10
        

        
        hashTable[n] = i


    print(hashTable)    

    


for i in range(0, 10):
    empleadoAAnadir = int(input("Introduce el numero de identificacion del empleado").strip())
    Empleados[i] = empleadoAAnadir











