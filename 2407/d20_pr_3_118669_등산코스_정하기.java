package a2407;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class d20_pr_3_118669_등산코스_정하기 {
    static ArrayList<int[]>[] graph;
    static int[] state; // 0 쉼터 | 1 출입구 | 2 산봉우리
    static int MIN_TIME = Integer.MAX_VALUE, MIN_SUMMIT = -1;

    public int[] solution(int N, int[][] paths, int[] gates, int[] summits) {

        state = new int[N+1];
        for(int gate: gates){ state[gate] = 1; }
        for(int summit: summits){ state[summit] = 2; }

        graph = new ArrayList[N+1];
        for(int n=1; n<=N; n++){
            graph[n] = new ArrayList();
        }
        for(int[] path: paths){
            int i = path[0];
            int j = path[1];
            int w = path[2];
            graph[i].add(new int[]{j, w});
            graph[j].add(new int[]{i, w});
        }
        for(int gate: gates){
            Dijkstra(gate, N);
        }

        int[] answer = new int[] {MIN_SUMMIT, MIN_TIME};
        return answer;
    }

    static void Dijkstra(int gate, int N){
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->o1[1]-o2[1]);
        boolean[] visit = new boolean[N+1];
        int[] arr = new int[N+1];
        Arrays.fill(arr, 10_000_001);
        pq.offer(new int[]{gate, 0});

        while(!pq.isEmpty()){
            int[] now = pq.poll();
            int idx = now[0];
            int dist = now[1];
            visit[idx] = true;
            if(MIN_TIME < dist){ continue; }

            if(state[idx]==2){
                if(dist == MIN_TIME){
                    MIN_SUMMIT = Math.min(MIN_SUMMIT, idx);
                }
                if(dist < MIN_TIME){
                    MIN_TIME = dist;
                    MIN_SUMMIT = idx;
                }
                continue;
            }

            for(int[] node: graph[idx]){
                int nIdx = node[0];
                int nDist = node[1];

                if(visit[nIdx] || state[nIdx]==1){ continue; }

                if(nDist < arr[nIdx]){
                    arr[nIdx] = nDist;
                    pq.offer(new int[] {nIdx, dist<nDist? nDist: dist});
                }
            }
        }
    }
}
