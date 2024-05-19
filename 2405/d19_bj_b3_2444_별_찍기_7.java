package a2405;

import java.io.*;

public class d19_bj_b3_2444_별_찍기_7 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int n=1; n<=N; n++){
            for(int m=0; m<N-n; m++){ sb.append(" "); }
            for(int m=0; m<2*n-1; m++){ sb.append("*"); }
            sb.append("\n");
        }
        for(int n=1; n<N; n++){
            for(int m=0; m<n; m++){ sb.append(" "); }
            for(int m=0; m<2*(N-n)-1; m++){ sb.append("*"); }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
