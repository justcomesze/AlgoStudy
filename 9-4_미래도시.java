/* 9-4 미래도시 (다시 풀어볼 문제)*/

package ch1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Main{
	public static final int INF = (int)1e9;
	public static int n, m, a, b, x, k;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input = br.readLine().split(" ", 2);
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		
		int [][] graph = new int[n+1][n+1];
		
		// 모든 값 무한으로 초기화
		for(int i = 0; i<=n; i++) {
			Arrays.fill(graph[i], INF);
		}
		
		// 자기 자신에서 자신으로 가는 비용을 0으로 초기화
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=n; j++) {
				if(i == j) {
					graph[i][j] = 0;
				}
			}
		}
		
		// 각 간선에 대한 정보를 입력받고, 그 값으로 초기화
		for(int i = 0; i<m; i++) {
			input = br.readLine().split(" ", 2);
			a = Integer.parseInt(input[0]);
			b = Integer.parseInt(input[1]);
			// a, b 서로에게 가는 비용은 1
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		
		input = br.readLine().split(" ", 2);
		// 중간에 들르는 지점, 최종지점에 대한 입력
		x = Integer.parseInt(input[0]);
		k = Integer.parseInt(input[1]);
		
		// 플로이드 워셜 알고리즘 실행
		for(int k = 1; k<=n; k++) {
			for(int a = 1; a<=n; a++) {
				for(int b = 1; b<=n; b++) {
					graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
				}
			}
		}
		
		// 시작지점에서 k지점까지의 거리 + k지점에서 x(최종지점)의 거리의 합이 결과값
		int distance = graph[1][k] + graph[k][x];
		
		// 이동할 수 없는 경우
		if(distance >= INF) {
			bw.write("-1");
		}
		// 이동 가능한 경우, 최소 이동 시간 출력
		else {
			bw.write(distance + "");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
