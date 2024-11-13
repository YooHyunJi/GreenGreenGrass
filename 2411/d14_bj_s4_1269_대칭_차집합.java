package a2411;

import java.io.*;
import java.util.*;

public class d14_bj_s4_1269_대칭_차집합 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        HashSet<Integer> set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for(int a=0; a<A; a++){
            int num = Integer.parseInt(st.nextToken());
            set.add(num);
        }
        st = new StringTokenizer(br.readLine());
        int dupCnt = 0;
        for(int b=0; b<B; b++){
            int num = Integer.parseInt(st.nextToken());
            if(set.contains(num)){
                dupCnt++;
            }
        }
        int answer = A + B - 2 * dupCnt;
        System.out.println(answer);
    }
}
