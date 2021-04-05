/* 그리디 알고리즘 실전문제 3 숫자 카드 게임 */
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
		
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		
		int result;
		int min;
		
		int[][] arr = new int[n][m];
		int[] minNums = new int[n];
		
		for(int i = 0; i<n; i++) {
			s = br.readLine().split(" ");
			
			for(int j = 0; j<m; j++) {
				arr[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		/* 배열 출력 */
//		for(int i = 0; i<n; i++) {
//			for(int j = 0; j<m; j++) {
//				bw.write(arr[i][j]+ " ");
//			}
//			bw.newLine();
//		}
		
		for(int i = 0; i<n; i++) {
			min = 10001;
			for(int j = 0; j<m; j++) {
				if(arr[i][j] < min) {
					min = arr[i][j];
				}
			}
			minNums[i] = min;
		}
		
		Arrays.sort(minNums);
		result = minNums[n-1];
		
		bw.write(result + "");
		
		bw.flush();
		br.close();
		bw.close();
	}
}

