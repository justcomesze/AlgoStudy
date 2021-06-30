/* binary_search */
package ch1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main{
	
	static int count = 0;
	
	static int b_search(int[] arr, int num, int start, int end) {
		count++;
		
		if(start > end) {
			return -1;
		}
		
		int mid = (start + end) / 2;
		
		if(num == arr[mid]) {
			return mid;
		}
		/* 찾으려는 값이 mid의 값과 일치하지 않으므로 mid보다 작을때는 start index부터 mid -1 까지 탐색, 클 때는 mid + 1 부터 end index까지 탐색*/
		else if(num < arr[mid]) {
			return b_search(arr, num, 0, mid - 1);
		}
		else{
			return b_search(arr, num, mid + 1, end);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input = br.readLine().split(" ", 2);
		int n = Integer.parseInt(input[0]);
		int num = Integer.parseInt(input[1]);
		
		int[] arr = new int[n];

		input = br.readLine().split(" ", n);
		
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		
		int result = b_search(arr, num, 0, n-1);
		
		if(result == -1) {
			bw.write("찾는 데이터가 없습니다.");
		}
	
		else {
			bw.write(count + "번만에  index " + result + "위치의 " + num + "을 찾았습니다.");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
