/* 예제 4-2 시각 */
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
		
		int n = Integer.parseInt(s); // n은 시간에 해당하는 수
		int cnt = 0;
		
		for(int i = 0; i<=n; i++) { // n == hour
			for(int j = 0; j < 60; j++) { // j == min
				for(int k = 0; k < 60; k++) { // k == sec
					if((j / 10) == 3 || (k / 10) == 3) { // min or sec의 앞자리가 3일 때 count up ex)30~39
						cnt++;
						continue; // 다음 수로 이동
					}
					
					if((i % 10) == 3 || (j % 10) == 3 || (k % 10) == 3) { // hour or min or sec의 뒷자리가 3일때 count up
						cnt++;
					}
				}
			}
		}
		
		bw.write(cnt + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
