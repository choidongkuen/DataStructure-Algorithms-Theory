>  이번에는 조금 어렵지만 꼭 알아야 하는 정렬 방식 3가지를 알아보자.🤓
### 1. 병합정렬(Merge Sort)
```
- 병합 정렬이란?

이제부터는 앞에서 학습한 정렬의 O(N^2) 의 시간복잡도에서 벗어나, 더 빠른 시간복잡도를 보여주는 정렬 알고리즘에 대해 알아보겠다.
정렬된 두 배열이 있다고 가정하자. 이런 경우, 두 배열을 합쳐 하나의 배열로 만드는 방법은 무엇이 있을까?
두개의 배열의 처음부터 시작하여, 두개의 값 중 더 작은 값을 배열에 넣고, 다시 남은 값을 비교하는 방식으로 채워나가는 것이다.
두 배열의 원소를 합치면 N개라고 가정한다면, 각 원소는 단 한번만 이동을 하게 되므로 시간복잡도는 O(N)이 될 것이다. 이 아이디어를 활용한 정렬 방법이 바로  병합 정렬이다.
그러나 우리가 정렬해야 하는 배열은 1개이다. 따라서 배열을 2개로 만들기 위해, 배열을 2개로 나누어주자. 거기에 두개의 배열이 모두 정렬이 되어야 합치는게 의미가 있기 때문에,
결국 배열을 두개로 나눈다면 자연스럽게 두 배열을 각각 정렬을 해야 한다. 결국 길이 N짜리 배열을 정렬하기 위해선 N/2 길이의 배열 두개를 정렬해야 한다.
자연스럽게 재귀적인 사고를 활용하여 두 배열에 대해 동일한 정렬 방식을 시도할 수 있을 것이다. 이렇게 된다면 배열의 길이는 N/2,N/4,N/8... 로 줄어들게 될 것이다.
이렇게 배열의 길이를 줄여나가게 되면 언젠간 1개가 될텐데, 1개는 앞에서 설명했듯이 이미 정렬된 배열이라고 할 수 있을 것이다.

<정리>
위 내용들을 종합하면, 결국 병합 정렬은 배열의 길이가 1개가 될 때 까지 재귀적으로 쪼개기 → 쪼갠 배열을 합쳐가며 정렬된 배열로 만들기 라는 과정을 거치게 된다. 
이렇게 동일한 문제로 쪼갠 뒤, 다시 합쳐주는 방식을 [분할 정복(Divide and Conquer)] 이라 부른다.
```

> Divide and Conquer 방식

<img src = "https://t1.daumcdn.net/cfile/tistory/99345B465BB08F6835">

```
- 병합 정렬의 시간복잡도 🕙

배열을 합치는 과정의 시간복잡도가 O(N)이라는 것을 알고 있자.
결국, 몇단계로 쪼개는지 알면 시간복잡도를 유추할 수 있지 않겠는가? 초기 배열의 길이가 N이라면, 
우리는 계속 2로 나눠서 각 요소의 길이가 1로 만들어줘야 한다.
그러기 위해선 2로 나누는 과정을 총 log N번 반복해야 한다는 것을 알 수 있다.
따라서 O(NlogN)이라는 시간복잡도가 나온다는 것을 알 수 있다.
```

> merge_sort 메서드 수도 코드 부분 (divide)

```
function merge_sort(arr[], low, high)
  if low < high                  // 원소의 개수가 2개 이상인 경우에만 진행
    set mid = (low + high) / 2   // 가운데 원소의 위치
    merge_sort(arr, low, mid)    // 왼쪽 부분에 대해 병합정렬 진행
    merge_sort(arr, mid+1, high) // 우측 부분에 대해 병합정렬 진행
    merge(arr, low, mid, high)   // 정렬된 두 리스트를 하나로 병합

set merged_arr = [] // 병합 이후의 결과를 담아준다.
```

> merge 메서드 수도 코드 부분 (conquer)
```
function merge(arr[], low, mid, high)
  set i = low, j = mid + 1      // 각 리스트 내의 원소 위치를 잡는다.

  set k = low                   // 병합 시 원소를 담을 위치를 유지한다.
  while i <= mid && j <= high   // 두 리스트 내의 원소가 아직 남아있다면
    if arr[i] <= arr[j]          // 첫 번째 리스트 내의 원소가 더 작다면
      merged_arr[k] = arr[i]    // 해당 원소를 옮겨준다.
      k += 1; i += 1
    else
      merged_arr[k] = arr[j]    // 그렇지 않다면 두 번째 리스트 내의
      k += 1; j += 1            // 원소를 옮겨준다.
  
  while i <= mid                // 아직 첫 번째 리스트 내 원소가 남아있다면
    merged_arr[k] = arr[i]      // 남은 원소들을 전부 옮겨준다.
    k += 1; i += 1

  while j <= high               // 아직 두 번째 리스트 내 원소가 남아있다면
    merged_arr[k] = arr[j]      // 남은 원소들을 전부 옮겨준다.
    k += 1; j += 1
  
  for k = low ... k <= high     // 병합된 리스트를 다시
    arr[k] = merged_arr[k]      // 원본 리스트에 옮겨준다.
  
  return arr 

```
### 2. 퀵 정렬(Quick sort)

```
- 퀵 정렬이란?

퀵 정렬은 합병정렬과 비슷하게 분할정복(Divide and Conquer) 알고리즘이다. 평균적으로 매우 빠른 수행 속도를 자랑하는 정렬 방법으로 다음과 같은 과정을 거친다.
1. 리스트 안에 있는 한 요소를 선택한다. 이렇게 고른 원소를 pivot(피벗) 이라고 한다.
2. pivot을 기준으로 pivot보다 작은 요소들은 모두 pivot의 왼쪽으로 옮기고 pivot보다 큰 요소들은 모두 pivot의 오른쪽으로 옮긴다.
3. pivot을 제외한 왼쪽 리스트와 오른쪽 리스트를 다시 정렬한다.
    3-1) 분할된 왼쪽 리스트와 오른쪽 리스트도 다시 pivot을 정하고 pivot을 기준으로 2개의 부분리스트로 나눈다.
    3-2) 재귀를 사용하여 부분 리스트들이 더이상 분할이 불가능 할 때까지 반복한다.

```

<img src = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT0xf2RqdgVkiGCZQUmwVLYnnd-ZBd5QoLTgg&usqp=CAU" width = "300" height = "300">

```
- 퀵 정렬의 시간복잡도 🕙

병합 정렬은 정확히 logN회 분할이 되지만, 퀵 정렬은 이와는 다르게 평균적으로 logN회 분할을 수행하게 된다.
평균적이라는 말은, 퀵 정렬은 최악에 N번 분할을 하게 되기 때문에 최악의 시간복잡도는 O(N^2)이 된다는 뜻이다.
다만 이러한 최악의 경우가 나오지 않게 만들 수 있는 여러 방법이 있고, 심지어 이름에서 느껴지듯이 일반적인 상황에서 퀵 정렬은 다른 정렬들 보다 월등히 빠르다.
즉, 퀵 정렬은 평균적으로 O(NlogN)이라는 시간복잡도를 갖게 된다.

그런데 유의해야 할 점이라면, 퀵 정렬의 성능은 기준점을 무엇으로 잡느냐에 따라 결정된다.
우리는 이 기준점을 피벗 (Pivot)이라고 부르는데, 피벗을 잘못 고르게 된다면 성능이 많이 떨어지게 된다.
일반적으로 간단하게 구현하기 위해선 맨 왼쪽 값이나 가운데 값을 피벗으로 사용하지만, 그런 경우 위와 같은 불상사가 발생할 수 있으므로 다양한 피벗 탐지 방법이 연구되었다.
그 중 가장 많이 사용 되는 방식이 맨 왼쪽, 맨 오른쪽, 가운데 값중 중앙값을 선택하는 것이다.
위에서 배운 정렬 알고리즘 중 일반적으로 가장 빠른 알고리즘이나, 설명했던 피벗 선택 문제에 빠지지 않도록 유의해야 한다.

- 대표적인 pivot 선정 방법!!

데이터가 3개 이하면 피벗은 반드시 마지막 값이 됨
데이터가 4개 이상이면 맨 왼쪽, 오른쪽, 가운데 (나머지 버림) 값 중 중간 값을 선택함
피벗이 선택되면 먼저 구간의 맨 끝 원소와 꼭 교환해야함

```
> quick_sort() 메서드 수도 코드 부분

```
function quick_sort(arr[], low, high)
if low < high
pos = partition(arr, low, high)
quick_sort(arr, low, pos - 1)
quick_sort(arr, pos + 1, high)
```

> partition() 메서드 수도 코드 부분 => 각 단계마다 pivot 구하는 메서드


```
function partition(arr[], low, high)
  set pivot = select_pivot(arr, low, high)
  set i = low - 1
  
  for j = low ... j <= high - 1
    if arr[j] < pivot
      i += 1
      swap (arr[i], arr[j])
      
  swap (arr[i + 1], arr[high])
  return i + 1
```

### 힙 정렬(Heap sort)

```
- 힙 정렬이란?

힙 정렬을 이해하기 위해서는 '이진트리' 라는 자료구조와 이를 이용해서 만들어지는 '힙 구조' 에 대해 이해하고 있어야 한다.
따라서 만약 둘에 대해 아직 학습되지 않았다면, 먼저 Tree 파트 부분에서 보고 오길 바란다.


간단히, heap에는 대표적으로 maxheap, miniheap 이 있으며, 여기서는 maxheap을 이용해서 정렬을 하고자 한다.
우리는 기존에 배웠던 선택 정렬을 거꾸로 진행하는 것을 생각해볼 것이다. 나는 선택정렬을 최소값을 선택하여, 앞에서부터 정렬해가는 것을 구현했지만
반대로 최대값을 선택하여, 뒤에서부터 정렬하는 방법도 당연히 가능하다. 
이에 대해 짧게 얘기하자면, 처음에는 가장 큰 숫자를 골라 맨 오른쪽 원소와 교환한 뒤, 그 다음으로 큰 숫자를 골라 오른쪽에서 두 번째 원소와 교환하는 것을 반복하여 가장 작은 원소를 선택하게 되는 것으로 정렬을 진행해볼 수 있을 것이다.
위 방법에서 시간복잡도가 O(N^2)이 나오는 이유는 최댓값을 찾기 위해 N개의 원소를 전부 순회해야 하므로 걸리는 시간이 O(N)이 되기 때문이다.
만약 주어진 원소들 중 최댓값을 찾는 것이 O(N)이 아닌, O(logN)일 수가 있다면, N개의 원소를 정렬하는 데 걸리는 시간이 O(NlogN)이 될 것이다.
heap이라는 자료구조를 이용하면, N개의 원소들 중 최댓값을 찾는 것을 O(logN)만에 할 수 있게 된다.
heap은 이진 트리 형태를 띄고 있다. 트리라는 것은 쉽게 얘기해서 맨 위에는 큰 하나의 기둥이 있고, 아래로 내려갈수록 가지가 계속 뻗어나오는 구조를 띄고 있는 자료구조 입니다.
```

```
- 힙 정렬은 어떻게? 👨‍💻

1. 먼저 maxheap을 만들어주자.
    - n / 2번째 원소부터 거꾸로 1번째 원소까지 순서대로 보면서 heapify라는 과정을 거친다. heapify라는 것은,
        현재 노드를 기준으로 이 노드가 heap 특성에 맞을 때까지 계속 밑으로 내려주는 과정을 일컫는다.
        
        heapify는 다음 조건에 맞춰 진행된다.
        1. 현재 노드 위치를 i라고 한다면, 현재 노드, 왼쪽 자식(i * 2번째) 노드, 그리고 오른쪽 자식(i * 2 + 1번째) 노드 중 가장 큰 노드가 무엇인지 판단한다. 이 세 노드 중 가장 큰 노드를 편의상 largest 노드라고 하자.
        2. 만약 largest 노드가 현재 노드 i가 아닌 자식 노드라면, 현재 노드(i)와 해당 자식 노드(largest)의 값을 교환한다. 교환 이후에는 다시 largest 위치에서 heapify를 진행한다. 
           이렇듯 현재 노드가 heap 조건을 만족하도록 계속 내려주는 것을 재귀적으로 반복해준다.
        3. 만약 largest 노드가 현재 노드 i라면, 종료한다.     
```
> 초기 배열 상태

![](https://velog.velcdn.com/images/choidongkuen/post/a3caf8bc-73a9-44d7-8c7d-b536ba39c665/image.png)

> Maxheap을 만든 후 배열 상태

![](https://velog.velcdn.com/images/choidongkuen/post/5d4f5538-c00f-439f-8600-779036b38f36/image.png)

```
2. maxheap을 만들어 준 후, 첫번째 인텍스 원소와 정렬되지 않은 구간에 마지막 원소를 swap 해준다.
```

> swap 후 상태

![](https://velog.velcdn.com/images/choidongkuen/post/5ab50ca4-9e8f-491f-bf65-077adc43abd3/image.png)

```
3. swap 후 maxheap 구조가 깨짐으로, heapify(1) 진행
```

```
4. 3번 과정을 n-1번 진행하며, 할때마다 첫번째 인덱스 원소와 정렬되지 않은 마지막 원소를 swap 해준다.
   👨‍💻: 즉, heapify(1) 을 할때마다 정렬되지 않은 구간에서의 최대값이 인덱스 1번에 위치하게 된다.(재귀적)
```

> 2번째 swap 후 상태

![](https://velog.velcdn.com/images/choidongkuen/post/bf62888b-a5e3-4e6f-89ed-fe2355583a90/image.png)

```
- 힙 정렬의 시간복잡도 🕙

heap은 이진트리 중에서도 왼쪽으로 가득 채워져있는 완전 이진 트리 모양으로 되어있기 때문에 트리의 높이가 logN이 된다.
따라서 heapify 과정은 한 번 일어날 때 최대 logN번 일어나게 된다.
처음 max-heap을 만드는데 총 n / 2개의 원소에 대해 heapify과정을 거치게 되며 엄밀하게 계산했을 때 시간은 O(N)이 소요되지만, max-heap을 구성한 이후에는
계속 최댓값을 마지막 원소인 n번째 원소와 교환하며 다시 heapify를 진행하는 것을 n번 반복하고 이 과정은 각각 최대 O(logN)의 시간이 소요되기에 총 시간복잡도는 O(NlogN)이 된다.
따라서 heap sort의 경우 시간복잡도는 O(NlogN)이 된다.

```

> heapify() 메서드 수도 코드 부분

```
function heapify(arr[], n, i)
  set largest = i                     // 최대 노드가 i번이라고 가정합니다.
  set l = i * 2                       // 왼쪽 자식 노드 번호입니다.
  set r = i * 2 + 1                   // 오른쪽 자식 노드 번호입니다.

  if l < n && arr[l] > arr[largest]  // 왼쪽 자식이 크다면, 최대 번호를 수정합니다.
    largest = l

  if r < n && arr[r] > arr[largest] // 오른쪽 자식이 크다면, 최대 번호를 수정합니다.
    largest = r

  if largest != i                   // 최대 노드가 자식 노드라면
    swap(arr[i], arr[largest])      // 해당 자식과 현재 노드를 교환해준 뒤
    heapify(arr, n, largest)        // 내려간 위치에서 다시 heapify를 진행합니다.
```
> heapSort() 메서드 부분 수도 코드 부분
```
function heapify(arr[], n, i)
  set largest = i
  set l = i * 2
  set r = i * 2 + 1

  if l < n && arr[l] > arr[largest]
    largest = l

  if r < n && arr[r] > arr[largest]
    largest = r

  if largest != i
    swap(arr[i], arr[largest])
    heapify(arr, n, largest)

function heap_sort(arr[], n)
  for i = n / 2 ... i >= 1
    heapify(arr, n, i)

  for i = n ... i > 1
    swap(arr[1], arr[i])
    heapify(arr, i, 1)

```






