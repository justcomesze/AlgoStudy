/* 9-1 다익스트라 알고리즘 */

package ch1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Node {
	private int index;
	private int distance;
	
	public Node(int index, int distance) {
		this.index = index;
		this.distance = distance;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	
}
public class Main{
	
	public static final int INF = (int) 1e9; // 무한
	public static int n, m, start;
	// 각 노드에 연결되어 있는 노드에 대한 정보를 담는 배열
	public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	// 방문한 적이 있는지 체크하는 목적의 배열
	public static boolean[] visited = new boolean[100001];
	// 최단 거리 테이블
	public static int[] d = new int[100001];
	
	// 방문하지 않은 노드 중 가장 최단 거리가 짧은 노드의 번호 반환
	public static int getSmallestNode() {
        int min_value = INF;
        int index = 0; // 가장 최단 거리가 짧은 노드(인덱스)
        for (int i = 1; i <= n; i++) {
            if (d[i] < min_value && !visited[i]) {
                min_value = d[i];
                index = i;
            }
        }
        return index;
    }
	
	public static void dijkstra(int start) {
		// 시작 노드 초기화
		d[start] = 0;
		visited[start] = true;
		for(int j = 0; j < graph.get(start).size(); j++) {
			d[graph.get(start).get(j).getIndex()] = graph.get(start).get(j).getDistance();
		}
		
		// 시작 노드를 제외한 전체 n - 1 개의 노드에 대해 반복
		for(int i = 0; i < n - 1; i++) {
			// 현재 최단 거리가 가장 짧은 노드를 꺼내서 방문처리
			int now = getSmallestNode();
			visited[now] = true;
			// 현재 노드와 연결된 다른 노드 확인
			for(int j = 0; j < graph.get(now).size(); j++) {
				int cost = d[now] + graph.get(now).get(j).getDistance();
				
				// 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
				if(cost < d[graph.get(now).get(j).getIndex()]) {
					d[graph.get(now).get(j).getIndex()] = cost;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 노드의 개수, 간선의 개수를 입력받기
		String[] input = br.readLine().split(" ", 2);
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		
		// 시작 노드 번호 입력
		start = Integer.parseInt(br.readLine());
		
		// 그래프 초기화
		for(int i = 0; i<=n; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		for(int i = 0; i<m; i++) {
			input = br.readLine().split(" ", 3);
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			int c = Integer.parseInt(input[2]);
			
			// a번 노드에서 b번 노드로 가는 비용이 c라는 의미
			graph.get(a).add(new Node(b, c));
		}
		
		Arrays.fill(d, INF);
		dijkstra(start);
		for(int i = 1; i<=n; i++) {
			if(d[i] == INF) {
				bw.write("INFINITY" + "\n");
			}
			else {
				bw.write(d[i] + "\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
