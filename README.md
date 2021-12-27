#Sorting Visualiser

An easily extendable program to visualise sorting algorithms.

You can see the way a sorting algorithm works on any set of elements. For now the program supports only integer lists, but may one day be extended to work with other variable types.

Moreover, the order of sorting (ascending or descending) is configurable too and is easily implemented in new algorithms. 

New sorting algorithms are added by inheriting ```Sort<T extends Comparable<T>>```.
Algorithms are visualised using callbacks with three supported types:
- dividing
- swapping
- searching

By editing config.json you can change element colors and window size.