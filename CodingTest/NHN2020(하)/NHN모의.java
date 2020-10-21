import java.util.Scanner;
import java.util.*;
class Main {
		static boolean[][] chk;
	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static int arr[];
	static int idx = 0;
  private static void solution(int sizeOfMatrix, int[][] matrix) {
    // TODO: 이곳에 코드를 작성하세요.
		// 영역의 개수와 각 영역의 크기 출력
		chk = new boolean[sizeOfMatrix][sizeOfMatrix];

		arr = new int[sizeOfMatrix* sizeOfMatrix];
		
		for (int i = 0; i < sizeOfMatrix; i++) {
			for (int j = 0; j < sizeOfMatrix; j++) {
				if(!chk[i][j] && matrix[i][j] == 1) {
					dfs(i, j, sizeOfMatrix, matrix);
										idx++;
				}
			}
		}
		Arrays.sort(arr);
		System.out.println(idx);
		if(idx != 0){
		for(int i = arr.length - idx; i < arr.length;i++){
			System.out.print(arr[i] + " ");
		}
		}

  }
	
	private static void dfs(int x, int y, int sizeOfMatrix, int[][] matrix) {


		chk[x][y] = true;
		arr[idx]++;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= sizeOfMatrix || ny >= sizeOfMatrix || nx < 0 || ny < 0)
				continue;
			if (!chk[nx][ny] && matrix[nx][ny] == 1) {
				chk[nx][ny] = true;
				dfs(nx, ny, sizeOfMatrix, matrix);
			}
		}
	}
  
  private static class InputData {
    int sizeOfMatrix;
    int[][] matrix;
  }

  private static InputData processStdin() {
    InputData inputData = new InputData();

    try (Scanner scanner = new Scanner(System.in)) {
      inputData.sizeOfMatrix = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));      
      
      inputData.matrix = new int[inputData.sizeOfMatrix][inputData.sizeOfMatrix];
      for (int i = 0; i < inputData.sizeOfMatrix; i++) {
        String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
        for (int j = 0; j < inputData.sizeOfMatrix; j++) {
          inputData.matrix[i][j] = Integer.parseInt(buf[j]);
        }
      }
    } catch (Exception e) {
      throw e;
    }

    return inputData;
  }

  public static void main(String[] args) throws Exception {
    InputData inputData = processStdin();

    solution(inputData.sizeOfMatrix, inputData.matrix);
  }
}