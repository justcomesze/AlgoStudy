/* ch6 위에서 아래로 */
package ch1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main{
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int n = Integer.parseInt(br.readLine().trim());
//		 방법 1 List type 배열 선언 , Collections.sort 후 reverse로 내림차순
//		List<Integer> arr = new ArrayList<Integer>(n);
//		
//		for(int i = 0; i<n; i++) {
//			arr.add(Integer.valueOf(br.readLine().trim()));
//		}
//		
//		Collections.sort(arr);
//		Collections.reverse(arr);
//		
//		for(int i = 0; i<n; i++) {
//			bw.write(arr.get(i) + " ");
//		}
//		방법 2 Integer 배열 선언, Arrays.sort함수 사용
		Integer[] arr = new Integer[n];

		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine().trim());
		}
		
		Arrays.sort(arr, Comparator.reverseOrder());
		
		for(int i = 0; i<n; i++) {
			bw.write(arr[i] + " ");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
