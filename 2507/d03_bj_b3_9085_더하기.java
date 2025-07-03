package a2507;

import java.io.*;
import java.util.*;

public class d03_bj_b3_9085_더하기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sum = 0;
            for(int n=0; n<N; n++){
                sum += Integer.parseInt(st.nextToken());
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
