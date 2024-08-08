package a2408;

import java.util.*;

public class d08_pr_2_42626_더_맵게 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int S = scoville.length;
        for(int s=0; s<S; s++){ pq.offer(scoville[s]); }
        while(pq.peek() < K){
            if(pq.size() == 1){ return -1; }
            answer++;
            int firstScoville = pq.poll();
            int secondScoville = pq.poll();
            int newScoville = firstScoville + 2 * secondScoville;
            pq.offer(newScoville);
        }
        return answer;
    }
}
