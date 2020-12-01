package home;
import java.util.*;
class K_Test {
    int[][] array = {{0,1,2},{0,2,1},{1,0,2},{1,2,0},{2,0,1},{2,1,0}};
    int[] perm;
    private int calc(String str, int st, int ed) {
        int sol = 0;
        for (int i = st; i <= ed; i++) {
            sol = ((sol * 10) + (str.charAt(i) - '0'));
        }
        return sol;
    }

    private int priority(int k, int[] permutaion) {
        if (k == -3)
            return permutaion[0];
        if (k == -2)
            return permutaion[1];
        return permutaion[2];
    }

    public long solution(String expression) {

        int N = expression.length() - 1;
        int idx = -1;
        List<Integer> exp = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();

        map.put('+', -3);
        map.put('-', -2);
        map.put('*', -1);

        for (int i = 0; i < N; i++) {
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*') {
                exp.add(calc(expression, idx + 1, i - 1));
                exp.add(map.get(expression.charAt(i)));
                idx = i;
            }
        }
        exp.add(calc(expression, idx + 1, N - 1));
        int M = exp.size();

        perm = new int[] { 0, 1, 2 };
        long result = 0;
        for (int k = 0; k < 6; k++) {
        	List<Integer> postExp = new ArrayList<>();
        	Stack<Integer> st = new Stack<>();
        	perm[0]=array[k][0];
        	perm[1]=array[k][1];
        	perm[2]=array[k][2];
            for (int i = 0; i < M; i++) {
                if (exp.get(i) >= 0) {
                    postExp.add(exp.get(i));
                } else {
                    while (!st.empty() && priority(exp.get(i), perm) <= priority(st.peek(), perm)) {
                        postExp.add(st.pop());
                    }
                    st.add(exp.get(i));
                }
            }
            while (!st.empty()) {
                postExp.add(st.pop());
            }
            Stack<Long> nst = new Stack<>();
            for (int i = 0; i < postExp.size(); i++) {
                long num = postExp.get(i);
                if (num >= 0) {
                    nst.add(num);
                } else {
                    if (num == -3) {
                        long k2 = nst.pop();
                        long k1 = nst.pop();
                        nst.add(k1 + k2);
                    } else if (num == -2) {
                        long k2 = nst.pop();
                        long k1 = nst.pop();
                        nst.add(k1 - k2);
                    } else {
                        long k1 = nst.pop();
                        long k2 = nst.pop();
                        nst.add(k1 * k2);
                    }
                }
            }
            result = Math.max(result, Math.abs(nst.peek()));
            
        }

        return result;
    }
}