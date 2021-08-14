package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_1920_수찾기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // N개 의 수
		
		int[] Nlist = new int[N];
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			Nlist[i] = Integer.parseInt(str.nextToken());
		}
		
		Arrays.sort(Nlist);
		
		int M = Integer.parseInt(br.readLine()); 
		
		StringTokenizer tmp = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			if(BSearch(Nlist, Integer.parseInt(tmp.nextToken())) == -1) {
				System.out.println("0");
			}
			else {
				System.out.println("1");
			}
		}
		
	}
	static int BSearch(int arr[], int target) {
	    int low = 0;
	    int high = arr.length - 1;
	    int mid;

	    while(low <= high) {
	        mid = (low + high) / 2;

	        if (arr[mid] == target)
	            return mid;
	        else if (arr[mid] > target)
	            high = mid - 1;
	        else
	            low = mid + 1;
	    }
	    return -1;
	}
}
