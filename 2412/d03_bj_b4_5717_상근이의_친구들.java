package a2412;

import java.io.*;
import java.util.*;

public class d03_bj_b4_5717_상근이의_친구들 {
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int F = Integer.parseInt(st.nextToken());
            if(M == 0 && F == 0){ break; }
            sb.append(M + F).append("\n");
        }
        System.out.println(sb);
    }
}
