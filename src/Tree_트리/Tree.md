# 트리(Tree) 📚

```
트리란? 🌴

밑에 보이는 사진은 어느 회성의 조직도이다. 이번에 살펴볼 트리는 이와 배우 비슷하며,
이런 구조를 일반적으로 트리 구조라고 한다. 나무 같지 않는가? 나무를 180도 돌려서 보면 맨 위에는 큰 하나의 기둥이 있고, 아래로 내려갈수록 가지가 계속 뻗어나오는 것을 볼 수 있다.
그렇기 때문에 우리는 이 구조를 트리 구조라고 부르는 것이다. 트리는 두 지점의 연결 관계로 구성되어 있는데, 계층관계가 존재한다는 것이 특징이 있다.
우리는 하나의 연결 관계에서 위쪽에 있는 점을 '부모' 라고 부르며, 아래쪽에 있는 점을 '자식' 이라고 부를 것 이다.
이 외에도 추가적인 용어들을 살펴보자.
```

![](https://velog.velcdn.com/images/choidongkuen/post/61028149-beaa-4ba5-81fd-de0251659f1f/image.png)


```
트리 용어 정리 ⭐️

노드: 각 지점을 의미한다. 정점이라 부르기도 한다.
간선: 두 노드를 연결하는 선을 의미합니다. 에지라고 부르기도 한다.
루트 노드: 트리에서 맨 꼭데기 노드를 의미한다.
부모, 자식: 트리에서 연결된 두 노드의 관계를 의미하는데, 더 위쪽에 있는 노드를 부모 노드, 아래쪽에 있는 노드를 자식 노드라고 부른다.
차수: 특정 노드를 기준으로, 자식의 수가 얼마나 되는지 의미한다.
깊이: 루트 노드와 얼마나 떨어져 있는지를 가리키는 말이다.
높이: 트리에서 깊이가 가장 깊은 노드의 깊이 혹은 1을 더한 값을 의미합니다. 코드트리에서는 앞으로 트리의 높이를 최대 깊이에 1을 더한 값으로 생각하도록 하자.
리프 노드: 자식을 갖고 있지 않은 노드를 의미한다.
```
![](https://velog.velcdn.com/images/choidongkuen/post/806dac27-73a5-42d4-a95d-dc8a2a85b6fb/image.png)

> Rooted Tree 와 Unrooted Tree의 차이

```
놀랍게도 밑에 있는 이미지와 같이 '부모 자식 관계'가 정의되지 않는 경우에도 트리라고 부릅니다. 
즉, 트리의 원래 정의는 노드끼리 전부 연결되어 있으면서 사이클이 존재하지 않는 그래프이다. 이런 경우를 'Unrooted tree'라고 부른다.
위에서 살펴본 이미지 경우에서 처럼 루트 노드가 설정되어있는 트리는 'Rooted tree'라고 부릅니다. 참고로 Unrooted tree에서의 차수는 노드에 연결된 간선의 개수이고, 
리프 노드의 정의는 차수가 1인 노드가 된다. Unrooted tree 에서 루트 노드는 사용자가 정의하기 나름이다.
```

![](https://velog.velcdn.com/images/choidongkuen/post/e7840a77-45c7-48d2-ab67-985c0df73acc/image.png)

>여기서 잠깐! 트리에 대한 개념 문제 😎
> - 트리의 루트는 2개 이상이 될 수 없다?     
> - 트리의 루트는 특별히 정해진 것이 아니며, 상황에 따라 달라질 수 있다?
> - 한 도드가 가질 수 있는 자식의 수는 제한이 없으나, 부모 노드는 최대 1개만 존재한다?
> - 리프 노드는 자식이 절대로 있을 수 없다?
> 
> - 노드가 하나만 있다면 그건 트리라고 부를 수 없다?
> 
> Ans : true,true,true,true,false



## 이진 트리(Binary tree) 🌴

```
이진 트리란?

트리 구조중 자식의 수가 최대 2개인 트리의 한 종류이다.
이진트리의 자식은 두개이기 때문에, 하나는 왼쪽에, 그리고 다른 하나는 오른쪽에 존재한다고 볼 수 있을 있다. 우리는 왼쪽/오른쪽 자식이라고 구분하도록 하겠다.
배열의 0번 값을 비우고, 루트 노드를 1번에 넣어주도록 하자. 그리고 왼쪽 자식을 2번에, 오른쪽 자식을 3번에 넣어준다. 그 후 왼쪽 자식과 오른쪽 자식을 알맞게 넣어주면 된다.
이렇게 넣게 되면, 특정 노드의 위치가 i라고 한다면, 자연스럽게 왼쪽 자식의 위치는 i * 2, 오른쪽 자식의 위치는 i * 2 + 1이 되는걸 볼 수 있다. 
즉, 이진트리는 배열로 구현이 가능하며 특정 노드 i의 자식 노드를 조회하기 위해서는 i * 2, i * 2 + 1을 하면 된다.
반대로 부모노드의 위치는 i / 2로 결정된다는 것을 어렵지 않게 알 수 있다.
자식의 수가 제한되어 있어서, 구현하기 상대적으로 간편하다는 장점이 있다. 특히, 배열을 사용하면 부모에서 자식으로 이동하는 연산 또한 구현할 수 있기에 다양한 알고리즘에 사용된다.

```

![](https://velog.velcdn.com/images/choidongkuen/post/15e1e705-300c-4c39-9c00-91b68d172ec4/image.png)

```
이진 트리의 탐색 기법


이진트리는 재귀를 사용하면 탐색을 비교적 쉽게 구현할 수 있다.
어떤식으로 방문하는 순서에 따라 크게 세가지로 나뉜다.
각각 전위 탐색 (Preorder Traversal), 중위 탐색 (Inorder Traversal), 후위 탐색 (Postorder Traversal) 이다.
밑에 그림을 보고 각 탐색 기법을 구체적으로 배워보자!



1. 전위 탐색
전위 탐색은 부모 - 왼쪽 자식 - 오른쪽 자식순으로 탐색한다. 이 뜻은 모든 노드에 대해 부모에 먼저 색칠을 진행한 후,
왼쪽 자식들을 전부 순회하고, 그 이후에 오른쪽 자식들을 방문함을 뜻한다.
따라서 위에 이진 트리에서의 전위 탐색의 순서는 : 0->1->3->7->8->4->9->10->2->5->11->6 이 된다.

2. 중위 탐색
중위 탐색은 왼쪽 자식 - 부모 - 오른쪽 자식순으로 탐색한다. 이 뜻은 모든 노드에 대해 왼쪽 자식들을 먼저 전부 순회한 후,
부모에 색칠을 진행하고 그 이후에 오른쪽 자식들을 방문함을 뜻한다.
따라서 위에 이진 트리에서의 중위 탐색의 순서는 : 7->3->8->1->9->4->10->0->11->5->2->6 이 된다.

3. 후위 탐색
후위 탐색은 왼쪽 자식 - 오른쪽 자식 - 부모순으로 탐색한다. 이 뜻은 모든 노드에 대해 왼쪽 자식들을 먼저 전부 순회한 후,
오른쪽 자식들을 전부 순회하고 그 이후에 마지막으로 부모에 색칠을 진행함을 뜻한다.
따라서 위에 이진 트리에서의 후위 탐색의 순서는 : 7->8->3->9->10->4->1->11->5->6->2->0 이 된다.


- 각 탐색 기법의 수도 코드(재귀) 🔥

function preorder(n)
  if n == null
    return
  visit(n)
  preorder(n.left)
  preorder(n.right)

function inorder(n)
  if n == null
    return
  inorder(n.left)
  visit(n)
  inorder(n.right)
  
function postorder(n)
  if n == null
    return
  postorder(n.left)
  postorder(n.right)
  visit(n)
  
// visit(n) -> n 노드를 방문 기록
```

## 이진탐색트리(Binary Search Tree) 🎄
> - 이진 탐색 트리란 무엇일까? 🤔
    
>   - 이진탐색 트리란 이진탐색(BinarySearch)와 연결리스트(LinkedList)를 결합한 자료구조의 일종이다. 즉, 이진탐색의 효율적인 *탐색 능력* 과 효율적인 *삽입
      /삭제* 를 보장하는 연결리스트의 장점을 활용한 구조이다.
>   - 이진탐색의 경우 정렬된 상태에서 소요되는 시간 복잡도는 O(log n)으로 빠르지만 삽입/삭제가 불가능하다. 
>   - 연결리스트의 경우 삽입/삭제에 소요되는 시간 복잡도는 O(1)으로 뻐르지만 탐색이 O(n)이 걸린다.


> 이진탐색트리 Img
![](https://velog.velcdn.com/images/choidongkuen/post/5d741da6-1b0b-4634-b8a5-440fe12f1d45/image.png)


> 이진탐색트리의 특성 ⭐️
> 
>
> - 각 노드의 왼쪽 서브트리에는 해당 노드의 값보다 작은 값을 지닌 노드들로 이루어져 있다.
> - 각 노드의 오른쪽 서브트리에는 해당 노드의 값보다 큰 값을 지닌 노드들로 이루어져 있다.
> - 중복된 노드는 없어야 한다.
> - 왼쪽 서브트리, 오른쪽 서브트리 또한 이진탐색트리이다.


 ### 1. 이진탐색트리의 탐색 연산
>  탐색 연산의 과정
>  
> ⭐️ 루트 노드에서 시작하여 찾고자 하는 값 x와 일치하기 전까지 계속 이동하면 된다. 이때 이진탐색트리의 특성을 잘 활용하면된다.<br>
> 
> ⭐️ 만약 현재 노드에 적혀있는 값이 x보다 크다면, x는 현재노드 기준 왼쪽 서브트리에 있을 것임으로, node.left 로 이동하고, 현재 노드에 적혀있는 값이 찾으려고 하는 값보다 작다면 x는 현재 노드의 오른쪽에 있다는 뜻이므로, node.right 로 이동하면 된다.
>
> 



> 탐색 연산의 수도 코드

```
function bst.search(x)
    set node = bst.root                     // root에서 시작한다.
    while node != null and node.value != x  // node에 들어있는 값이 x가 되기 전까지 계속 반복한다.
        if node.value > x                   // 노드에 있는 값이 x보다 크다면
            node = node.left                // 왼쪽 자식으로 내려와 탐색을 진행한다.
        else                                // 노드에 있는 값이 x보다 작다면
            node = node.right               // 오른쪽 자식으로 내려와 탐색을 진행한다.
    
    return node                             // 최종 위치를 반환한다.
```


 ### 2. 이진탐색트리의 삽입 연산

> 삽입 연산의 과정
> 
> ⭐️ 삽입연산은 탐색과정과 거의 비슷하다. 삽입 연산은 항상 리프노드에서 이루어지며(중간에서 삽입하면 이진탐색트리의 속성이 깨질 수 있음), 이미 존재하는 이진탐색트리에 새로운 x 값을 노드화 하여 삽입하는 과정이기에, 
>      최종적으로 node 가 도달한 null 인 지점에서의 parent 정보를 알아야지만, 삽입이 가능하다. <br>
> 
> ⭐️ 만약 null 에 도착했다면 해당 위치에 값을 삽입하면 되는데 그때까지 부모노드를 해당 노드의 전 노드로 설정하여 진행해준다.
> 
> ⭐️ 여기까지 완료했다면 세가지 case 를 고려해주면된다.
>
>
>     case 1 : 트리에 노드가 전혀 없는 경우 -> 이 경우에는 parent값이 null일 것이며, 이진탐색트리의 root를 node(x)로 설정해준다.
> 
>     case 2 : parent에 적혀있는 값이 삽입하려는 값 x보다 더 큰 경우 -> 이 경우에는 parent에 왼쪽에 node(x)를 넣어주면 된다.
> 
>     case 3 : parent에 적혀있는 값이 삽입하려는 값 x보다 더 작은 경우 -> 이 경우에는 parent에 오른쪽에 node(x)를 넣어주면 된다.


> 삽입 연산의 수도 코드
> 
```
function bst.insert(x)
    set node = bst.root         // root에서 시작합니다.
    set parent = bst.root       // parent도 root로 설정하고 시작합니다.

    while node != null          // node가 null이 되기 전까지 반복합니다.
      parent = node             // parent는 항상 node가 움직이기 직전의 위치로 갱신해줍니다. 
      if node.value > x         // node에 적혀있는 값이 x보다 크다면
          node = node.left      // 왼쪽 자식으로 이동해야 합니다. 
      else                      // node에 적혀있는 값이 x보다 작다면
          node = node.right     // 오른쪽 자식으로 이동해야 합니다.

    if parent == null            // Case 1. 비어있는 tree라면
       bst.root = node(x)       // root를 node(x)로 설정해줍니다.
    else if parent.value > x     // Case 2. parent에 적혀있는 값이 추가하려는 값 x보다 크다면
       parent.left = node(x)    // parent의 왼쪽에 node(x)를 넣어줍니다.
    else                         // Case 3. parent에 적혀있는 값이 추가하려는 값 x보다 작다면
       parent.right = node(x)   // parent의 오른쪽에 node(x)를 넣어줍니다.
```

### 3. 이진탐색트리의 삭제 연산

> 삭제 연산의 과정<br>
> 
> 삭제 연산은 비교적 복잡하니 차근차근 따라가 보자.
> 
> ⭐️ 가장 먼저 삭제하고자 하는 값을 탐색한다.<br>
> 
> ⭐️ 값을 찾았을때, 3가지 case 로 나뉘게 된다.
> 
> 
>      case1 : 값을 찾았을 떄 해당 노드(node)의 왼쪽 노드가 비어있다면, node의 오른쪽 노드를 위로 올려주면 된다.
> 
>      case2 : 값을 찾았을 때 해당 노드(node)의 오른쪽 노드가 비어있다면, node의 왼쪽 노드를 위로 올려주면 된다.
> 
>      case3 : 값을 찾았을 떄 왼쪽 오른쪽이 전부 채워져 있다면, successor 를 찾아야 한다. 여기서 successor 란 현재 노드를
>      기준으로 큰 값중에 가장 작은 값을 갖는 노드를 말한다. successor 를 찾았다면, successor를 삭제하려고 하는 노드자리에 
>      삽입하고, successor의 오른쪽 자식을 해당 자리에서 위로 올려주면 된다. 그러나 만약 successor가 삭제하고자 하는 노드에 오른쪽
>      자식인 경우, 단순히 node의 오른쪽 노드(successor)를 위로 올려주면 된다.


> 삭제 연산의 수도 코드

```
function bst.search(x)
    set node = bst.root                     
    while node != null and node.value != x 
        if node.value > x                
            node = node.left           
        else                               
            node = node.right           
    
    return node            

function bst.minimum(node)                  // node 하위 트리에서 최솟값을 구한다.
    while node.left != null                 // node의 left가 null이 아니면 계속 내려간다.
        node = node.left
    return node                             // 최종 node의 위치를 반환한다.

function bst.delete(x)                      // x를 찾아 삭제하는 메소드이다.
    set node = bst.search(x)                // x 값을 찾는다.
    
    if node.left == null                    // Case 1. node의 왼쪽 자식이 비어있다면
        move(node.right, node)              // 오른쪽 자식을 위로 올려준다.
    else if node.right == null              // Case 2. node의 오른쪽 자식이 비어있다면
        move(node.left, node)               // 왼쪽 자식을 위로 올려준다.
    else                                    // Case 3. 왼쪽 오른쪽 자식이 모두 채워져있다면
        set succ = bst.minimum(node.right)  // 해당 노드의 successor를 구한다.
                                            // 이는 현재 노드의 오른쪽 자식에서 시작하여 계속 왼쪽으로 내려가는 것을
                                            // 반복하면 가능하다.
        if succ == node.right               // 만약 successor가 현재 노드의 오른쪽 자식이라면 
            move(node.right, node)          // 오른쪽 자식을 위로 올려준다.
        else                                // 그렇지 않은 일반적인 경우라면
            node.value = succ.value         // node의 값을 successor의 값으로 대체시켜준 뒤,
            move(succ.right, succ)          // successor의 오른쪽 자식을 위로 끌어올려준다.

```
      


      
