# Next_permutation (JAVA)

현재 순열의 상태에서 **크기순으로(사전순) 다음에 올 수 있는 순열**을 구하는 알고리즘

> c++ 에는 라이브러리로 제공이 되지만, Java에선 직접 구현하여 사용해야 한다.

<br>

## 구현 STEP

### 1. 리스트의 맨 뒷쪽부터 탐색하며 꼭대기(i)를 찾기

ex) `1 3 5 4 2` 

2부터 앞으로 이동하다가 값이 작아지는 지점은 5가 된다. 

따라서, 꼭대기는 **5**.

i는 5의 인덱스인 2가 된다.

* **i-1: 교환자리**

  * i가 0이면 N개 가지고 만드는 가장 큰 순열이라 더이상 다음 순열 생성 불가
  * i가 0이 아니면 그 다음값이 교환되어야 할 자리임

  => i-1 = (2-1).

  다음 순열을 만들기 위해 **교환할 자리는 1번 인덱스인 3**이 된다.

<br>

### 2. i-1이랑 교환할 큰 값 찾기

`1 3 5 4 2` 에서 다음 순열인 `1 4 2 3 5` 를 만들기 위해 값들을 교환해주어야 한다.

다시 리스트의 맨 뒷쪽부터 탐색하며 **i-1의 수(예제에서는 3)보다 큰 숫자중에 가장 작은 값**을 찾는다. (예제에서는 4) => **j**

<br>

### 3. i-1 위치와 j 위치의 값을 교환

1,2번 step에서 찾은 i-1과 j위치의 값을 교환한다.

3과 4를 교환하면, `1 4 5 3 2` 가 된다.

<br>

### 4. 꼭대기 위치 (i) 부터 맨 뒤까지 오름차순으로 정렬

제일 큰 값과 제일 작은 값 swap

그 다음으로 큰 값과 그 다음으로 작은 값 swap

위의 방식으로 정렬 한다.

<br>

## 소스코드



```java
	private static boolean next_permutation(int[] list) {
		// 리스트의 맨 뒤부터 시작
		int i = list.length -1;
		int j = list.length -1;
		
		// 1. 꼭대기 찾기
		while(i > 0 && list[i-1] >= list[i]) {
			--i;
		}
		if(i <= 0) return false;
		
		// 2. j값 찾기 (i-1은 교환할 자리. 이것보다 큰 값중에 가장 작은 숫자 고르기)
		while(list[i-1] >= list[j]) {
			--j;
		}
		swap(i-1, j);
		
		// 3. i부터 맨 끝까지 오름차순 정렬
		int k = list.length -1;
		while(i<k) {
			swap(i, k);
			++i; --k;
		}
		// 출력
		System.out.println(Arrays.toString(list));
		
		return true;
	}
	
	private static void swap(int i, int j) {
		int tmp = list[i];
		list[i] = list[j];
		list[j] = tmp;
	}
```




