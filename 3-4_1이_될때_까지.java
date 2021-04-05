/* 그리디 알고리즘 실전문제 4번 1이 될 때까지 */
package ch1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

public class Main{
	
	static int n;
	static int k;
	static int cnt = 0;
	
	static void untilOne() {
		if(n == 1) {
			System.out.println(cnt);
			return;
		}
		else {
			if(n % k == 0) {
				n /= k;
				cnt++;
			}
			else {
				n -= 1;
				cnt++;
			}
			untilOne();
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		n = Integer.parseInt(s[0]);
		k = Integer.parseInt(s[1]);
		
		untilOne();
		br.close();
	}
}


