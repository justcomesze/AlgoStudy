/* 8-4 바닥 공사 */

package ch1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[] floor = new int[n + 1];
		
		// 2 x 1, 2 x 2 크기의 타일을 채울 수 있는 경우의 수 ( 점화식의 초기 식 )
		floor[1] = 1;
		floor[2] = 3;
		
		// 2 x i 크기의 바닥을 채우는 경우의 수는 그 2 x (i - 1) 타일에 채울 수 있는 경우의 수 + 2 x ( (i - 2) 타일에 채울 수 있는 경우의 수 ) 
		// a[n] = a[n-1] * (2 * a[n-2])
		for(int i = 3; i<=n; i++) {
			floor[i] = (floor[i-1] + (2 * floor[i-2]) % 796796);
		}
		
		bw.write(floor[n] + " ");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
