package a2401;

import java.io.*;

public class d22_bj_b5_25314_코딩은체육과목입니다 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int n=1; n<=N; n+=4) { sb.append("long "); }
        sb.append("int");
        System.out.println(sb);
    }
}