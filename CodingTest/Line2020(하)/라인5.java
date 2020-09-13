import java.util.ArrayList;

public class 라인5 {
	static class Info {
		int num;
		boolean show;

		public Info(int num, boolean show) {
			this.num = num;
			this.show = show;
		}
	}

	public static void main(String[] args) {

		int[] cards = { 1, 4, 10, 6, 9, 1, 8, 13 };

		int answer = solution(cards);
		System.out.println(answer);

	}

	static public int solution(int[] cards) {
		int answer = -1;
		int money = 0;

		ArrayList<Info> dealer = new ArrayList<>();
		ArrayList<Integer> player = new ArrayList<>();

		boolean stop = false; // 플레이어가 카드 더 받을지 결정하는 변수
		boolean flag = false; // 게임 진행

		int idx = 0;
		while (true) {
			if (idx >= cards.length)
				break;
			// 게임 시작
			int n1 = cards[idx];
			int n2 = cards[idx + 2];

			if (n1 + n2 == 21) { // 블랙잭. 카드 못받음
				stop = true;
				// 딜러랑 비교. 승패 결정 아마 딜러가 무조건 짐
				int tmp1 = cards[idx + 1];
				int tmp2 = cards[idx + 3];
				if (tmp1 + tmp2 != 21)
					money += 3;
			}
			if (!stop) {
				player.add(cards[idx++]);
				dealer.add(new Info(cards[idx++], false)); // false는 뒤집어져있는거
				player.add(cards[idx++]);
				dealer.add(new Info(cards[idx++], true)); // true는 보이는거

				// 딜러 보이는 카드 확인
				if (checkOneSeven(dealer)) {
					// 합이 17 이상이 될때까지 받기
					int sum = 0;
					for (int num : player) {
						if(num == 1)
							num = 11;
						sum += num;
					}
					while (true) {
						if (sum >= 17)
							break;
						else {
							int num = 0;
							if(cards[idx] == 1) {
								num = 11;
								sum += num;
							}else
								sum += cards[idx];
							player.add(cards[idx++]);
						}
					}
				}

				// 딜러 4,5,6이면
				if (check2(dealer)) {
					stop = true; // 카드 그만받기
				}

				// 딜러 2,3 이면
				if (check3(dealer)) {
					// 합이 12 이상이 될때까지 받기
					int sum = 0;
					for (int num : player) {
						sum += num;
					}
					while (true) {
						if (sum >= 12)
							break;
						else {
							sum += cards[idx];
							player.add(cards[idx++]);
						}
					}
				}

				// 딜러 카드 합이 17이상이 될때까지 받기
				int dsum = 0;
				for (Info tmp : dealer) {
					tmp.show = true;
					dsum += tmp.num;
				}
				while (true) {
					if (dsum >= 17)
						break;
					else {
						dsum += cards[idx];
						dealer.add(new Info(cards[idx++], true));
					}
				}
				if (dsum >= 21) {
					money += 2; // 플레이어 승
				}
				// 플레이어합이랑 딜러합중 21에 더 가까운사람 승
				else {
					money += winner(player, dealer);
				}
			}
		}
		answer = money;
		return answer;
	}

	public static int winner(ArrayList<Integer> player, ArrayList<Info> dealer) {
		int psum = 0;
		for (int num : player) {
			psum += num;
		}

		int dsum = 0;
		for (Info tmp : dealer) {
			dsum += tmp.num;
		}

		if (psum - 21 < dsum - 21)
			return 2;
		else if (psum - 21 > dsum - 21)
			return -2;
		else if ((psum - 21) == (dsum - 21))
			return 0;
		return 0;

	}

	public static boolean check(ArrayList<Integer> list) {
		int sum = 0;
		for (int num : list) {
			sum += num;
			if (sum >= 21)
				return false;
		}

		return true;
	}

	public static boolean checkOneSeven(ArrayList<Info> dealer) {

		for (Info tmp : dealer) {
			int num = tmp.num;
			boolean show = tmp.show;

			if (show) {
				if (num == 1 || num >= 7)
					return true;
			}
		}
		return false;
	}

	public static boolean check2(ArrayList<Info> dealer) {

		for (Info tmp : dealer) {
			int num = tmp.num;
			boolean show = tmp.show;

			if (show) {
				if (num == 4 || num == 5 || num == 6)
					return true;
			}
		}
		return false;
	}

	public static boolean check3(ArrayList<Info> dealer) {

		for (Info tmp : dealer) {
			int num = tmp.num;
			boolean show = tmp.show;

			if (show) {
				if (num == 2 || num == 3)
					return true;
			}
		}
		return false;
	}
}
