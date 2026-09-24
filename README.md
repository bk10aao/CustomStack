# Custom Stack

Implementation of a Java Stack backed by an array.

### Time Complexity

| Method                       |      Custom      |       JDK        | Winner  |
|:-----------------------------|:----------------:|:----------------:|:-------:|
| **CustomStack()**            |      $O(1)$      |      $O(1)$      |   Tie   |
| **CustomStack(int)**         |      $O(1)$      |      $O(1)$      |   Tie   |
| **CustomStack(Collection)**  |      $O(m)$      |      $O(m)$      |   Tie   |
| **add(E)**                   | $O(1)$ amortized | $O(1)$ amortized |   Tie   |
| **add(int, E)**              |      $O(n)$      |      $O(n)$      |   Tie   |
| **addAll(Collection)**       |      $O(m)$      |      $O(m)$      |   Tie   |
| **addAll(int, Collection)**  |    $O(n + m)$    |    $O(n + m)$    |   Tie   |
| **capacity()**               |      $O(1)$      |      $O(1)$      |   Tie   |
| **clear()**                  |      $O(n)$      |      $O(n)$      |   Tie   |
| **clone()**                  |      $O(n)$      |      $O(n)$      |   Tie   |
| **contains(Object)**         |      $O(n)$      |      $O(n)$      |   Tie   |
| **containsAll(Collection)**  |    $O(n + m)$    |    $O(n + m)$    |   Tie   |
| **empty()**                  |      $O(1)$      |      $O(1)$      |   Tie   |
| **ensureCapacity(int)**      |      $O(n)$      |      $O(n)$      |   Tie   |
| **get(int)**                 |      $O(1)$      |      $O(1)$      |   Tie   |
| **indexOf(Object)**          |      $O(n)$      |      $O(n)$      |   Tie   |
| **indexOf(Object, int)**     |      $O(n)$      |      $O(n)$      |   Tie   |
| **iterator()**               |      $O(n)$      |      $O(1)$      | **JDK** |
| **lastIndexOf(Object)**      |      $O(n)$      |      $O(n)$      |   Tie   |
| **lastIndexOf(Object, int)** |      $O(n)$      |      $O(n)$      |   Tie   |
| **listIterator()**           |      $O(n)$      |      $O(1)$      | **JDK** |
| **listIterator(int)**        |      $O(n)$      |      $O(1)$      | **JDK** |
| **peek()**                   |      $O(1)$      |      $O(1)$      |   Tie   |
| **pop()**                    |      $O(1)$      |      $O(1)$      |   Tie   |
| **push(E)**                  |      $O(1)$      |      $O(1)$      |   Tie   |
| **remove(int)**              |      $O(n)$      |      $O(n)$      |   Tie   |
| **remove(Object)**           |      $O(n)$      |      $O(n)$      |   Tie   |
| **removeAll(Collection)**    |    $O(n + m)$    |     $O(n+m)$     |   Tie   |
| **retainAll(Collection)**    |    $O(n + m)$    |     $O(n+m)$     |   Tie   |
| **search(Object)**           |      $O(n)$      |      $O(n)$      |   Tie   |
| **set(int, E)**              |      $O(1)$      |      $O(1)$      |   Tie   |
| **size()**                   |      $O(1)$      |      $O(1)$      |   Tie   |
| **sort(Comparator)**         |  $O(n \log n)$   |  $O(n \log n)$   |   Tie   |
| **spliterator()**            |      $O(1)$      |      $O(1)$      |   Tie   |
| **subList(int, int)**        |      $O(1)$      |      $O(1)$      |   Tie   |
| **toArray()**                |      $O(n)$      |      $O(n)$      |   Tie   |
| **toArray(T[])**             |      $O(n)$      |      $O(n)$      |   Tie   |
| **toString()**               |      $O(n)$      |      $O(n)$      |   Tie   |
| **trimToSize()**             |      $O(n)$      |      $O(n)$      |   Tie   |
 
### Space Complexity

| Method                       |      Custom      |       JDK        | Winner  |
|:-----------------------------|:----------------:|:----------------:|:-------:|
| **CustomStack()**            |      $O(1)$      |      $O(1)$      |   Tie   |
| **CustomStack(int)**         |      $O(c)$      |      $O(c)$      |   Tie   |
| **CustomStack(Collection)**  |      $O(m)$      |      $O(m)$      |   Tie   |
| **add(E)**                   | $O(1)$ amortized | $O(1)$ amortized |   Tie   |
| **add(int, E)**              | $O(1)$ amortized | $O(1)$ amortized |   Tie   |
| **addAll(Collection)**       |      $O(m)$      |      $O(m)$      |   Tie   |
| **addAll(int, Collection)**  |      $O(m)$      |      $O(m)$      |   Tie   |
| **capacity()**               |      $O(1)$      |      $O(1)$      |   Tie   |
| **clear()**                  |      $O(1)$      |      $O(1)$      |   Tie   |
| **clone()**                  |      $O(n)$      |      $O(n)$      |   Tie   |
| **contains(Object)**         |      $O(1)$      |      $O(1)$      |   Tie   |
| **containsAll(Collection)**  |      $O(m)$      |      $O(m)$      |   Tie   |
| **empty()**                  |      $O(1)$      |      $O(1)$      |   Tie   |
| **ensureCapacity(int)**      |      $O(c)$      |      $O(c)$      |   Tie   |
| **get(int)**                 |      $O(1)$      |      $O(1)$      |   Tie   |
| **indexOf(Object)**          |      $O(1)$      |      $O(1)$      |   Tie   |
| **indexOf(Object, int)**     |      $O(1)$      |      $O(1)$      |   Tie   |
| **iterator()**               |      $O(n)$      |      $O(1)$      | **JDK** |
| **lastIndexOf(Object)**      |      $O(1)$      |      $O(1)$      |   Tie   |
| **lastIndexOf(Object, int)** |      $O(1)$      |      $O(1)$      |   Tie   |
| **listIterator()**           |      $O(n)$      |      $O(1)$      | **JDK** |
| **listIterator(int)**        |      $O(n)$      |      $O(1)$      | **JDK** |
| **peek()**                   |      $O(1)$      |      $O(1)$      |   Tie   |
| **pop()**                    |      $O(1)$      |      $O(1)$      |   Tie   |
| **push(E)**                  | $O(1)$ amortized | $O(1)$ amortized |   Tie   |
| **remove(int)**              |      $O(1)$      |      $O(1)$      |   Tie   |
| **remove(Object)**           |      $O(1)$      |      $O(1)$      |   Tie   |
| **removeAll(Collection)**    |      $O(m)$      |      $O(m)$      |   Tie   |
| **retainAll(Collection)**    |      $O(m)$      |      $O(m)$      |   Tie   |
| **search(Object)**           |      $O(1)$      |      $O(1)$      |   Tie   |
| **set(int, E)**              |      $O(1)$      |      $O(1)$      |   Tie   |
| **size()**                   |      $O(1)$      |      $O(1)$      |   Tie   |
| **sort(Comparator)**         |      $O(1)$      |      $O(1)$      |   Tie   |
| **spliterator()**            |      $O(1)$      |      $O(1)$      |   Tie   |
| **subList(int, int)**        |      $O(1)$      |      $O(1)$      |   Tie   |
| **toArray()**                |      $O(n)$      |      $O(n)$      |   Tie   |
| **toArray(T[])**             |      $O(n)$      |      $O(n)$      |   Tie   |
| **toString()**               |      $O(n)$      |      $O(n)$      |   Tie   |
| **trimToSize()**             |      $O(n)$      |      $O(n)$      |   Tie   |

# Performance Comparison

Geometric means (ns/op) calculated across all tested collection sizes, averaged over 10 benchmark runs. Margins under
1.10x are treated as noise-level ties because the source data lacks per-run variance metrics.



# Performance Charts

Geometric means (ns/op) calculated across all tested collection sizes, averaged over 10 benchmark runs. Margins under 
1.10x are treated as noise-level ties because the source data lacks per-run variance metrics.

| Method                     | Custom (ns) | JDK (ns)  | Margin |            Winner            |
|:---------------------------|:------------|:----------|:------:|:----------------------------:|
| `Constructor()`            | 26.4        | 30.9      | 1.17x  |          **Custom**          |
| `add(E)`                   | 104,179.2   | 106,259.1 | 1.02x  | **Statistically Equivalent** |
| `add(int, E)`              | 2,079.2     | 2,074.9   | 1.00x  | **Statistically Equivalent** |
| `addAll(Collection)`       | 61,796.2    | 62,356.5  | 1.01x  | **Statistically Equivalent** |
| `addAll(int, Collection)`  | 3,741       | 3,831.9   | 1.02x  | **Statistically Equivalent** |
| `capacity()`               | 26.3        | 37.6      | 1.43x  |          **Custom**          |
| `clear()`                  | 12,089.5    | 13,201.5  | 1.09x  | **Statistically Equivalent** |
| `clone()`                  | 8,618.8     | 9,110     | 1.06x  | **Statistically Equivalent** |
| `contains(Object)`         | 16,110.1    | 17,024.4  | 1.06x  | **Statistically Equivalent** |
| `containsAll(Collection)`  | 52,469.9    | 53,761.1  | 1.02x  | **Statistically Equivalent** |
| `empty()`                  | 26.3        | 30.5      | 1.16x  |          **Custom**          |
| `ensureCapacity(int)`      | 13,238.7    | 13,538.4  | 1.02x  | **Statistically Equivalent** |
| `equals(Object)`           | 69,105.9    | 70,108.6  | 1.01x  | **Statistically Equivalent** |
| `get(int)`                 | 31.8        | 42.7      | 1.34x  |          **Custom**          |
| `hashCode()`               | 47,316.1    | 48,068.1  | 1.02x  | **Statistically Equivalent** |
| `indexOf(Object)`          | 50,364.1    | 50,992.5  | 1.01x  | **Statistically Equivalent** |
| `indexOf(Object, int)`     | 50,635.5    | 51,312.6  | 1.01x  | **Statistically Equivalent** |
| `isEmpty()`                | 26.3        | 30.7      | 1.16x  |          **Custom**          |
| `iterator()`               | 24,869.6    | 25,969.5  | 1.04x  | **Statistically Equivalent** |
| `lastIndexOf(Object, int)` | 47,218.7    | 47,926.1  | 1.01x  | **Statistically Equivalent** |
| `listIterator()`           | 26,183.6    | 27,443.8  | 1.05x  | **Statistically Equivalent** |
| `listIterator(int)`        | 16,133.1    | 16,492.5  | 1.02x  | **Statistically Equivalent** |
| `peek()`                   | 26.7        | 35.4      | 1.32x  |          **Custom**          |
| `pop()`                    | 26.8        | 35.1      | 1.31x  |          **Custom**          |
| `push(E)`                  | 105,257.4   | 106,703.3 | 1.01x  | **Statistically Equivalent** |
| `remove(Object)`           | 58,541.1    | 59,924.3  | 1.02x  | **Statistically Equivalent** |
| `remove(int)`              | 2,106.8     | 2,346.6   | 1.11x  |          **Custom**          |
| `removeAll(Collection)`    | 254,554.2   | 257,245.3 | 1.01x  | **Statistically Equivalent** |
| `retainAll(Collection)`    | 243,912.9   | 248,304.3 | 1.02x  | **Statistically Equivalent** |
| `search(Object)`           | 9,935.7     | 10,196    | 1.03x  | **Statistically Equivalent** |
| `set(int, E)`              | 34.2        | 48.8      | 1.43x  |          **Custom**          |
| `size()`                   | 26.5        | 32.5      | 1.22x  |          **Custom**          |
| `sort(Comparator)`         | 56,875.5    | 58,291.6  | 1.02x  | **Statistically Equivalent** |
| `spliterator()`            | 27.1        | 34.3      | 1.27x  |          **Custom**          |
| `subList(int, int)`        | 27.5        | 60.9      | 2.22x  |          **Custom**          |
| `toArray()`                | 5,911.7     | 5,845     | 1.01x  | **Statistically Equivalent** |
| `toArray(T[])`             | 24,512.8    | 24,687.9  | 1.01x  | **Statistically Equivalent** |
| `toString()`               | 866,374.5   | 851,541.5 | 1.02x  | **Statistically Equivalent** |
| `trimToSize()`             | 5,716.4     | 5,925.3   | 1.04x  | **Statistically Equivalent** |

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