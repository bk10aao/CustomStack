# Custom Stack

Implementation of a Java Stack.

All methods implemented are identical to those found in the Java Stack interface.

### Time Complexity

| Method                              |      Custom      |       JDK        | Winner  |
|:------------------------------------|:----------------:|:----------------:|:-------:|
| **CustomStack()**                   |      $O(1)$      |      $O(1)$      |   Tie   |
| **CustomStack(int)**                |      $O(1)$      |      $O(1)$      |   Tie   |
| **CustomStack(Collection)**         |      $O(m)$      |      $O(m)$      |   Tie   |
| **add(E)**                          | $O(1)$ amortized | $O(1)$ amortized |   Tie   |
| **add(int, E)**                     |      $O(n)$      |      $O(n)$      |   Tie   |
| **addAll(Collection)**              |      $O(m)$      |      $O(m)$      |   Tie   |
| **addAll(int, Collection)**         |    $O(n + m)$    |    $O(n + m)$    |   Tie   |
| **capacity()**                      |      $O(1)$      |      $O(1)$      |   Tie   |
| **clear()**                         |      $O(n)$      |      $O(n)$      |   Tie   |
| **clone()**                         |      $O(n)$      |      $O(n)$      |   Tie   |
| **contains(Object)**                |      $O(n)$      |      $O(n)$      |   Tie   |
| **containsAll(Collection)**         |    $O(n + m)$    |    $O(n + m)$    |   Tie   |
| **empty()**                         |      $O(1)$      |      $O(1)$      |   Tie   |
| **ensureCapacity(int)**             |      $O(n)$      |      $O(n)$      |   Tie   |
| **get(int)**                        |      $O(1)$      |      $O(1)$      |   Tie   |
| **indexOf(Object)**                 |      $O(n)$      |      $O(n)$      |   Tie   |
| **indexOf(Object, int)**            |      $O(n)$      |      $O(n)$      |   Tie   |
| **iterator()**                      |      $O(n)$      |      $O(1)$      | **JDK** |
| **lastIndexOf(Object)** (inherited) |      $O(n)$      |      $O(n)$      |   Tie   |
| **lastIndexOf(Object, int)**        |      $O(n)$      |      $O(n)$      |   Tie   |
| **listIterator()**                  |      $O(n)$      |      $O(1)$      | **JDK** |
| **listIterator(int)**               |      $O(n)$      |      $O(1)$      | **JDK** |
| **peek()**                          |      $O(1)$      |      $O(1)$      |   Tie   |
| **pop()**                           |      $O(1)$      |      $O(1)$      |   Tie   |
| **push(E)**                         |      $O(1)$      |      $O(1)$      |   Tie   |
| **remove(int)**                     |      $O(n)$      |      $O(n)$      |   Tie   |
| **remove(Object)**                  |      $O(n)$      |      $O(n)$      |   Tie   |
| **removeAll(Collection)**           |    $O(n + m)$    |     $O(n+m)$     |   Tie   |
| **retainAll(Collection)**           |    $O(n + m)$    |     $O(n+m)$     |   Tie   |
| **search(Object)**                  |      $O(n)$      |      $O(n)$      |   Tie   |
| **set(int, E)**                     |      $O(1)$      |      $O(1)$      |   Tie   |
| **size()**                          |      $O(1)$      |      $O(1)$      |   Tie   |
| **sort(Comparator)**                |  $O(n \log n)$   |  $O(n \log n)$   |   Tie   |
| **spliterator()**                   |      $O(1)$      |      $O(1)$      |   Tie   |
| **subList(int, int)**               |      $O(1)$      |      $O(1)$      |   Tie   |
| **toArray()**                       |      $O(n)$      |      $O(n)$      |   Tie   |
| **toArray(T[])**                    |      $O(n)$      |      $O(n)$      |   Tie   |
| **toString()**                      |      $O(n)$      |      $O(n)$      |   Tie   |
| **trimToSize()**                    |      $O(n)$      |      $O(n)$      |   Tie   |
 
### Space Complexity

| Method                              |      Custom      |       JDK        | Winner  |
|:------------------------------------|:----------------:|:----------------:|:-------:|
| **CustomStack()**                   |      $O(1)$      |      $O(1)$      |   Tie   |
| **CustomStack(int)**                |      $O(c)$      |      $O(c)$      |   Tie   |
| **CustomStack(Collection)**         |      $O(m)$      |      $O(m)$      |   Tie   |
| **add(E)**                          | $O(1)$ amortized | $O(1)$ amortized |   Tie   |
| **add(int, E)**                     | $O(1)$ amortized | $O(1)$ amortized |   Tie   |
| **addAll(Collection)**              |      $O(m)$      |      $O(m)$      |   Tie   |
| **addAll(int, Collection)**         |      $O(m)$      |      $O(m)$      |   Tie   |
| **capacity()**                      |      $O(1)$      |      $O(1)$      |   Tie   |
| **clear()**                         |      $O(1)$      |      $O(1)$      |   Tie   |
| **clone()**                         |      $O(n)$      |      $O(n)$      |   Tie   |
| **contains(Object)** (inherited)    |      $O(1)$      |      $O(1)$      |   Tie   |
| **containsAll(Collection)**         |      $O(m)$      |      $O(m)$      |   Tie   |
| **empty()**                         |      $O(1)$      |      $O(1)$      |   Tie   |
| **ensureCapacity(int)**             |      $O(c)$      |      $O(c)$      |   Tie   |
| **get(int)**                        |      $O(1)$      |      $O(1)$      |   Tie   |
| **indexOf(Object)**                 |      $O(1)$      |      $O(1)$      |   Tie   |
| **indexOf(Object, int)**            |      $O(1)$      |      $O(1)$      |   Tie   |
| **iterator()**                      |      $O(n)$      |      $O(1)$      | **JDK** |
| **lastIndexOf(Object)** (inherited) |      $O(1)$      |      $O(1)$      |   Tie   |
| **lastIndexOf(Object, int)**        |      $O(1)$      |      $O(1)$      |   Tie   |
| **listIterator()**                  |      $O(n)$      |      $O(1)$      | **JDK** |
| **listIterator(int)**               |      $O(n)$      |      $O(1)$      | **JDK** |
| **peek()**                          |      $O(1)$      |      $O(1)$      |   Tie   |
| **pop()**                           |      $O(1)$      |      $O(1)$      |   Tie   |
| **push(E)**                         | $O(1)$ amortized | $O(1)$ amortized |   Tie   |
| **remove(int)**                     |      $O(1)$      |      $O(1)$      |   Tie   |
| **remove(Object)**                  |      $O(1)$      |      $O(1)$      |   Tie   |
| **removeAll(Collection)**           |      $O(m)$      |      $O(m)$      |   Tie   |
| **retainAll(Collection)**           |      $O(m)$      |      $O(m)$      |   Tie   |
| **search(Object)**                  |      $O(1)$      |      $O(1)$      |   Tie   |
| **set(int, E)**                     |      $O(1)$      |      $O(1)$      |   Tie   |
| **size()**                          |      $O(1)$      |      $O(1)$      |   Tie   |
| **sort(Comparator)**                |      $O(1)$      |      $O(1)$      |   Tie   |
| **spliterator()**                   |      $O(1)$      |      $O(1)$      |   Tie   |
| **subList(int, int)**               |      $O(1)$      |      $O(1)$      |   Tie   |
| **toArray()**                       |      $O(n)$      |      $O(n)$      |   Tie   |
| **toArray(T[])**                    |      $O(n)$      |      $O(n)$      |   Tie   |
| **toString()**                      |      $O(n)$      |      $O(n)$      |   Tie   |
| **trimToSize()**                    |      $O(n)$      |      $O(n)$      |   Tie   |

# Performance Comparison

Geometric mean (ns/op) across all tested collection sizes. Margins under 1.10x are treated as noise-level ties since the source data has no per-run error/variance to test true statistical significance.

| Method                     | Custom (ns) | JDK (ns)    | Margin |            Winner            |
|:---------------------------|:------------|:------------|:------:|:----------------------------:|
| `Constructor()`            | 51.4        | 51.8        | 1.01x  | **Statistically Equivalent** |
| `add(E)`                   | 103,702.8   | 106,842.3   | 1.03x  | **Statistically Equivalent** |
| `add(int, E)`              | 2,114.2     | 2,083.0     | 1.01x  | **Statistically Equivalent** |
| `addAll(Collection)`       | 93,262.4    | 35,942.3    | 2.59x  |           **JDK**            |
| `addAll(int, Collection)`  | 4,195.7     | 4,395.6     | 1.05x  | **Statistically Equivalent** |
| `capacity()`               | 44.1        | 43.6        | 1.01x  | **Statistically Equivalent** |
| `clear()`                  | 23,269.0    | 16,108.1    | 1.44x  |           **JDK**            |
| `clone()`                  | 9,991.0     | 8,019.6     | 1.25x  |           **JDK**            |
| `contains(Object)`         | 17,321.9    | 13,549.8    | 1.28x  |           **JDK**            |
| `containsAll(Collection)`  | 54,652.0    | 511,654.0   | 9.36x  |          **Custom**          |
| `empty()`                  | 46.1        | 45.5        | 1.01x  | **Statistically Equivalent** |
| `ensureCapacity(int)`      | 12,973.6    | 11,970.6    | 1.08x  | **Statistically Equivalent** |
| `equals(Object)`           | 70,903.4    | 207,281.7   | 2.92x  |          **Custom**          |
| `get(int)`                 | 53.1        | 52.6        | 1.01x  | **Statistically Equivalent** |
| `hashCode()`               | 48,863.2    | 165,859.5   | 3.39x  |          **Custom**          |
| `indexOf(Object)`          | 50,628.1    | 23,320.2    | 2.17x  |           **JDK**            |
| `indexOf(Object, int)`     | 53,731.8    | 23,733.3    | 2.26x  |           **JDK**            |
| `isEmpty()`                | 43.9        | 42.0        | 1.04x  | **Statistically Equivalent** |
| `iterator()`               | 26,298.1    | 79,568.6    | 3.03x  |          **Custom**          |
| `lastIndexOf(Object, int)` | 43,168.6    | 21,591.2    | 2.00x  |           **JDK**            |
| `listIterator()`           | 27,214.0    | 81,923.5    | 3.01x  |          **Custom**          |
| `listIterator(int)`        | 17,080.8    | 45,013.4    | 2.64x  |          **Custom**          |
| `peek()`                   | 45.1        | 59.4        | 1.32x  |          **Custom**          |
| `pop()`                    | 49.0        | 71.0        | 1.45x  |          **Custom**          |
| `push(E)`                  | 104,932.8   | 107,187.9   | 1.02x  | **Statistically Equivalent** |
| `remove(Object)`           | 55,340.9    | 26,407.7    | 2.10x  |           **JDK**            |
| `remove(int)`              | 2,152.2     | 2,124.9     | 1.01x  | **Statistically Equivalent** |
| `removeAll(Collection)`    | 256,335.2   | 6,922,795.4 | 27.01x |          **Custom**          |
| `retainAll(Collection)`    | 247,369.4   | 6,626,208.5 | 26.79x |          **Custom**          |
| `search(Object)`           | 9,960.3     | 10,009.9    | 1.00x  | **Statistically Equivalent** |
| `set(int, E)`              | 62.5        | 61.8        | 1.01x  | **Statistically Equivalent** |
| `size()`                   | 40.8        | 41.6        | 1.02x  | **Statistically Equivalent** |
| `sort(Comparator)`         | 57,768.4    | 57,240.2    | 1.01x  | **Statistically Equivalent** |
| `spliterator()`            | 66.8        | 62.2        | 1.07x  | **Statistically Equivalent** |
| `subList(int, int)`        | 55.3        | 117.9       | 2.13x  |          **Custom**          |
| `toArray()`                | 7,207.3     | 6,613.6     | 1.09x  | **Statistically Equivalent** |
| `toArray(T[])`             | 25,815.8    | 25,838.8    | 1.00x  | **Statistically Equivalent** |
| `toString()`               | 841,783.9   | 758,560.7   | 1.11x  |           **JDK**            |
| `trimToSize()`             | 6,770.8     | 6,725.3     | 1.01x  | **Statistically Equivalent** |

# Performance Charts

#### Note: The following performance charts are designed to be viewed in dark mode.
![heatmap.png](PerformanceCharts/heatmap.png)
![plot_Constructor__.png](PerformanceCharts/plot_Constructor__.png)
![plot_add_E_.png](PerformanceCharts/plot_add_E_.png)
![plot_add_int__E__.png](PerformanceCharts/plot_add_int__E_.png)
![plot_addAll_Collection_.png](PerformanceCharts/plot_addAll_Collection_.png)
![plot_addAll_int__Collection_.png](PerformanceCharts/plot_addAll_int__Collection_.png)
![plot_capacity__.png](PerformanceCharts/plot_capacity__.png)
![plot_clear__.png](PerformanceCharts/plot_clear__.png)
![plot_clone__.png](PerformanceCharts/plot_clone__.png)
![plot_contains_Object_.png](PerformanceCharts/plot_contains_Object_.png)
![plot_containsAll_Collection_.png](PerformanceCharts/plot_containsAll_Collection_.png)
![plot_empty__.png](PerformanceCharts/plot_empty__.png)
![plot_ensureCapacity_int.png](PerformanceCharts/plot_ensureCapacity_int_.png)
![plot_equals_Object_.png](PerformanceCharts/plot_equals_Object_.png)
![plot_get_int_.png](PerformanceCharts/plot_get_int_.png)
![plot_hashCode_.png](PerformanceCharts/plot_hashCode__.png)
![plot_indexOf_Object_.png](PerformanceCharts/plot_indexOf_Object_.png)
![plot_indexOf_Object__int_.png](PerformanceCharts/plot_indexOf_Object__int_.png)
![plot_isEmpty__.png](PerformanceCharts/plot_isEmpty__.png)
![plot_iterator__.png](PerformanceCharts/plot_iterator__.png)
![plot_lastIndexOf_Object__int_.png](PerformanceCharts/plot_lastIndexOf_Object__int_.png)
![plot_listIterator__.png](PerformanceCharts/plot_listIterator__.png)
![plot_listIterator_int_.png](PerformanceCharts/plot_listIterator_int_.png)
![plot_peek__.png](PerformanceCharts/plot_peek__.png)
![plot_pop__.png](PerformanceCharts/plot_pop__.png)
![plot_push_E_.png](PerformanceCharts/plot_push_E_.png)
![plot_remove_int_.png](PerformanceCharts/plot_remove_int_.png)
![plot_remove_Object_.png](PerformanceCharts/plot_remove_Object_.png)
![plot_removeAll_Collection_.png](PerformanceCharts/plot_removeAll_Collection_.png)
![plot_retainAll_Collection_.png](PerformanceCharts/plot_retainAll_Collection_.png)
![plot_search_Object_.png](PerformanceCharts/plot_search_Object_.png)
![plot_set_int__E_.png](PerformanceCharts/plot_set_int__E_.png)
![plot_size__.png](PerformanceCharts/plot_size__.png)
![plot_sort_Comparator_.png](PerformanceCharts/plot_sort_Comparator_.png)
![plot_spliterator__.png](PerformanceCharts/plot_spliterator__.png)
![plot_subList_int__int_.png](PerformanceCharts/plot_subList_int__int_.png)
![plot_toArray__.png](PerformanceCharts/plot_toArray__.png)
![plot_toArray_T__.png](PerformanceCharts/plot_toArray_T___.png)
![plot_toString__.png](PerformanceCharts/plot_toString__.png)
![plot_trimToSize__.png](PerformanceCharts/plot_trimToSize__.png)