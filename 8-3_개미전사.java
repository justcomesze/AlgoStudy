/* 8-3 개미전사 다시 풀어보기 */

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
		int[] wareHouse = new int[n];
		int[] resultArr = new int[n];
//		
		String[] input = br.readLine().split(" ", n);
//		
//		for(int i = 0; i<n; i++) {
//			wareHouse[i] = Integer.parseInt(input[i]);
//		}
		
		/* 2개의 식량창고만 털 수 있는줄 암 (문제 잘못읽음) */
//		for(int i = 2; i<n; i++) {
//			resultArr[0] = Math.max(resultArr[0], wareHouse[0] + wareHouse[i]);
//		}
//		
//		/* 첫번째 창고를 털었을 때의 얻을 수 있는 식량의 최대값 
//		 * bw.write(resultArr[0] + "");
//		 * 
//		 */
//		
//		for(int i = 1; i<n; i++) {
//			if(i + 2 > n - 1) {
//				resultArr[i] = resultArr[i-1];
//			}
//			else {
//				for(int j = i + 2; j<n; j++) {
//					if(resultArr[i] < resultArr[i-1]) {
//						resultArr[i] = Math.max(resultArr[i-1], wareHouse[i] + wareHouse[j]);
//					}
//					else {
//						resultArr[i] = Math.max(resultArr[i], wareHouse[i] + wareHouse[j]);
//					}
//					
//				}
//			}
//		}
		
		/* 해답 보고 구현한 부분 */
		
		resultArr[0] = wareHouse[0];
		resultArr[1] = Math.max(resultArr[0], wareHouse[1]);
		
		for(int i = 2; i<n; i++) {
			resultArr[i] = Math.max(resultArr[i-1], resultArr[i-2] + wareHouse[i]);
		}
		
		 bw.write(resultArr[n-1] + " ");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
