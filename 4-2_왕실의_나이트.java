/* ch4 구현 실전문제 정원의 나이트 */
package ch1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{
	
	public static int knight(int x, int y) {
		int cnt = 0;
		
		// 오른쪽으로 두 칸 이동했을 경우
		if(x + 2 < 8) {
			if(y - 1 > -1) {
				cnt++;
			}
			if(y + 1 < 8) {
				cnt++;
			}
		}
		// 왼쪽으로 두 칸 이동했을 경우 
		if(x - 2 > -1) {
			if(y - 1 > -1) {
				cnt++;
			}
			if(y + 1 < 8) {
				cnt++;
			}
		}
		// 아래로 두 칸 이동했을 경우
		if(y + 2 < 8) {
			if(x - 1 > -1) {
				cnt++;
			}
			if(x + 1 < 8) {
				cnt++;
			}
		}
		// 위로 두 칸 이동했을 경우
		if(y - 2 > -1) {
			if(x - 1 > -1) {
				cnt++;
			}
			if(x + 1 < 8) {
				cnt++;
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		String[] alphabets = {"a", "b", "c", "d", "e", "f", "g", "h"};
		int result;
		
		String[] s = br.readLine().split("");
		
		int x = -1;
		int y = Integer.parseInt(s[1]) - 1;
		
		for(int i = 0; i<alphabets.length; i++) {
			if(s[0].equals(alphabets[i])) {
				x = i;
				break;
			}
		}
		result = knight(x, y);

		bw.write(result + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
