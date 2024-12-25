package a2412;

import java.io.*;
import java.util.*;

public class d25_bj_s4_2422_한윤정이_이탈리아에_가서_아이스크림을_사먹는데 {

    static int N, M, C = 0;
    static int[] result = new int[3];
    static HashMap<Integer, ArrayList<Integer>> eww;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        eww = new HashMap<>();
        for(int n=0; n<N; n++){
            eww.put(n, new ArrayList<>());
        }

        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            eww.get(a).add(b);
            eww.get(b).add(a);
        }
        makeComb(0, 0);
        System.out.println(C);
    }

    static void makeComb(int cnt, int start){
        if(cnt == 3){
            for(int i=0; i<2; i++){
                for(int j=i+1; j<3; j++){
                    if(eww.get(result[i]).contains(result[j])){
                        return;
                    }
                }
            }
            C++;
            return;
        }
        for(int i=start; i<N; i++){
            result[cnt] = i;
            makeComb(cnt+1, i+1);
        }
    }
}
