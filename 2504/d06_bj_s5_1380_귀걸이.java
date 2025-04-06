package a2504;

import java.io.*;
import java.util.*;

public class d06_bj_s5_1380_귀걸이 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int round = 1;
        int N = Integer.parseInt(br.readLine());
        while(N != 0){
            String[] name = new String[N];
            for(int n=0; n<N; n++){
                name[n] = br.readLine();
            }
            HashSet<Integer> set = new HashSet<>();
            for(int n=0; n<2*N-1; n++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken()) - 1;
                if(!set.contains(num)){
                    set.add(num);
                }
                else{
                    set.remove(num);
                }
            }
            sb.append(round++).append(" ");
            for(int idx: set){
                sb.append(name[idx]).append("\n");
            }
            N = Integer.parseInt(br.readLine());
        }
        System.out.println(sb);
    }
}
