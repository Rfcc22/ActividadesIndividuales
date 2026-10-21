import csv

weather = []


with open('export.csv', 'r') as f:
    data = csv.reader(f)
    next(data)

    for row in data:
        weather.append([row[3], row[0].split(' ')[0]])
        print(weather)


def bubble_sort_acendente(array):
    n = len(array)
    for i in range(n - 1):
        for j in range(n - i - 1):
            if array[j] > array[j + 1]:
                array[j], array[j + 1] = array[j + 1], array[j]
    return array  

def bubble_sort_decendente(array):
    n = len(array)
    for i in range(n - 1):
        for j in range(n - i - 1):
            if array[j] < array[j + 1]:
                array[j], array[j + 1] = array[j + 1], array[j]
    return array  



print("\nBubble sort acendente\n")
print(bubble_sort_acendente(weather))

print("\nBubble sort decendiente\n")
print(bubble_sort_decendente(weather))
