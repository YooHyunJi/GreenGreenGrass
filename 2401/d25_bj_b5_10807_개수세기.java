package a2401;

import java.io.*;
import java.util.*;

public class d25_bj_b5_10807_개수세기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(br.readLine());
        int answer = 0;
        for(int n=0; n<N; n++){ if(Integer.parseInt(st.nextToken())==v) { answer++; } }
        System.out.println(answer);
    }
}