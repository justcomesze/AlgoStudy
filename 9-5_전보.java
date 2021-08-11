/* 9-5 전보 (다시 풀어볼 문제)*/

package ch1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;


class Node implements Comparable<Node> {
	
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

	// 거리가 짧은 것이 높은 우선순위를 가지도록 설정
	@Override
	public int compareTo(Node o) {
		if(this.distance < o.distance) {
			return -1;
		}
		return 1;
	}
}

public class Main{
	/*
	 * n = 도시의 개수
	 * m = 통로의 개수
	 * c = 출발하려는 도시
	 * x,y, z= x에서 y로 이동할 경우 z의 시간 걸림
	 * */
	public static int n, m, c, x, y, z;
	public static int cnt, maxDistance;
	public static final int INF = (int) 1e9; // 무한
	
	// 각 노드에 연결되어 있는 노드에 대한 정보를 담는 배열
		public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
		// 최단 거리 테이블
		public static int[] d = new int[100001];
		
		public static void dijkstra(int start) {
			PriorityQueue<Node> pq = new PriorityQueue<>();
			// 시작 노드로 가기 위한 최단 경로는 0으로 설정, 큐에 삽입
			pq.offer(new Node(start, 0));
			d[start] = 0;
			while(!pq.isEmpty()) { // 큐가 비어있지 않다면
				// 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
				Node node = pq.poll();
				int dist = node.getDistance(); // 현재 노드까지의 비용
				int now = node.getIndex(); // 현재 노드
				// 현재 노드가 이미 처리된 적이 있는 노드라면 무시
				if(d[now] < dist)
					continue;
				// 현재 노드와 연결된 다른 인접한 노드들 확인
				for(int i = 0; i<graph.get(now).size(); i++) {
					int cost = d[now] + graph.get(now).get(i).getDistance();
					//현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
					if(cost < d[graph.get(now).get(i).getIndex()]) {
						d[graph.get(now).get(i).getIndex()] = cost;
						pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
					}
				}
			}
		}
			
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input = br.readLine().split(" ", 3);
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		c = Integer.parseInt(input[2]);
		
		for(int i = 0; i<=n; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		for(int i = 0; i<m; i++) {
			input = br.readLine().split(" ", 3);
			x = Integer.parseInt(input[0]);
			y = Integer.parseInt(input[1]);
			z = Integer.parseInt(input[2]);
			
			graph.get(x).add(new Node(y, z));
		}
		
		Arrays.fill(d, INF);
		
		dijkstra(c);
		
		for(int i = 1; i<=n; i++) {
			if(d[i] != INF) {
				cnt++;
				maxDistance = Math.max(maxDistance, d[i]);
			}
		}
		
		bw.write((cnt - 1) + " " + maxDistance);
		
		bw.flush();
		bw.close();
		br.close();
	}
}
