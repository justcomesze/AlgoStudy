/* 9-3 플로이드 워셜 알고리즘 */

package ch1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main{
	
	public static final int INF = (int) 1e9; // 무한(10억)
	// 노드의 개수 n, 간선의 개수 m
	public static int n, m;
	public static int[][] graph = new int[501][501];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input;
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		// 최단 거리 테이블을 모두 무한으로 초기화
		for(int i = 0; i<501; i++) {
			Arrays.fill(graph[i], INF);
		}
		
		// 자기 자신에서 자신으로 가는 비용은 0으로 초기환
		for(int a = 1; a<=n; a++) {
			for(int b = 1; b<=n; b++) {
				if(a == b)
					graph[a][b] = 0;
			}
		}
		
		// 각 간선에 대한 정보를 입력받아, 그 값으로 초기화
		for(int i = 0; i<m; i++) {
			// A에서 B로 가는 비용은 C라고 설정
			input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			int c = Integer.parseInt(input[2]);
			
			graph[a][b] = c;
		}
		
		// 점화식에 따라 플로이드 워셜 알고리즘을 수행
		for(int k = 1; k<=n; k++) {
			for(int a = 1; a<=n; a++) {
				for(int b = 1; b<=n; b++) {
					graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
				}
			}
		}
		
		// 수행된 결과 출력
		for(int a = 1; a<=n; a++) {
			for(int b = 1; b<=n; b++) {
				// 도달할 수 없는 경우 무한
				if(graph[a][b] == INF) {
					bw.write("INFINITY ");
				}
				// 도달할 수 있는 경우 거리 출력
				else {
					bw.write(graph[a][b] + " ");
				}
			}
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
