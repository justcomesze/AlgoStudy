/* 10-2 팀 결성 */

package ch1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{
	static int[] students;
	static int n, m;
	
	public static int findStudent(int x) {
		if(x == students[x]) return x;
		return students[x] = findStudent(students[x]);
	}
	
	public static void unionStudent(int a, int b) {
		a = findStudent(a);
		b = findStudent(b);
		
		if(a < b) students[b] = a;
		else students[a] = b;
	}
//	내가 짠 소스 (서로소 알고리즘 사용 x)	
//	public static void makeTeam(int a, int b) {
//		for(int i = 0; i<students.length; i++) {
//			if(students[i] == students[b]) {
//				students[i] = students[a];
//			}
//		}
//	}
//	
//	public static boolean isTeam(int a, int b) {
//		if(a == b) {
//			return true;
//		}
//		else {
//			return false;
//		}
//	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input = br.readLine().split(" ", 2);
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		
		students = new int[n+1];
		
		for(int i = 1; i<=n; i++) {
			students[i] = i;
		}
		
		String[] operation;
		for(int i = 0; i<m; i++) {
			operation = br.readLine().split(" ", 3);
			if(operation[0].equals("0")) {
				unionStudent(Integer.parseInt(operation[1]), Integer.parseInt(operation[2]));
			}
			else if(operation[0].equals("1")) {
				if(findStudent(Integer.parseInt(operation[1])) == findStudent(Integer.parseInt(operation[2]))) {
					bw.write("YES\n");
				}
				else {
					bw.write("NO\n");
				}
			}
		}
//		내가 짠 소스
//		boolean flag;
//		
//		for(int i = 0; i<m; i++) {
//			operation = br.readLine().split(" ", 3);
//			
//			if(operation[0].equals("0")) {
//				makeTeam(Integer.parseInt(operation[1]), Integer.parseInt(operation[2]));
//			}
//			else if(operation[0].equals("1")) {
//				flag = isTeam(Integer.parseInt(operation[1]), Integer.parseInt(operation[2]));
//				if(flag) {
//					bw.write("YES\n");
//				}
//				else {
//					bw.write("NO\n");
//				}
//			}
//			else {
//				continue;
//			}
//		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
