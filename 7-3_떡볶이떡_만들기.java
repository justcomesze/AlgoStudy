/* 7-3 떡볶이 떡 만들기 (다시 풀어보기) */

package ch1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main{
	static int n;
	static int m;
	static int[] arr;
	static String[] input;
	static int result;
	
	static int b_search(int start, int end) {
		if(start > end) {
			return -1;
		}
		else {
			int mid = (start + end) / 2;
			int sum = 0;
			
			for(int i = 0; i<n; i++) {
				if(arr[i] - (mid + 1) > 0){
					sum += arr[i] - (mid + 1);
				}
			}
			// 자른 떡의 길이의 합이 m과 같을 경우
			if(sum == m) {
				return mid + 1;
			}
			else if(sum < m) {
				return b_search(0, mid - 1);
			}
			else {
				return b_search(mid + 1, end);
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		input = br.readLine().split(" ", 2);
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		
		arr = new int[n];
		
		input = br.readLine().split(" ", n);
		
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		
		Arrays.sort(arr);
		
		bw.write(b_search(0, arr[n-1]) + " ");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
