package home;
import java.util.*;
class Line4 {
	public static String[][] solution(String[][] snapshots, String[][] transactions) {
		String[][] answer = {};
		TreeMap<String, Integer> a = new TreeMap();
		int n = snapshots.length;
		int m = transactions.length;
		for (int i = 0; i < n; i++) {
			a.put(snapshots[i][0], Integer.parseInt(snapshots[i][1]));
		}
		Set<String> distinctTransactions = new HashSet<String>();
		for (int i = 0; i < m; i++) {
			if (!distinctTransactions.contains(transactions[i][0])) {
				// a[transactions[i][2]]이 존재하면
				if (a.containsKey(transactions[i][2])) {
					Integer cur = a.get(transactions[i][2]);
					System.out.println(cur);
					if (transactions[i][1].equals("SAVE")) {
						a.put(transactions[i][2], cur + Integer.parseInt(transactions[i][3]));
					} else {
						a.put(transactions[i][2], cur - Integer.parseInt(transactions[i][3]));
					}
				} else {
					if (transactions[i][1].equals("SAVE")) {
						a.put(transactions[i][2], Integer.parseInt(transactions[i][3]));
					} else { // err case
						a.put(transactions[i][2], -Integer.parseInt(transactions[i][3]));
					}
				}
				distinctTransactions.add(transactions[i][0]);
			}
		}
		int answerCnt = a.size();
		int idx = 0;
		answer = new String[answerCnt][2];
		Iterator<String> iteratorKey = a.keySet().iterator();
		while (iteratorKey.hasNext()) {
			String key = iteratorKey.next();
			answer[idx] = new String[2];
			answer[idx][0] = key;
			answer[idx][1] = Integer.toString(a.get(key));
			idx++;
        }
		return answer;
	}
	   public static void main(String[] args) throws Exception {
	       String[][] snapshots = {{"ACCOUNT1", "100"}, {"ACCOUNT2", "150"}};
	       String[][] transactions = {
	           {"1", "SAVE", "ACCOUNT2", "100"},
	           {"2", "WITHDRAW", "ACCOUNT1", "50"},
	           {"1", "SAVE", "ACCOUNT2", "100"},
	           {"4", "SAVE", "ACCOUNT3", "500"},
	           {"3", "WITHDRAW", "ACCOUNT2", "30"}
	           };
	       String[][] asdf = solution(snapshots, transactions);
	       for (int i=0;i<asdf.length;i++) {
	            System.out.println(asdf[i][0] + " " + asdf[i][1]);
	       }
	   }
}