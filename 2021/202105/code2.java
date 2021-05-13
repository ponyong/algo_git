package code_Challenge2;

public class code2 {
    public static long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        int idx = 0;
        for(long number : numbers) {
        	
            long[] arr = new long[100];
            int cnt = 0;
            
            while(number > 0) {
                arr[cnt++] = number % 2;
                number /= 2;
            }
            
            int k = cnt;
            
            for(int i = 0; i < cnt; i++) {
                if(arr[i] == 0) {
                    k = i;
                    break;
                }
            }
            
            arr[k] = 1;
            
            if(k != 0) {
                arr[k - 1] = 0;
            }
            
            long result = 0;
            
            for(int i = cnt; i >= 0; i--) {
                result = result * 2 + arr[i];
            }
            
            answer[idx++] = result;
        }     
        return answer;
    }
	public static void main(String[] args) {
		long[] numbers = new long[] { 2, 7 };
		solution(numbers);
	}
}
