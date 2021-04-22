/* ch5 DFS/BFS 실전문제 음료수 얼려먹기 */
/* 나중에 한번 더 풀어보기 */
package ch1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{
	
	static int[][] plate;
	static int n, m;
	static int cnt;

	public static boolean dfs(int x, int y) {
		// 0 ~ n-1, 0 ~ m-1의 범위를 벗어났을 경우 
		if(x < 0 || x >= n || y < 0 || y >= m) {
			return false;
		}
		
		// 아직 방문하지 않은 노드일 경우 (얼릴 수 있는 칸일 경우)
		if(plate[x][y] == 0) {
			plate[x][y] = 1;
			// 상하좌우 dfs 탐색
			dfs(x, y - 1);
			dfs(x, y + 1);
			dfs(x - 1, y);
			dfs(x + 1, y);
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		
		plate = new int[n][m];
		
		for(int i = 0; i<n; i++) {
			input = br.readLine().split("", m);
			for(int j = 0; j<m; j++) {
				plate[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(dfs(i, j) == true) {
					cnt++;
				}
			}
		}
		bw.write(cnt + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
