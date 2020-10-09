package home;

public class Main_KaKao2018_프렌즈4블록 {
	public static int solution(int m, int n, String[] board) {

		char[][] map = new char[m][n];
		boolean[][] flag = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			String temp = board[i];
			for (int j = 0; j < n; j++) {
				map[i][j] = temp.charAt(j);
			}
		}
		int answer = 0;
		int count = 0;
		int delcnt = 0;
		while (true) {
			
			for (int i = 0; i < m - 1; i++) {
				for (int j = 0; j < n - 1; j++) {
					if (map[i][j] != ' ' && map[i][j] == map[i][j + 1] && map[i][j] == map[i + 1][j] && map[i][j] == map[i + 1][j + 1]) {

						flag[i][j] = true;
						flag[i][j + 1] = true;
						flag[i + 1][j] = true;
						flag[i + 1][j + 1] = true;
						count++;
					}
				}
			}
			for(int i = 0; i < m; i++) {
				for(int j = 0; j < n; j++) {
					if(flag[i][j]) {
						map[i][j] = ' ';
						flag[i][j] = false;
						delcnt++;
					}
				}
			}
			for(int j = 0 ; j < n ; j++) {
				for(int i = m - 1 ; i >= 0 ; i--) {
					if(map[i][j] == ' ') {
						for(int ni = i - 1 ; ni >= 0 ; ni--) {
							if(map[ni][j] != ' ') {
								map[i][j] = map[ni][j];
								map[ni][j] = ' ';
								break;
							}
						}
					}
				}
			}
			if(count == 0) {
				break;
			}
			answer += delcnt;
			count = 0;
			delcnt = 0;
		}
		return answer;
	}

	public static void main(String[] args) {

		int m = 6;
		int n = 6;

		String[] map = { "TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ" };
		System.out.println(solution(m, n, map));
	}
}
