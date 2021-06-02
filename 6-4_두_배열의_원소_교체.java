/* ch6 두 배열의 원소 교체 */
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
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int temp;
		int sumA = 0;
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
	
		List<Integer> A = new ArrayList<Integer>(n);
		List<Integer> B = new ArrayList<Integer>(n);
	
		input = br.readLine().split(" ", n);
		
		for(int i = 0; i<n; i++) {
			A.add(Integer.valueOf(input[i]));
		}
		
		input = br.readLine().split(" ", n);
		
		for(int i = 0; i<n; i++) {
			B.add(Integer.valueOf(input[i]));
		}
		
		Collections.sort(A);
		Collections.sort(B);
		Collections.reverse(B);
		
		for(int i = 0; i<k; i++) {
			for(int j = 0; j<n; j++) {
				if(A.get(i) < B.get(j)) {
					temp = A.get(i);
					A.set(i, B.get(j));
					B.set(j, temp);
					continue;
				}
			}
		}
		
		// 배열 확인하기 
//		bw.write("A : ");
//		for(int i = 0; i<n; i++) {
//			bw.write(A.get(i) + " ");
//		}
//		bw.newLine();
//		
//		bw.write("B : ");
//		for(int i = 0; i<n; i++) {
//			bw.write(B.get(i) + " ");
//		}
		
		for(int i = 0; i<n; i++) {
			sumA += A.get(i);
		}	
		
		bw.write(sumA + "");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
