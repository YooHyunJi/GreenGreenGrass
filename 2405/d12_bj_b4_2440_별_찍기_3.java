package a2405;

import java.io.*;

public class d12_bj_b4_2440_별_찍기_3 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i=N; 1<=i; i--){
            for(int j=0; j<i; j++){ sb.append("*"); }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
