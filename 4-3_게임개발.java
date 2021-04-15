/* ch4 구현 실전문제 게임 개발*/
/* 나중에 한번 더 풀어보기 */
package ch1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{
	
	// 왼쪽으로 방향 전환하는 함수
	public static int turn_left(int d) {
		if(d == 0) {
			d = 3;
		}
		else {
			d--;
		}
		return d;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input = br.readLine().split(" ", 2);
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int[][] map = new int[n][m];
		
		input = br.readLine().split(" ", 3);
		int A = Integer.parseInt(input[0]);
		int B = Integer.parseInt(input[1]);
		int d = Integer.parseInt(input[2]);
		
		for(int i = 0; i<n; i++) {
			input = br.readLine().split(" ", m);
			for(int j = 0; j<m; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		
		// map 배열 출력 수행까지 해결했음
//		for(int i = 0; i<n; i++) {
//			for(int j = 0; j<m; j++) {
//				bw.write(map[i][j] + " ");
//			}
//			bw.newLine();
//		}
		
		int cnt = 1; // 최종적으로 이동한 칸의 갯수를 카운팅
		int turn_time = 0; // 방향전환 횟수 카운팅
		
		while(true) {
			d = turn_left(d);
			int nx = A + dx[d];
			int ny = B + dy[d];
			
			// 해당 칸 (왼쪽)이 갈 수 있는 경우
			if(map[nx][ny] == 0) {
				map[nx][ny] = 1;
				A = nx;
				B = ny;
				cnt += 1;
				turn_time = 0;
				continue;
			} 
			else turn_time += 1;
			
			// 사방이 갈수없는 곳 혹은 바다일 경우
			if(turn_time == 4) {
				nx = A - dx[d];
				ny = B - dy[d];
				
				if(map[nx][ny] == 0) {
					A = nx;
					B = ny;
				}
				else break;
				turn_time = 0;
			}
		}
		
		bw.write(cnt + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
