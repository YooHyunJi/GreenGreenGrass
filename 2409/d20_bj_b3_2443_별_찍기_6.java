package a2409;

import java.io.*;

public class d20_bj_b3_2443_별_찍기_6 {
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int r=0; r<N; r++){
            for(int c=0; c<r; c++){
                sb.append(" ");
            }
            for(int c=0; c<2*(N-r)-1; c++){
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
