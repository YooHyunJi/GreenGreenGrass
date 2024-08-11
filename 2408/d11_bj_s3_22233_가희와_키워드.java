package a2408;

import java.io.*;
import java.util.*;

public class d11_bj_s3_22233_가희와_키워드 {
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashSet<String> set =  new HashSet<>();
        for(int n=0; n<N; n++){
            set.add(br.readLine());
        }
        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine(), ",");
            while(st.hasMoreTokens()){
                set.remove(st.nextToken());
            }
            sb.append(set.size()).append("\n");
        }
        System.out.println(sb);
    }
}
