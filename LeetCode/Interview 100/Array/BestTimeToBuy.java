package Array;

public class BestTimeToBuy {
	public static void main(String[] args) {
		
		int[] prices = {7,6,4,3,1};
		System.out.println(maxProfit(prices));
	}

	// price 배열이 주어진다. 당일에 주어진 주식의 가격이 매겨지는 price배열이
	// 얻을 수 있는 최대이익을 찾아라. 
	public static int maxProfit(int[] prices) {
		int answer = 0;

		// 기준 가격보다 큰 가격을 바로 처음 만나는 애
		for (int i = 0; i < prices.length -1; i++) {
			if(prices[i] < prices[i+1]) {
				answer += prices[i+1] - prices[i];
			}
		}
		
		return answer;
	}
}
