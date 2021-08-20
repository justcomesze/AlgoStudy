/* 10-5 크루스칼 알고리즘*/

package ch1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

class Edge implements Comparable<Edge>{
	private int distance;
	private int nodeA;
	private int nodeB;
	
	public Edge(int distance, int nodeA, int nodeB) {
		this.distance = distance;
		this.nodeA = nodeA;
		this.nodeB = nodeB;
	}

	public int getDistance() {
		return distance;
	}

	public int getNodeA() {
		return nodeA;
	}

	public int getNodeB() {
		return nodeB;
	}

	@Override
	public int compareTo(Edge other) {
		if(this.distance < other.distance) {
			return -1;
		}
		return 1;
	}
	
}

public class Main{
		// node의 개수 v, edge의 개수 e, node의 수는 최대 100,000
		public static int v, e;
		public static int[] parent = new int[100001];
		public static ArrayList<Edge> edges = new ArrayList<>();
		public static int result = 0;
		
		
		// 특정 원소가 속한 집합 찾기
		public static int findParent(int x) {
			// 루트 노드가 아니라면 , 루트 노드를 찾을 때 까지 재귀호출
			if(x == parent[x]) return x;
			return parent[x] = findParent(parent[x]);
		}
		
		// 두원소가 속한 집합을 합치기
		public static void unionParent(int a, int b) {
			a = findParent(a);
			b = findParent(b);
			if(a < b) parent[b] = a;
			else parent[a] = b;
		}
		
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input = br.readLine().split(" ", 2);
		v = Integer.parseInt(input[0]);
		e = Integer.parseInt(input[1]);
		
		for(int i = 1; i<=v; i++) {
			parent[i] = i;
		}
		
		for(int i = 0; i<e; i++) {
			input = br.readLine().split(" ", 3);
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			int cost = Integer.parseInt(input[2]);
			edges.add(new Edge(cost, a, b));
		}
		
		Collections.sort(edges);
		
		for(int i = 0; i<edges.size(); i++) {
			int cost = edges.get(i).getDistance();
			int a = edges.get(i).getNodeA();
			int b = edges.get(i).getNodeB();
			
			if(findParent(a) != findParent(b)) {
				unionParent(a, b);
				result += cost;
			}
		}
		bw.write(result + " ");
		bw.flush();
		bw.close();
		br.close();
	}
}
