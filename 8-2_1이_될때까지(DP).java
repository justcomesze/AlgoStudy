/* 8-2 1로 만들기 (DP) 다시 풀어보기 */

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
		
		int[] numArr = new int[n+1];
		
		// 직접 풀어본 code
//		for(int i = 2; i<=n; i++) {
//			
//			if((i / 2 == 1 && i % 2 == 0) || (i / 3 == 1 && i % 3 == 0) || (i / 5 == 1) && i % 5 == 0) {
//				numArr[i]++;
//			}
//			else if(i % 5 == 0){
//				numArr[i] = numArr[i/5] + 1;
//			}
//			else if((i-1) % 5 == 0) {
//				numArr[i] = numArr[(i-1) / 5] + 2; 
//			}
//			else if(i % 3 == 0) {
//				numArr[i] = numArr[i/3] + 1;
//			}
//			else if(i % 2 == 0) {
//				numArr[i] = numArr[i/2] + 1;
//			}
//			else {
//				numArr[i] = numArr[i-1] + 1;
// 			}
//		}
//		
//		bw.write(numArr[n] + "\n");
//
		// 해답 보고 구현해 본 코드 , java.lang.Math import해서 max, min 등 사용 가능
		
		for(int i = 2; i<=n; i++) {
			
			numArr[i] = numArr[i - 1] + 1;
			
			if(i % 2 == 0) {
				numArr[i] = Math.min(numArr[i], numArr[i/2] + 1);
			}
			if(i % 3 == 0) {
				numArr[i] = Math.min(numArr[i], numArr[i/3] + 1);
			}
			if(i % 5 == 0) {
				numArr[i] = Math.min(numArr[i], numArr[i/5] + 1);
			}
		}
		
		bw.write(numArr[n] + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
