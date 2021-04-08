/* 예제 4-1 상하좌우 */
package ch1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

public class Main{
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = br.readLine();
		
		int n = Integer.parseInt(s);
		
		String input = br.readLine();
		String[] move = input.split(" ");
		
		int x = 0;
		int y = 0;
		
		for(int i = 0; i<move.length; i++) {
			if(move[i].equals("L") && y > 0) {
				y--;
			}
			else if(move[i].equals("R") && y < n-1) {
				y++;
			}
			else if(move[i].equals("U") && x > 0) {
				x--;
			}
			else if(move[i].equals("D") && x < n-1) {
				x++;
			}
		}
		// 좌포는 (1 1)부터 시작이므로 x와 y에 +1 
		x++;
		y++;
		
		bw.write(x + " " + y);
		bw.flush();
		bw.close();
		br.close();
	}
}
