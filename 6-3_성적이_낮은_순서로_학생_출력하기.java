/* ch6 성적이 낮은 순서로 학생 출력하기 */
package ch1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student implements Comparable<Student>{
	private String name;
	private int score;
	
	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}

	
	@Override 
	// CompareTo 함수 작성 ( score 기준 정렬을 위해서 ) 
	public int compareTo(Student s) {
		// TODO Auto-generated method stub
		if(this.getScore() < s.getScore()) {
			return -1;
		}
		else if(this.getScore() > s.getScore()) {
			return 1;
		}
		else {
			return 0;
		}
	}
}

public class Main{
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int n = Integer.parseInt(br.readLine().trim());

		List<Student> arr = new ArrayList<Student>(n);
		
		for(int i = 0; i<n; i++) {
			String[] input = br.readLine().split(" ");
			Student s = new Student(input[0], Integer.parseInt(input[1]));
			
			arr.add(s);
		}
		
		Collections.sort(arr);

		for(int i = 0; i<arr.size(); i++) {
			bw.write(arr.get(i).getName() + " ");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
