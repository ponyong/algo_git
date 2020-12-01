package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main_10866_덱 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new LinkedList<Integer>();
		for (int i = 0; i < N; i++) {
			String[] cmd = br.readLine().split(" ");

			switch (cmd[0]) {
			case "push_front":
				deque.addFirst(Integer.parseInt(cmd[1]));
				break;
			case "push_back":
				deque.addLast(Integer.parseInt(cmd[1]));
				break;
			case "pop_front":
				if(!deque.isEmpty()) {
					System.out.println(deque.getFirst());
					deque.removeFirst();
					break;
				}
				System.out.println("-1");
				break;
			case "pop_back":
				if(!deque.isEmpty()) {
					System.out.println(deque.getLast());
					deque.removeLast();
					break;
				}
				System.out.println("-1");
				break;
			case "size":
				System.out.println(deque.size());
				break;
			case "empty":
				if(!deque.isEmpty()) {
					System.out.println("0");
					break;
				}
				System.out.println("1");
				break;
			case "front":
				if(deque.isEmpty()) {
					System.out.println("-1");
					break;
				}
				System.out.println(deque.getFirst());
				break;
			case "back":
				if(deque.isEmpty()) {
					System.out.println("-1");
					break;
				}
				System.out.println(deque.getLast());
				break;
 			default:
				break;
			}
		}
	}
}
