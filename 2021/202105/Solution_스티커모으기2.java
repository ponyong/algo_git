package Algo_Study_Programmers;

public class Solution_스티커모으기2 {
    public static int solution(int sticker[]) {
        int answer = 0;

        if(sticker.length == 1) {
        	return sticker[0];
        }
        
        int[][] dp = new int[2][sticker.length];

        dp[0][0] = sticker[0];
        dp[0][1] = sticker[0];
        
        dp[1][0] = 0;
        dp[1][1] = sticker[1];
        
        for(int i = 2; i < sticker.length; i++) {
        	dp[0][i] = Math.max(dp[0][i-2] + sticker[i], dp[0][i-1]);
        	dp[1][i] = Math.max(dp[1][i-2] + sticker[i], dp[0][i-1]);
        }
        
        return Math.max(dp[0][sticker.length - 2], dp[1][sticker.length - 1]);
        
    }
	public static void main(String[] args) {
		int[] sticker = new int[] {14, 6, 5, 11, 3, 9, 2, 10};
		System.out.println(solution(sticker));
	}
}
