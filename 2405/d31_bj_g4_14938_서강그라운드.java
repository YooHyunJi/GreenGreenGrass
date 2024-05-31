package a2405;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class d31_bj_g4_14938_서강그라운드 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] items = new int[N+1];
        for(int n=1; n<=N; n++){
            items[n] = Integer.parseInt(st.nextToken());
        }

        int[][] graph = new int[N+1][N+1];
        for(int r=1; r<=N; r++){
            for(int c=1; c<=N; c++){
                graph[r][c] = 9_999_999;
            }
        }
        for(int r=0; r<R; r++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            graph[a][b] = l;
            graph[b][a] = l;
        }

        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    if(i==j){
                        graph[i][j] = 0;
                        continue;
                    }
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        int answer = 0;
        for(int n=1; n<=N; n++){
            int sum = 0;
            for(int m=1; m<=N; m++){
                if(graph[n][m]<=M){
                    sum += items[m];
                }
            }
            answer = Math.max(answer, sum);
        }
        System.out.println(answer);
    }
}
