package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10972_다음순열 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(str.nextToken());
		}
		
		if(nextPermutation(arr)) {
			for(int i = 0; i < N; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
		else {
			System.out.println("-1");
		}
	}

	private static boolean nextPermutation(int[] arr) {
		int l = arr.length - 1;
		while(l > 0 && arr[l-1] >= arr[l]) {
			l--;
		}
		
		if(l <= 0) {
			return false;
		}
		
		int t = arr.length - 1;
		while(arr[t-1] >= arr[t]) {
			t--;
		}
		
		int tmp = arr[l-1];
		arr[l-1] = arr[t];
		arr[t] = tmp;
		
		int start = l;
		int end = arr.length - 1;
		
		while(start < end) {
			tmp = arr[start];
			arr[start] = arr[end];
			arr[end] = tmp;
			start++;
			end--;
		}
		return true;
	}
}
