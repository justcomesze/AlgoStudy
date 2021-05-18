/* ch5 DFS/BFS 실전문제 미로찾기 */
/* 나중에 한번 더 풀어보기 */
package ch1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

class Node{
	public int x;
	public int y;
	
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
}

public class Main{
	public static int[][] maze;
	public static int n, m;
	public static int dx[] = {-1, 1, 0, 0};
	public static int dy[] = {0, 0, -1, 1};
	
	
	public static int bfs(int x, int y) {
		Queue<Node> queue = new LinkedList<>();
		// queue에 삽입
		queue.offer(new Node(x, y));
		
		while(!queue.isEmpty()) {
			// queue에서 삭제 
			Node node = queue.poll();
			x = node.getX();
			y = node.getY();
			
			for(int i = 0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				// 미로 공간 밖의 경우 skip
				if(nx < 0 || nx >= n || ny < 0 || ny >= m) 
					continue;
				// 괴물이 있는 경우 skip
				if(maze[nx][ny] == 0)
					continue;
				// 괴물이 없으면서 방문하지 않았던 칸이었을 경우 해당 칸 방문 
				if(maze[nx][ny] == 1) {
					maze[nx][ny] = maze[x][y] + 1;
					queue.offer(new Node(nx, ny));
				}
			}
		}
		return maze[n-1][m-1];
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
	
		maze = new int[n][m];
		
		for(int i = 0; i<n; i++) {
			input = br.readLine().split("", m);
			for(int j = 0; j<m; j++) {
				maze[i][j] = Integer.parseInt(input[j]);
			}
		}
		
//		for(int i = 0; i<n; i++) {
//			for(int j = 0; j<m; j++) {
//				bw.write(maze[i][j] + "");
//			}
//			bw.newLine();
//		}
		
		bw.write(bfs(0, 0) + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
