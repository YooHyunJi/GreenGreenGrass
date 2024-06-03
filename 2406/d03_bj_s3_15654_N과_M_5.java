import java.io.*;
import java.util.*;

public class d03_bj_s3_15654_N과_M_5 {
    static int N, M;
    static int[] num, result;
    static boolean[] v;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new int[N];
        result = new int[M];
        v = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){
            num[n] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        makePerm(0);
        System.out.println(sb);
    }
    
    static void makePerm(int cnt){
        if(cnt == M){
            for(int m=0; m<M; m++){
                sb.append(result[m]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=0; i<N; i++){
            if(v[i]){ continue; }
            v[i] = true;
            result[cnt] = num[i];
            makePerm(cnt+1);
            v[i] = false;
        }
    }
}
