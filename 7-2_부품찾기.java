/* 7-2 부품탐색 */

package ch1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main{
	
	static int b_search(int start, int end, int num, int[] arr) {
		if(start > end) {
			return 0;
		}
		
		int mid = (start + end) / 2;
		if(num == arr[mid]) {
			return 1;
		}
		else if(num < arr[mid]) {
			return b_search(start, mid - 1, num, arr);
		}
		else {
			return b_search(mid + 1, end, num, arr);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n;
		int m;
		int[] arr; // 전체 부품 배열
		int[] findArr; // 찾을 부품
		String[] input;
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		input = br.readLine().split(" ", n);
		
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		
//		arr 배열 입력 확인
//		for(int i = 0; i<n; i++) {
//			bw.write(arr[i] + " ");
//		}
		Arrays.sort(arr);
		
		m = Integer.parseInt(br.readLine());
		findArr = new int[m];
		input = br.readLine().split(" ", m);
		
		for(int i = 0; i<m; i++) {
			findArr[i] = Integer.parseInt(input[i]);
		}

		for(int i = 0; i<m; i++) {
			int result = b_search(0, n - 1, findArr[i], arr);
			if(result == 1) {
				bw.write("yes ");
			}
			else {
				bw.write("no ");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
