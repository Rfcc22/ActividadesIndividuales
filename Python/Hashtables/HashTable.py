import numpy as np
Empleados = np.zeros(10,dtype=int)

#Valores iniciales = 25, 18, 42, 38, 13, 27 

def hashTable(array):

    hashTable = np.zeros(10, dtype=int)
    for i in range(0, len(array)):
        n = Empleados[i] % 10
        
        if hashTable[n] != 0:
            hashTable[9] = Empleados[i]
        else:
            hashTable[n] = Empleados[i]



    print(hashTable)    

    
for i in range(0, 9):
    empleadoAAnadir = int(input("Introduce el numero de identificacion del empleado ").strip())
    Empleados[i] = empleadoAAnadir

hashTable(Empleados)











