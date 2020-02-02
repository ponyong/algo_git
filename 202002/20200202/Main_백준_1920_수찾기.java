package home;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main_백준_1920_수찾기 {
	public static int BinarySearchRecursive(int arr[], int target, int low, int high) {
	    if (low > high)
	        return -1;

	    int mid = (low + high) / 2;
	    if (arr[mid] == target)
	        return mid;
	    else if (arr[mid] > target)
	        return BinarySearchRecursive(arr, target, low, mid-1);
	    else
	        return BinarySearchRecursive(arr, target, mid+1, high);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		int[] list = new int[N];
		for(int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(str.nextToken());
		}
		
		Arrays.sort(list);
		
		int M = Integer.parseInt(br.readLine());
		
		str = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			int target = Integer.parseInt(str.nextToken());
			if(BinarySearchRecursive(list, target, 0, list.length - 1) == -1) {
				System.out.println("0");
			}
			else {
				System.out.println("1");
			}
		}
		
	}
}
