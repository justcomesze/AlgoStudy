/* 그리디 알고리즘 실전문제 2번 큰 수의 법칙 */

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
		int k = Integer.parseInt(s[2]);
		
		int[] arr = new int[n];
		int cnt = 0;
		int result = 0;
		
		s = br.readLine().split(" ");
		
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(s[i]);
		}
		
		Arrays.sort(arr);
		
		for(int i = 0; i<m; i++) {
			if(cnt < k) {
				result += arr[n-1];
				cnt++;
			}
			else {
				result += arr[n-2];
				cnt = 0;
			}
		}
		
		bw.write(result + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
