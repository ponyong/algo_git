class Pair implements Comparable<Pair> {
    int x,y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int[] makeArray() {
        return new int[] {x+1, y+1};
    }

    static Pair makePair(int x, int y) {
        return new Pair(x,y);
    }

    @Override
    public int compareTo(Pair o) {
        return (o.x - o.y) - (x - y);
    }
}

class Solution {

    public int[] solution(String[] gems) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        Set<String> check = new HashSet<>();
        for (String iter : gems) {
            check.add(iter);
        }

        for (int i = 0; i < gems.length; i++) {
            Set<String> iter = new HashSet<>();
            iter.add(gems[i]);
            for (int j = i; j < gems.length; j++) {
                iter.add(gems[j]);
                if (iter.size() == check.size()) {
                    pq.add(Pair.makePair(i,j));
                }
            }
        }
        

        return pq.poll().makeArray();
    }
}


#include <string>
#include <vector>
#include <map>
#include <set>
#include <queue>
#include <iostream>
using namespace std;

vector<int> solution(vector<string> gems) {
   int N = gems.size();
   vector<int> a(N);
   map<string, int> mp;
   int jewerlyCount = 0;
   for (int i = 0; i < N; i++) {
      if (mp[gems[i]] == 0) mp[gems[i]] = ++jewerlyCount;
      a[i] = mp[gems[i]];
   }
   int existCount = 0, p = 0;
   vector<int> cnt(N+1);
   int ans = 2147483647, st = 2147483647, ed = 2147483647;
   for (int q=0; q<N; q++) {
      cnt[a[q]]++; //q번째 수를 구간에 추가하고, 갯수 카운팅
      if (cnt[a[q]] == 1) existCount++;
      while (cnt[a[p]] >= 2) { //맨 앞의 숫자가 이미 2번 이상 나왔다면 p++
         cnt[a[p]]--;
         p++;
      }
      if (existCount == jewerlyCount) { // 구간 [p,q]에 모든 수가 다 들어있다면
         if (ans > q-p+1 || (ans == q-p+1 && st > p)) {
            ans = q-p+1;
            st = p, ed = q;
         }
      }
   }
   return { st+1, ed+1 };
}

int main()
{
   vector<string> gems ={
      "DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"
   };
   vector<int> k = solution(gems);
   cout << k[0] <<" " << k[1] << endl;
   return 0;
}