package a2412;

import java.io.*;
import java.util.*;

public class d31_bj_s4_1822_차집합 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        TreeSet<Integer> set = new TreeSet<>();
        st = new StringTokenizer(br.readLine());
        for(int a=0; a<A; a++){
            set.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for(int b=0; b<B; b++){
            Integer num = Integer.parseInt(st.nextToken());
            set.remove(num);
        }
        if(set.isEmpty()){
            System.out.println(0);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(set.size()).append("\n");
        for(int s: set){
            sb.append(s).append(" ");
        }
        System.out.println(sb);
    }
}
