
package a2404;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class d11_bj_g3_2533_사회망_서비스_SNS {
    static int N;
    static int[][] dp;
    static boolean[] v;
    static List<Integer>[] tree;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1][2];
        v = new boolean[N+1];
        tree = new ArrayList[N+1];
        for(int n=1; n<=N; n++){
            tree[n] = new ArrayList<>();
        }
        for(int n=0; n<N-1; n++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }
        makeDP(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    static void makeDP(int idx){
        v[idx] = true;
        dp[idx][0] = 0;
        dp[idx][1] = 1;

        for(int child: tree[idx]){
            if(v[child]){ continue; }
            makeDP(child);
            dp[idx][0] += dp[child][1];
            dp[idx][1] += Math.min(dp[child][0], dp[child][1]);
        }
    }
}