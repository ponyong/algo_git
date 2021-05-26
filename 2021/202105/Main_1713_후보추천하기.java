package Algo_Study_BOJ;

import java.io.*;
import java.util.*;
class Student implements Comparable<Student>{

	int num;
	int point;
	int old;
	
	public Student(int num, int point, int old) {
		this.num = num;
		this.point = point;
		this.old = old;
	}
	@Override
	public int compareTo(Student o) {
		if(this.point == o.point) {
			return this.old - o.old;
		}
		return this.point - o.point;
	}
	
}
public class Main_1713_후보추천하기 {
	public static void main(String[] args) throws Exception {
		// PQ , Map
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int frame = Integer.parseInt(br.readLine());
		int votes = Integer.parseInt(br.readLine());
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		List<Student> list = new ArrayList<Student>(); 
		for(int i = 0; i < votes; i++) {
			
			int vote = Integer.parseInt(str.nextToken());
			
			boolean flag = false;
			for(Student st : list) {
				if(st.num == vote) {
					flag = true;
					st.point++;
					break;
				}
			}
			if(!flag) {
				if(list.size() == frame) {
					list.remove(0);
					list.add(new Student(vote, 1, i));
				}
				else {
					list.add(new Student(vote, 1, i));
				}
			}
			Collections.sort(list);
		}
		Collections.sort(list, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				return o1.num - o2.num;
			}
		});
		for(Student st : list) {
			System.out.print(st.num + " ");
		}
	}
}
