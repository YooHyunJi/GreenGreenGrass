package a2404;

import java.io.*;
import java.util.*;

public class d03_bj_s4_14425_문자열_집합 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<String> list = new ArrayList<>();
        int answer = 0;
        for(int n=0; n<N; n++){ list.add(br.readLine()); }
        for(int m=0; m<M; m++){
            if(list.contains(br.readLine())){ answer++; }
        }
        System.out.println(answer);
    }
}
