package NHN;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Solution1 {
	private static void solution(int numOfAllPlayers, int numOfQuickPlayers, char[] namesOfQuickPlayers, int numOfGames,
			int[] numOfMovesPerGame) {
		// TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.

		// 달리기가 빠른 사람은 절대 안잡히니까, 자기 자리 다시 앉고 술래는 달리기 빠른 사람의 위치에서 시작

		// 선수 초기화
		char[] players = new char[numOfAllPlayers - 1];
		char ch = 'B';
		for (int i = 0; i < numOfAllPlayers - 1; i++) {
			players[i] = ch++;
		}

		ArrayList<Character> quick = new ArrayList<>();
		HashMap<Character, Integer> map = new HashMap<>();

		map.put('A', 1);
		for (int i = 0; i < namesOfQuickPlayers.length; i++) {
			quick.add(namesOfQuickPlayers[i]);
		}

		int start = 0; // a술래일때
		char per = 'a';

		for (int i = 0; i < numOfGames; i++) {
			if (i == 0) {
				per = 'A'; // 술래
				start = 0; // b자리
			}

			
			int step = numOfMovesPerGame[i];
			int next = 0;
			if (step > 0)
				next = step % (numOfAllPlayers - 1);
			else {
				next = (numOfAllPlayers - 1) - (Math.abs(step) % (numOfAllPlayers - 1));
			}
			next = (start + next) % (numOfAllPlayers - 1);

			if (next > players.length) {
				next = next - (players.length + 1);
			} else if (next < 0) {
				next = next + (players.length + 1);
			}
			if (quick.contains(players[next])) { // 빠른 선수일때
				// 기존 술래 한번더 술래하기
				map.put(per, map.get(per) + 1);
				start = next;
			} else { /// 빠른 선수 아닐때
				// 술래가 그 사람 자리에 앉아
				char tmpPer = per;
				per = players[next]; // 술래갱신
				if (map.get(per) == null) {
					map.put(per, 1);
				} else {
					map.put(per, map.get(per) + 1); // 술래 걸린 횟수
				}
				players[next] = tmpPer;
				start = next;
			}
		}
		for (int i = 0; i < players.length; i++) {
			System.out.print(players[i] + " ");
			if (map.get(players[i]) == null)
				System.out.println("0");
			else
				System.out.println(map.get(players[i]));
		}
		System.out.print(per + " ");
		System.out.println(map.get(per));
	}

	private static class InputData {
		int numOfAllPlayers;
		int numOfQuickPlayers;
		char[] namesOfQuickPlayers;
		int numOfGames;
		int[] numOfMovesPerGame;
	}

	private static InputData processStdin() {
		InputData inputData = new InputData();

		try (Scanner scanner = new Scanner(System.in)) {
			inputData.numOfAllPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

			inputData.numOfQuickPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
			inputData.namesOfQuickPlayers = new char[inputData.numOfQuickPlayers];
			System.arraycopy(scanner.nextLine().trim().replaceAll("\\s+", "").toCharArray(), 0,
					inputData.namesOfQuickPlayers, 0, inputData.numOfQuickPlayers);

			inputData.numOfGames = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
			inputData.numOfMovesPerGame = new int[inputData.numOfGames];
			String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
			for (int i = 0; i < inputData.numOfGames; i++) {
				inputData.numOfMovesPerGame[i] = Integer.parseInt(buf[i]);
			}
		} catch (Exception e) {
			throw e;
		}

		return inputData;
	}

	public static void main(String[] args) throws Exception {
		InputData inputData = processStdin();

		solution(inputData.numOfAllPlayers, inputData.numOfQuickPlayers, inputData.namesOfQuickPlayers,
				inputData.numOfGames, inputData.numOfMovesPerGame);
	}
}