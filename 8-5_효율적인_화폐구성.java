/* 8-5 효율적인 화폐구성 다시풀어보기 (해답봐도 이해가 안됨) */

package ch1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main{
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		
		int[] coinArr = new int[n];
		int[] resultArr = new int[m+1];
		// 배열 같은 값으로 채우기
		Arrays.fill(resultArr, 10001);
		
		for(int i = 0; i<n; i++) {
			coinArr[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = 0; i<=n; i++) {
			for(int j = resultArr[i]; j<=m; j++) {
				//(i-k)원을 만드는 방법이 존재 하는 경우
				if(resultArr[j - coinArr[i]] != 10001) {
					resultArr[j] = Math.min(resultArr[j], resultArr[j - coinArr[i]] + 1);
				}
			}
		}
		
		if(resultArr[m] == 10001) {
			bw.write(-1);
		}else {
			bw.write(resultArr[m]);
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
