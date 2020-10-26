package NHN;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;import javax.swing.text.DefaultEditorKit.CopyAction;

class Solution2 {
	private static void solution(int day, int width, int[][] blocks) {
		// TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.

//		while (day-- > 0) {
//			for (int i = 0; i < blocks.length; i++) {
//				Arra
//			}
//		}
		int total = 0;
		for (int i = 0; i < day; i++) {
			int[] copyArr = Arrays.copyOf(blocks[i], blocks[i].length);
			if(i>0) {
				for (int j = 0; j < blocks.length; j++) {
					copyArr[j] += blocks[i-1][j];
				}
			}
			Arrays.sort(copyArr); // 1일차
			int diff = 0;
			for (int j = blocks[i].length - 1; j > 0; j--) {
				int cur = copyArr[j];
				int nxt = copyArr[j-1];
				diff = cur - nxt;
				total+= diff;
			}
		}
		System.out.println(total);

	}

	private static class InputData {
		int day;
		int width;
		int[][] blocks;
	}

	private static InputData processStdin() {
		InputData inputData = new InputData();

		try (Scanner scanner = new Scanner(System.in)) {
			inputData.day = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
			inputData.width = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

			inputData.blocks = new int[inputData.day][inputData.width];
			for (int i = 0; i < inputData.day; i++) {
				String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
				for (int j = 0; j < inputData.width; j++) {
					inputData.blocks[i][j] = Integer.parseInt(buf[j]);
				}
			}
		} catch (Exception e) {
			throw e;
		}

		return inputData;
	}

	public static void main(String[] args) throws Exception {
		InputData inputData = processStdin();

		solution(inputData.day, inputData.width, inputData.blocks);
	}
}