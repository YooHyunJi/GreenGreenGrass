package a2406;

public class d13_pr_3_258711_도넛과_막대_그래프 {
    static class Vertex{
        int out;
        int in;

        public Vertex(){
            this.out = 0;
            this.in = 0;
        }
    }

    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        int N = 0;

        for(int[] edge: edges){
            N = Math.max(N, Math.max(edge[0], edge[1]));
        }

        Vertex[] graph = new Vertex[N+1];
        for(int n=1; n<=N; n++){
            graph[n] = new Vertex();
        }

        for(int[] edge: edges){
            graph[edge[0]].out++;
            graph[edge[1]].in++;
        }

        for(int n=1; n<=N; n++){
            if(answer[0]==0 && graph[n].in==0 && 2<=graph[n].out){
                answer[0] = n;
            }
            else if(1<=graph[n].in && graph[n].out==0){
                answer[2]++;
            }
            else if(2<=graph[n].in && 2<=graph[n].out){
                answer[3]++;
            }
        }
        answer[1] = graph[answer[0]].out - (answer[2] + answer[3]);

        return answer;
    }
}
