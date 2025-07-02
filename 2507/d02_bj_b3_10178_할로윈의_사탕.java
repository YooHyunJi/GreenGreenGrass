package a2507;

import java.io.*;
import java.util.*;

public class d02_bj_b3_10178_할로윈의_사탕 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int n=0; n<N; n++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int x = A / B;
            int y = A % B;
            sb.append("You get ")
                .append(x)
                .append(" piece(s) and your dad gets ")
                .append(y)
                .append(" piece(s).\n");
        }
        System.out.println(sb);
    }
}
