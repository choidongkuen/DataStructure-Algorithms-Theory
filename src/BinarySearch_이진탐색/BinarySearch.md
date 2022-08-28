## 이진 탐색(Binary Search)

```
- 이진 탐색이란?

앞에서 배운 선형 구조였던 배열이나, 연결리스트에서 탐색의 시간복잡도는 O(n)이다.
데이터값이 비약적으로 커지는 경우라면 이같은 경우는 매우 비효율적이다. 따라서 O(log n)의
시간복잡도를 가지는 이진 탐색을 알아보자.

이진 탐색(Binary Search)는 찾아야 하는 수의 범위 중 가운데의 값과
찾고자 하는 값을 비교하여 대소관계에 따라 특정 구간으로 이동하는 것을 반복하는 것이다.
우리가 재미로 하는 업/다운 게임에서 비춰보면, '다운'이라는 말을 들으면 우리는 그 값보다 더 작은 값을 선택해야 하고, '업'을 외쳤다면 더 큰 값을 선택해야 한다.
이진탐색에서도 저러한 과정을 수행하기 위해선, 당연하게도 대소관계에 따라 실제 찾는 값도 작거나 커져야 하기 때문에 배열에 들어있는 값은 반드시 정렬되어야 한다.
당연히 우리가 찾는 범위 속 원소의 갯수가 1개로 줄어들 때 까지 계속 탐색을 진행해야 하기 때문에 while문을 통해 조건을 걸고, 이후 중간에 위치한 값의 대소관계에 따라 left와 right의 값을 계속 바꿔가면서 진행한다. 
단, while 조건을 걸 때 left <= right 이렇게 등호를 꼭 넣어야 단 하나의 숫자만 남았을 경우에도 올바르게 찾게된다. 계속 탐색을 반복하며, 그 중 가운데 위치에 해당하는 값인 arr[mid]와 찾으려고 하는 숫자인 target이 일치하면, 
해당 위치인 mid를 반환해주게 된다. while문이 끝났는데도 불구하고 아직 return이 되지 않았다면, -1을 반환해 원하는 값이 없다는 표시를 해주게 된다.
또, mid = (left + right) / 2 에서 left + right 값이 홀수라면, mid는 2로 나눈 뒤 버림한 위치에 가게됨에 유의하자.
왜 left는 mid + 1이고, right는 mid - 1일까요? arr[mid]값이 target값이 아니었으니 mid는 target을 포함할 숫자 범위에서 명확히 제외된다.
따라서 mid 위치를 제외한 범위로 left, right를 움직여줘야 함에 유의하자.

밑에 과정을 통해 이진탐색을 이해해보자.
```

> Step 1

![](https://velog.velcdn.com/images/choidongkuen/post/b11f96a7-f356-415d-90f2-740d13dde5b2/image.png)


> Step 2.

![](https://velog.velcdn.com/images/choidongkuen/post/fd7239fb-cb16-4f93-a8b4-d9ac4ac3684b/image.png)


> Step 3.

![](https://velog.velcdn.com/images/choidongkuen/post/ef1798ba-1cfa-4c27-a524-f7b651ff3b63/image.png)


> Step 4.

![](https://velog.velcdn.com/images/choidongkuen/post/d9561c1c-eb52-417f-b9b7-096296ffbcbb/image.png)


> Step 5.

![](https://velog.velcdn.com/images/choidongkuen/post/060b71ae-be6e-478e-b751-91d261d2ede5/image.png)

```
- 이진 탐색의 수도 코드 🔥

function solution(arr, target)
  set left = 0
  set right = arr.size - 1
  while left <= right
    set mid = (left + right) / 2
    if arr[mid] == target
      return mid

    if arr[mid] > target
      right = mid - 1
    else
      left = mid + 1
      
  return -1
```

```
- 순차 탐색과 이진 탐색

순차 탐색이란, 주어진 배열에서의 목표값을 찾기 위해 0번 인덱스 부터 순차적으로 탐색하는 기법으로, 우리가 앞에서
접했던 방법이다. 매우 단순한 방법으로 최악의 경우 기준 O(n)의 시간복잡도를 지닌다.
그러나 배열의 정렬 여부가 탐색과정에 관련이 없다. 따라서 따로 정렬 과정을 거쳐줄 필요가 겂다.

이진 탐색은 일반적으로 순차탐색보다 더 빠르다. 루프를 한 번 돌때 마다, 우리가 다루는 구간의 길이는 반으로 감소하고, 
구간의 길이가 1이 될 때 까지 계속 반복해서 탐색하는 것을 볼 수 있다. 즉, 루프는 약 log N 번 돌게 된다. 루프 내부 연산의 시간 복잡도는 O(1)이기 때문에, 
자연스럽게 시간복잡도는 O(1∗logN) = O(logN)이 되는 것을 볼 수 있다.

log N 과 N 의 차이가 크게 느껴지지 않을 수 있다. 그러나, 잘 생각해보면 일반적으로 사용자가 컴퓨팅 하는 데이터는 굉장히 방대한 크기의 데이터이다.
따라서 시간복잡도의 조그마한 차이가 큰 결과의 차이를 불러일으킬 수 있다. 이것이 바로 알고리즘에 힘이다.
```

> 순차 탐색 VS 이진 탐색

![](https://velog.velcdn.com/images/choidongkuen/post/815de5b5-a9c1-495a-8b23-5975ba2e786a/image.png)

```
- 항상 이진 탐색이 순차 탐색보다 더 빠를까?

모든 상황에서 이진탐색이 유리한 것은 아니다. 이진탐색이 갖고 있는 단점이라면 반드시 정렬이 되어야 한다는 것이다.
따라서 배열이 정렬된 상태가 아니라면, 정렬을 하기 위해 추가적인 연산을 필요로 한다.
정렬을 추가로 진행한다면, 일반적으로 빠른속도를 자랑하는 퀵 정렬 같은 알고리즘을 활용했을 때 O(NlogN)이 추가적으로 사용 되기 때문에 오히려 순차탐색에 비해 느려진다!!
따라서 정렬된 경우엔 반드시 이진탐색을 사용하는 것이 효율적이겠지만, 그렇지 않은 경우라면 이진탐색을 사용하기 전에 한번 더 생각해보아야 한다.
만약 탐색을 여러 번 진행해야 한다면 이진탐색을 사용하는 것이 좋겠지만, 가장 큰 값을 찾는다거나, 값을 단지 몇번만 찾는다면 굳이 이진탐색을 사용할 이유가 없을 것이다.

```

## Lower Bound/Upper Bound

```
- lower bound와 upper bound 란?

앞에서 배웠다 싶이, 이진탐색은 정렬되어 있는 배열에서 효율적으로 원하는 값을 찾는 탐색 알고리즘이였다.
그러나 만약 배열안에 찾고 싶어 하는 값이 복수개 있으면 어떨까? 원하는 인덱스(위치)를 얻을 수 없을 것이다.
따라서 이경우 사용하는 것이 lower bound와 upper bound 이다.
```

>lower bound
```
lower Bound는 원하는 값 target 이상의 값이 최초로 나오는 위치를 의미한다. 이는 바꿔말해 target보다 같거나 큰 원소의 위치들 중 가장 작은 값을 출력해야 한다는 것이다.


- lower bound의 수도 코드 🔥

function lower_bound(arr, target)
  set left = 0                         // 첫 번째 원소의 위치로 설정합니다.
  set right = arr.size - 1             // 마지막 원소의 위치로 설정합니다.
  set min_idx = arr.size               // 최소이므로, 답이 될 수 있는 값보다 더 큰 값으로 설정합니다.
  while left <= right                  // [left, right]가 유효한 구간이면 계속 수행합니다.
    set mid = (left + right) / 2       // 가운데 위치를 선택합니다.
    if arr[mid] >= target              // 만약에 선택한 원소가 target보다 같거나 크다면 
      right = mid - 1                  // 왼쪽에 조건을 만족하는 숫자가 더 있을 가능성 때문에 right를 바꿔줍니다.
      min_idx = min(min_idx, mid)      // 같거나 큰 값들의 위치 중 최솟값을 계속 갱신해줍니다.
    else
      left = mid + 1                   // 작은 경우라면 left를 바꿔줍니다.

  return min_idx                       // 조건을 만족하는 최소 index 값을 반환합니다.
```

> upper bound
```
upper bound는 원하는 값 target을 초과하는 값이 최초로 나오는 위치를 의미한다.


- upper bound의 수도 코드 🔥

function upper_bound(arr, target)
  set left = 0                         // 첫 번째 원소의 위치로 설정합니다.
  set right = arr.size - 1             // 마지막 원소의 위치로 설정합니다.
  set min_idx = arr.size               // 최소이므로, 답이 될 수 있는 값보다 더 큰 값으로 설정합니다.
  while left <= right                  // [left, right]가 유효한 구간이면 계속 수행합니다.
    set mid = (left + right) / 2       // 가운데 위치를 선택합니다.
    if arr[mid] > target               // 만약에 선택한 원소가 target보다 크다면 
      right = mid - 1                  // 왼쪽에 조건을 만족하는 숫자가 더 있을 가능성 때문에 right를 바꿔줍니다.
      min_idx = min(min_idx, mid)      // 큰 값들의 위치 중 최솟값을 계속 갱신해줍니다.
    else
      left = mid + 1                   // 같거나 작은 경우라면 left를 바꿔줍니다.

  return min_idx                       // 조건을 만족하는 최소 index 값을 반환합니다.
```

> 사용법

```
잘 생각해보면 lower bound와 upper bound를 통해 많은 것을 알아낼 수 있다.

    1. upper bound - lower bound는 target과 동일한 원소의 개수이다.
    2. 만약 둘의 차가 0이라는 것은 찾으려고 하는 target이 존재하지 않는다는 뜻이다.
   
이렇듯 탐색에는 여러가지 방법이 존재하지만 대표적인 방법을 알아보았다.
이진탐색은 중요한 알고리즘 기법이므로, 꼭 다시한번 생각해보고 정리하자! 🥸
```