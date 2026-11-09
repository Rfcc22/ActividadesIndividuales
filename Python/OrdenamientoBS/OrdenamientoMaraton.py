import random as r

def bubbleSort(array,ascendiente):
    n = len(array)
    totalLoops = 0
    for i in range(n - 1):
        if (ascendiente == True):
            for j in range(n - i - 1):
                if array[j] > array[j + 1]: 
                    array[j], array[j + 1] = array[j + 1], array[j]
                    totalLoops+=1

        else:
            for j in range(n - i - 1):
                if array[j] > array[j +1]:
                    array[j], array[j + 1] = array[j + 1], array[j]
                totalLoops+=1

    print(f"Numero de pasos para Bubble sort {totalLoops}")
    return  array

def insertionSort(array,ascendiente):
    lenght = len(array)
    totalLoopsI = 0

    for i in range(1, lenght):
        key = array[i]
        j = i - 1

        if (ascendiente == True):
            while j >= 0 and array[j] > key:
                array[j + 1] = array[j]
                j -= 1
                totalLoopsI+=1

        else:
            while j >= 0 and array[j] < key:
                array[j + 1] = array[j]
                j -= 1
                totalLoopsI+=1


        array[j + 1] = key
    
    print(f"Numero de pasos para insertion sort {totalLoopsI}")
    return array 


def selectionSort(array,ascendiente):
    n = len(array)
    totalLoops = 0


    for i in range(n - 1):
        min_index = i
        if (ascendiente == True):
            for j in range(i + 1, n):
                if array[j] < array[min_index]: 
                    min_index = j
                    totalLoops+=1

        elif (ascendiente != True):
            for j in range(i+1, n):
                if array[j] > array[min_index]:
                    min_index = j
                    totalLoops+=1


        if min_index != i:
            array[i], array[min_index] = array[min_index], array[i]

    print(f"Numero de pasos para Selection sort {totalLoops}")
    return array


def shellSort(array, ascendiente):
    n = len(array)
    totalLoops = 0

    gap = n // 2
    while gap > 0:
        for i in range(gap, n):
            temp = array[i]
            j = i

            if ascendiente == True:
                while j >= gap and array[j - gap] > temp: 
                    array[j] = array[j - gap]
                    j -= gap
                    totalLoops+=1

            else:
                while j >= gap and array[j - gap] < temp: 
                    array[j] = array[j - gap]
                    j -= gap            
                    totalLoops+=1
    

            array[j] = temp

        gap //= 2
    
    print(f"Numero de pasos para Shell sort {totalLoops}")
    return array

def quickSort(ascendente, array, low=0, high=None, totalLoops = 0):

    if high is None:
        high = len(array) - 1

    if ascendente == True:
        if low < high:
            pivot_idx = quickSortPartition(array, low, high)
            quickSort(True, array, low, pivot_idx - 1,totalLoops)
            quickSort(True, array, pivot_idx + 1, high, totalLoops)
    else:
        if low > high:
            pivot_idx = quickSortPartition(array, low, high)
            quickSort(False,array, low, pivot_idx - 1, totalLoops)
            quickSort(False,array, pivot_idx + 1, high, totalLoops) 

    totalLoops+=1
    return array


def quickSortPartition(array, low, high):
    pivot = array[high]
    i = low - 1

    for j in range(low, high):
        if array[j] <= pivot:
            i += 1
            array[i], array[j] = array[j], array[i]

    array[i + 1], array[high] = array[high], array[i + 1] 
    return i + 1





tiempoCorredores = []
distanciaMaraton = 42.195

for i in range(0,150):
    tiempoCorredores.append(r.randrange(120,300))


print(f"\nBubble Sort\n{bubbleSort(tiempoCorredores,True)}")
print(f"\nSelection Sort\n{selectionSort(tiempoCorredores, True)}")
print(f"\nInsertion Sort\n{insertionSort(tiempoCorredores, True)}")
print(f"\nShell sort\n{shellSort(tiempoCorredores,True)}")
print(f"\nQuick Sort\n{quickSort(True, tiempoCorredores)}")


